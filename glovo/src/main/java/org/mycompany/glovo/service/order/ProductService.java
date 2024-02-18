package org.mycompany.glovo.service.order;
import org.mycompany.glovo.dto.order.ProductDto;
import java.util.List;

public interface ProductService {
    ProductDto getProductById(Integer id);
    List<ProductDto> getProducts();
    void save(ProductDto productDto);
    void updateProduct (Integer id, ProductDto productDto);
    void deleteProduct (Integer id);

}
