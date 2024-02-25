package org.mycompany.glovo.converter;

import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.model.data.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductConverter {
    public ProductDto fromModel(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .orders(product.getOrders())
                .build();
    }

    public Product toModel(ProductDto dto) {
        return Product.builder()
                .name(dto.getName())
                .cost(dto.getCost())
                .orders(dto.getOrders())
                .build();
    }

    public Product toModel(Product product, ProductDto dto) {
        product.setName(dto.getName());
        product.setCost(dto.getCost());
        product.setOrders(dto.getOrders());
        return product;
    }

    public List<ProductDto> fromModel(Iterable<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(fromModel(product));
        }
        return productDtos;
    }

}
