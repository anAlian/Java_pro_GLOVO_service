package org.mycompany.glovo.service.order.jpa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.repository.jdbc.OrdersJDBCRepository;
import org.mycompany.glovo.service.order.OrderService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService {

    private final OrdersJDBCRepository ordersJDBCRepository;

    @Override
    public OrderDto getOrderById(Integer id) {
        return ordersJDBCRepository.getById(id);
    }

    @Override
    public List<OrderDto> getOrders() {
        return ordersJDBCRepository.getAll();
    }

    @Override
    public OrderDto save(OrderDto dto) {
        ordersJDBCRepository.save(dto);
        return dto;
    }

    @Override
    public void updateOrder(Integer id, Double price) {
        ordersJDBCRepository.updateOrder(id,price);
    }

    @Override
    public void delete(Integer id) {
        ordersJDBCRepository.deleteById(id);
    }
}
