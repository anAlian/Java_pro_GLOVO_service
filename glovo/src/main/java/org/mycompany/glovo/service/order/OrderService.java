package org.mycompany.glovo.service.order;

import org.mycompany.glovo.dto.order.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto getOrderById(Integer id);

    List<OrderDto> getOrders();

    void save(OrderDto dto);


    void updatePrice(Integer id, double newCost);

    void delete(Integer id);
}
