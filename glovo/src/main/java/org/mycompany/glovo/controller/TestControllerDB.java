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
        return orderService.getOrders();
    }
    @GetMapping("/byId")
    public OrderDto testServiceById() {
        return orderService.getOrderById(7);
    }
    @GetMapping("/save")
    public void testServiceSave() {
        orderService.save(OrderDto.builder()
                .id(7)
                .date(LocalDate.now())
                .cost(117.0)
                .build()
        );
    }
    @GetMapping("/upd")
    public void testServiceUpd() {
        orderService.updateOrder(3,(OrderDto.builder()

                .date(LocalDate.now())
                .cost(1117.0)
                .build()
        ));
    }
    @GetMapping("/del")
    public void testServiceDel() {
         orderService.delete(1);
    }
}
