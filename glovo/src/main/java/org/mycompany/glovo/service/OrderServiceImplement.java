package org.mycompany.glovo.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mycompany.glovo.converter.OrderConverter;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.mappers.OrderMapper;
import org.mycompany.glovo.model.Order;
import org.mycompany.glovo.repository.OrderRepository;
import org.mycompany.glovo.service.OrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto getOrderById(Integer id) {
        Order order = orderRepository.findById(id).orElseThrow();
        return orderMapper.orderToOrderDto(order);
    }

    @Override
    public List<OrderDto> getOrders(Pageable pageable) {
        Page<Order> page = orderRepository.findAll(pageable);
        List<Order> orders = page.getContent();
        return orderMapper.toOrderDtoList(orders);
    }

    @Override
    public void save(OrderDto dto) {
        Order order = orderMapper.orderDtoToOrder(dto);
        orderRepository.save(order);
        log.debug("Order save: " + order);
    }

    @Override
    public void updateOrder(Integer id, OrderDto orderDto) {

        Order old = orderRepository.findById(id).orElseThrow();
        Order toOrder = orderMapper.orderDtoToOrder(orderDto);

        orderMapper.update(old,toOrder);
        orderRepository.save(toOrder);
        log.debug("Order updated: " + toOrder);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.deleteById(id);
        log.debug("Order deleted: " + id);
    }
}
