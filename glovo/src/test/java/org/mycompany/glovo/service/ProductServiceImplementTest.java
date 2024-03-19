package org.mycompany.glovo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.mappers.ProductMapper;
import org.mycompany.glovo.model.Product;
import org.mycompany.glovo.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplementTest {
    private static final int PRODUCT_ID = 100;
    @InjectMocks
    private ProductServiceImplement testInstance;
    @Mock
    private ProductMapper productMapper;
    @Mock
    private ProductRepository productRepository;
    @Mock
    private Product product;
    @Mock
    private List<Product> productsList;
    @Mock
    private Page<Product> page;

    private ProductDto dto;

    @BeforeEach
    public void init() {
        dto = new ProductDto();
        dto.setId(PRODUCT_ID);
        dto.setCost(25.0);
    }

    @Test
    void shouldReturnProductById() {
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        when(productMapper.productToProductDto(product)).thenReturn(dto);

        ProductDto result = testInstance.getProductById(PRODUCT_ID);

        verify(productRepository).findById(PRODUCT_ID);
        verify(productMapper).productToProductDto(product);
        assertNotNull(result);
        assertEquals(PRODUCT_ID, result.getId());
    }

    @Test
    void shouldReturnListProducts() {
        Pageable pageable = PageRequest.of(1, 1, Sort.unsorted());
        List<ProductDto> list = new ArrayList<>();
        list.add(dto);

        when(productRepository.findAll((Pageable) any())).thenReturn(page);
        when(page.getContent()).thenReturn(productsList);
        when(productMapper.toProductDtoList(productsList)).thenReturn(list);

        testInstance.getProducts(pageable);
        assertNotNull(list);
    }

    @Test
    void shouldCreateNewProduct() {
        int id = 102;
        double cost = 0.5;
        ProductDto newDto = new ProductDto(id, null, cost, null);

        when(productMapper.productDtoToProduct(newDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);

        testInstance.save(newDto);

        assertEquals(id, newDto.getId());
        assertEquals(cost, newDto.getCost());
    }


    @Test
    void shouldNotReturnDeletedProductById() {

        doNothing().when(productRepository).deleteById(anyInt());

        testInstance.deleteProduct(PRODUCT_ID);

        verify(productRepository).deleteById(PRODUCT_ID);

    }

}