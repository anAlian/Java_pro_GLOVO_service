package org.mycompany.glovo.service.order;
import org.mycompany.glovo.dto.order.OrderDto;
import java.util.List;

public interface OrderService {
    OrderDto getOrderById(Integer id);

    List<OrderDto> getOrders();

    OrderDto save(OrderDto dto);

    void updateOrder(Integer id, Double price);

    void delete(Integer id);
}
