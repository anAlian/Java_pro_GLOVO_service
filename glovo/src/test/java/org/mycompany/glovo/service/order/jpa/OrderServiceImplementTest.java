package org.mycompany.glovo.service.order.jpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mycompany.glovo.converter.OrderConverter;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.model.data.Order;
import org.mycompany.glovo.repository.data.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class OrderServiceImplementTest {
    private static final int ORDER_ID = 100;
    private static final double NEW_COST = 155.0;
    @InjectMocks
    private OrderServiceImplement testInstance;
    @Mock
    private OrderConverter orderConverter;
    @Mock
    private OrderRepository orderRepository;
    @Mock
    private Order order;
    @Mock
    private List<Order> orders;
    @Mock
    private Page<Order> page;

    private OrderDto dto;


    @BeforeEach
    public void init() {
        dto = new OrderDto();
        dto.setId(ORDER_ID);
        dto.setCost(25.0);
    }

    @Test
    void shouldReturnOrderById() {
        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));
        when(orderConverter.fromModel(order)).thenReturn(dto);

        OrderDto result = testInstance.getOrderById(ORDER_ID);

        verify(orderRepository).findById(ORDER_ID);
        verify(orderConverter).fromModel(order);
        assertNotNull(result);
        assertEquals(ORDER_ID, result.getId());
    }

    @Test
    void shouldReturnListOrders() {
        Pageable pageable = PageRequest.of(1, 1, Sort.unsorted());
        List<OrderDto> list = new ArrayList<>();
        list.add(dto);

        when(orderRepository.findAll(any())).thenReturn(page);
        when(page.getContent()).thenReturn(orders);
        when(orderConverter.fromModel(orders)).thenReturn(list);


        testInstance.getOrders(pageable);
        assertNotNull(list);
    }

    @Test
    void shouldCreateNewOrder() {
        int id = 102;
        double cost = 0.5;
        OrderDto newDto = new OrderDto(id, null, cost, null);

        when(orderConverter.toModel(newDto)).thenReturn(order);
        when(orderRepository.save(order)).thenReturn(order);

        testInstance.save(newDto);

        assertEquals(id, newDto.getId());
        assertEquals(cost, newDto.getCost());
    }

    @Test
    void shouldReturnUpdatedOrderById() {
        OrderDto updated = new OrderDto(ORDER_ID, null, NEW_COST, null);
        when(orderRepository.findById(anyInt())).thenReturn(Optional.of(order));
        when(orderConverter.toModel(order, updated)).thenReturn(order);

        testInstance.updateOrder(ORDER_ID, updated);

        assertEquals(NEW_COST, updated.getCost());
    }

    @Test
    void shouldNotReturnDeletedOrderById() {

        doNothing().when(orderRepository).deleteById(anyInt());

        testInstance.delete(ORDER_ID);

        verify(orderRepository).deleteById(ORDER_ID);
    }

    @Test
    void shouldNotReturnOrderById() {
        assertThrows(NoSuchElementException.class, () -> {
            testInstance.getOrderById(12);
        });
    }


}