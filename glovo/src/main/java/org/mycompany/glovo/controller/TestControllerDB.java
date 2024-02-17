package org.mycompany.glovo.controller;
import lombok.RequiredArgsConstructor;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.service.order.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test/db")
public class TestControllerDB {
    private final OrderService orderService;
    @GetMapping()
    public List<OrderDto> testService() {
        List<OrderDto> orders = orderService.getOrders();
        return orders;
    }
    @GetMapping("/byId")
    public OrderDto testServiceById() {
        OrderDto orders = orderService.getOrderById(7);
        return orders;
    }
    @GetMapping("/save")
    public OrderDto testServiceSave() {
        OrderDto orders = orderService.save(OrderDto.builder()
                .id(7)
                .date(LocalDate.now())
                .cost(117.0)
                .build()
        );
        return orders;
    }
    @GetMapping("/upd")
    public void testServiceUpd() {
        orderService.updateOrder(3,1415.0);
    }
    @GetMapping("/del")
    public void testServiceDel() {
         orderService.delete(1);
    }
}
