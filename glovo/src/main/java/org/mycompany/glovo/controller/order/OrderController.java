package org.mycompany.glovo.controller.order;

import lombok.RequiredArgsConstructor;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.service.order.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@RestController

public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("orderId") Integer orderId) {
        OrderDto orderDto = orderService.getOrderById(orderId);
        if (orderDto != null) {
            return ResponseEntity.ok(orderDto);
        }
        return (ResponseEntity<OrderDto>) ResponseEntity.notFound();
    }

    @CrossOrigin("*")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(@RequestBody OrderDto orderDto) {
        orderService.save(orderDto);
    }

    @PutMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateOrderById(@PathVariable("orderId") Integer orderId, @RequestBody OrderDto orderDto) {
        orderService.updateOrder(orderId, orderDto);
    }

    @DeleteMapping("/{orderId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrderById(@PathVariable("orderId") Integer orderId) {
        orderService.delete(orderId);
    }

}
