package org.mycompany.glovo.service.order.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mycompany.glovo.converter.OrderConverter;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.model.data.Order;
import org.mycompany.glovo.repository.data.OrderRepository;
import org.mycompany.glovo.service.order.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    @Override
    public OrderDto getOrderById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return orderConverter.fromModel(order);
    }

    @Override
    public List<OrderDto> getOrders(Pageable pageable) {
        Page<Order> page = orderRepository.findAll(pageable);
        List<Order> orders = page.getContent();
        return orderConverter.fromModel(orders);
    }

    @Override
    public void save(OrderDto dto) {
        Order order = orderConverter.toModel(dto);
        orderRepository.save(order);
        log.debug("Order save: " + order);
    }

    @Override
    public void updateOrder(Integer id, OrderDto orderDto) {

        Order old = orderRepository.findById(id).orElseThrow();
        Order updated = orderConverter.toModel(old, orderDto);
        orderRepository.save(updated);
        log.debug("Order updated: " + updated);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
        log.debug("Order deleted: " + id);
    }
}
