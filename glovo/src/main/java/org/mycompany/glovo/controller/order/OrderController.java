package org.mycompany.glovo.controller.order;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.mycompany.glovo.controller.responce.ApiResponse;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.service.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@RestController

public class OrderController {
    private final OrderService orderService;


    @CrossOrigin("*")
    @GetMapping()
    public ApiResponse<List<OrderDto>> getOrders(@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
                                                 @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
                                                 @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
                                                 @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.DESC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        ApiResponse<List<OrderDto>> response = new ApiResponse<>();
        List<OrderDto> orders = orderService.getOrders(pageable);
        if (!CollectionUtils.isEmpty(orders)) {
            response.setSuccess(true);
            response.setData(orders);
        }
        return response;
    }

    @CrossOrigin("*")
    @GetMapping("/{orderId}")
    public ApiResponse<OrderDto> getOrderById(@PathVariable("orderId") Integer orderId) {
        ApiResponse<OrderDto> response = new ApiResponse<>();
        OrderDto orders = orderService.getOrderById(orderId);
        if (orders != null) {
            response.setSuccess(true);
            response.setData(orders);
        }
        return response;
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
