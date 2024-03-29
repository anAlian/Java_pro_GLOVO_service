package org.mycompany.glovo.service;
import org.mycompany.glovo.dto.order.OrderDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    OrderDto getOrderById(Integer id);

    List<OrderDto> getOrders(Pageable pageable);


    void save(OrderDto dto);

    void updateOrder(Integer id, OrderDto orderDto);

    void delete(Integer id);
}
