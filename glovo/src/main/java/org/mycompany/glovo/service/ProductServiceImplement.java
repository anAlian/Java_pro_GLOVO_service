package org.mycompany.glovo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.mappers.ProductMapper;

import org.mycompany.glovo.model.Product;
import org.mycompany.glovo.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow();
        return productMapper.productToProductDto(product);
    }

    @Override
    public List<ProductDto> getProducts(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> products = page.getContent();
        return productMapper.toProductDtoList(products);
    }

    @Override
    public void save(ProductDto dto) {
        Product product = productMapper.productDtoToProduct(dto);
        productRepository.save(product);
    }


    @Override
    public void updateProduct(Integer id, ProductDto productDto) {
        Product old = productRepository.findById(id).orElseThrow();
        Product updated = productMapper.productDtoToProduct( productDto);
        productMapper.update(old,updated);
        productRepository.save(updated);
    }


    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

}
