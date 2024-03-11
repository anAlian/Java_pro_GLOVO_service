package org.mycompany.glovo.service.order.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mycompany.glovo.converter.ProductConverter;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.model.data.Product;
import org.mycompany.glovo.repository.data.ProductRepository;
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
    private static final double NEW_COST = 155.0;
    @InjectMocks
    private ProductServiceImplement testInstance;
    @Mock
    private ProductConverter productConverter;
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
        when(productConverter.fromModel(product)).thenReturn(dto);

        ProductDto result = testInstance.getProductById(PRODUCT_ID);

        verify(productRepository).findById(PRODUCT_ID);
        verify(productConverter).fromModel(product);
        assertNotNull(result);
        assertEquals(PRODUCT_ID, result.getId());
    }

    @Test
    void shouldReturnListProducts() {
        Pageable pageable = PageRequest.of(1, 1, Sort.unsorted());
        List<ProductDto> list = new ArrayList<>();
        list.add(dto);

        when(productRepository.findAll(any())).thenReturn(page);
        when(page.getContent()).thenReturn(productsList);
        when(productConverter.fromModel(productsList)).thenReturn(list);

        testInstance.getProducts(pageable);
        assertNotNull(list);
    }

    @Test
    void shouldCreateNewProduct() {
        int id = 102;
        double cost = 0.5;
        ProductDto newDto = new ProductDto(id, null, cost, null);

        when(productConverter.toModel(newDto)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);

        testInstance.save(newDto);

        assertEquals(id, newDto.getId());
        assertEquals(cost, newDto.getCost());
    }

    @Test
    void shouldReturnUpdatedProductById() {
        ProductDto updated = new ProductDto(PRODUCT_ID, null, NEW_COST, null);
        when(productRepository.findById(anyInt())).thenReturn(Optional.of(product));
        when(productConverter.toModel(product, updated)).thenReturn(product);

        testInstance.updateProduct(PRODUCT_ID, updated);

        assertEquals(NEW_COST, updated.getCost());
    }

    @Test
    void shouldNotReturnDeletedProductById() {

        doNothing().when(productRepository).deleteById(anyInt());

        testInstance.deleteProduct(PRODUCT_ID);

        verify(productRepository).deleteById(PRODUCT_ID);

    }

}