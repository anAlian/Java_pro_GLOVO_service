package org.mycompany.glovo.service.order.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mycompany.glovo.converter.OrderConverter;
import org.mycompany.glovo.converter.ProductConverter;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.model.data.Order;
import org.mycompany.glovo.model.data.Product;
import org.mycompany.glovo.repository.data.ProductRepository;
import org.mycompany.glovo.repository.jdbc.ProductJDBCRepository;
import org.mycompany.glovo.service.order.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @Override
    public ProductDto getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow();
        return productConverter.fromModel(product);
    }

    @Override
    public List<ProductDto> getProducts(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);
        List<Product> products = page.getContent();
        return productConverter.fromModel(products);
    }

    @Override
    public void save(ProductDto dto) {
        Product product = productConverter.toModel(dto);
        productRepository.save(product);
    }


    @Override
    public void updateProduct(Integer id, ProductDto productDto) {
        Product old = productRepository.findById(id).orElseThrow();
        Product updated = productConverter.toModel(old, productDto);
        productRepository.save(updated);
    }


    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

}
