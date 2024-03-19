package org.mycompany.glovo.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.model.Order;

import java.util.List;

@Mapper(uses = ProductMapper.class)
public interface OrderMapper {
    @Mapping(target = "products", source = "products")
    Order orderDtoToOrder(OrderDto dto);
    @Mapping(target = "products", source = "products")
    OrderDto orderToOrderDto(Order order);

    List<OrderDto> toOrderDtoList(Iterable<Order> orders);

    void update(@MappingTarget Order target, Order source);
}
