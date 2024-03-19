package org.mycompany.glovo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.model.Order;
import org.mycompany.glovo.model.Product;

import java.util.List;

@Mapper
public interface ProductMapper {
    ProductDto productToProductDto(Product product);
    Product productDtoToProduct(ProductDto dto);
    void update(@MappingTarget Product target, Product source);
    List<ProductDto> toProductDtoList(List<Product> products);
    List<Product> toProductList(List<ProductDto> dtos);
}
