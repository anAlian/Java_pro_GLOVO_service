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
//        OrderDto dto = ordersJDBCRepository.getById(id);
//        OrderDto newOrder = new OrderDto();
//        newOrder.setId(id);
//        newOrder.setDate(dto.getDate());
//        newOrder.setCost(price);
//        ordersJDBCRepository.deleteById(dto.getId());
        ordersJDBCRepository.updateOrder(id,price);

    }
//    @Override
//    public OrderDto updateOrder1(Integer id, Double price) {
//        OrderDto dto = ordersJDBCRepository.getById(id);
//        OrderDto newOrder = new OrderDto();
//        newOrder.setId(id);
//        newOrder.setDate(dto.getDate());
//        newOrder.setCost(price);
//        ordersJDBCRepository.deleteById(dto.getId());
//        ordersJDBCRepository.save(newOrder);
//        return newOrder;
//    }


    @Override
    public void delete(Integer id) {
        ordersJDBCRepository.deleteById(id);
    }
}
