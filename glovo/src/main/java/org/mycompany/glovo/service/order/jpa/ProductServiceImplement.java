package org.mycompany.glovo.service.order.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.repository.jdbc.ProductJDBCRepository;
import org.mycompany.glovo.service.order.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImplement implements ProductService {
    private final ProductJDBCRepository productJDBCRepository;

    @Override
    public ProductDto getProductById(Integer id) {
        return productJDBCRepository.getById(id);
    }

    @Override
    public List<ProductDto> getProducts() {
        return productJDBCRepository.getAll();
    }

    @Override
    public void save(ProductDto dto) {
        productJDBCRepository.save(dto);
    }

    @Override
    public void updateProduct(Integer id, ProductDto productDto) {
        productJDBCRepository.updateOrder(id, productDto);
    }

    @Override
    public void deleteProduct(Integer id) {
        productJDBCRepository.deleteById(id);
    }

}
