package org.mycompany.glovo.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mycompany.glovo.controller.responce.ApiResponse;
import org.mycompany.glovo.model.Order;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.model.Product;
import org.mycompany.glovo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class OrderIntegrationTest {
    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void shouldGetOrderById() {
        Order order = Order.builder()
                .date(LocalDate.now())
                .cost(31.1)
                .products(List.of(Product.builder()
                        .cost(22.2)
                        .name("test")
                        .build()))
                .build();
        Order savedOrder = orderRepository.save(order);
        String url = "http://localhost:" + port + "/api/v1/orders/" + savedOrder.getId();


        ResponseEntity<ApiResponse<OrderDto>> response = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<>() {
                });
        ApiResponse<OrderDto> result = response.getBody();

        assert result != null;
        assertEquals(savedOrder.getId(), result.getData().getId());
    }

    @Test
    void shouldAddNewOrder() {

        List<Order> list;

        list = orderRepository.findAll();
        assertEquals(list.size(), 0);

        Order order = Order.builder()
                .date(LocalDate.now())
                .cost(131.1)
                .products(List.of(Product.builder()
                        .cost(22.2)
                        .name("new product")
                        .build()))
                .build();

        String url = "http://localhost:" + port + "/api/v1/orders";

        HttpEntity<Order> request = new HttpEntity<>(order);

        ResponseEntity<Order> response = restTemplate
                .exchange(url, HttpMethod.POST, request, Order.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        ResponseEntity<ApiResponse<List<OrderDto>>> getResponse = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<>() {
                });
        ApiResponse<List<OrderDto>> result = getResponse.getBody();

        assert result != null;
        list = orderRepository.findAll();

        assertEquals(list.size(), 1);
    }
}
