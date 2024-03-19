package org.mycompany.glovo.service;
import org.mycompany.glovo.dto.order.ProductDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(Integer id);

    List<ProductDto> getProducts(Pageable pageable);

    void save(ProductDto productDto);

    void updateProduct(Integer id, ProductDto productDto);

    void deleteProduct(Integer id);

}
