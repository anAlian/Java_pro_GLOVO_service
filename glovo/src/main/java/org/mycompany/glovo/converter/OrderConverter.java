package org.mycompany.glovo.converter;

import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.model.Order;
import org.mycompany.glovo.model.Product;
import org.springframework.stereotype.Component;

import static org.apache.commons.collections4.CollectionUtils.isNotEmpty;


import java.util.ArrayList;
import java.util.List;


@Component
public class OrderConverter {
    public OrderDto fromModel(Order order) {
        return OrderDto.builder()
                .id(order.getId())
                .date(order.getDate())
                .cost(order.getCost())
                .products(productsFromModel(order.getProducts()))
                .build();
    }

    public Order toModel(OrderDto dto) {
        return Order.builder()
                .date(dto.getDate())
                .cost(dto.getCost())
                .products(productsToModel(dto.getProducts()))
                .build();
    }

    public Order toModel(Order order, OrderDto dto) {
        order.setDate(dto.getDate());
        order.setCost(dto.getCost());
        order.setProducts(productsToModel(dto.getProducts()));
        return order;
    }

    public List<OrderDto> fromModel(Iterable<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(fromModel(order));
        }
        return orderDtos;
    }

    private List<ProductDto> productsFromModel(List<Product> products) {
        List<ProductDto> productDtos = new ArrayList<>();
        if (isNotEmpty(products)) {
            for (Product product : products) {
                ProductDto dto = ProductDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .cost(product.getCost())
                        .orders(product.getOrders())
                        .build();
                productDtos.add(dto);
            }
        }
        return productDtos;
    }

    private List<Product> productsToModel(List<ProductDto> dtos) {
        List<Product> products = new ArrayList<>();
        if (isNotEmpty(dtos)) {
            for (ProductDto dto : dtos) {
                Product product = Product.builder()
                        .id(dto.getId())
                        .name(dto.getName())
                        .cost(dto.getCost())
                        .orders(dto.getOrders())
                        .build();
                products.add(product);
            }
        }
        return products;
    }

}
