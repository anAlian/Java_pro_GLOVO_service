package org.mycompany.glovo.controller;

import org.junit.jupiter.api.Test;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.emptyList;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class OrderControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    void shouldGetOrders() throws Exception {
//        when(orderService.getOrders(Pageable.unpaged()).thenReturn(List.of(OrderDto.builder()
        when(orderService.getOrders(any())).thenReturn(List.of(OrderDto.builder()
                .id(11)
                .cost(11.1)
                .products(emptyList())
                .build()));

        this.mockMvc.perform(get("/api/v1/orders")).andDo(print()).andExpect(status().isOk());
    }
}
