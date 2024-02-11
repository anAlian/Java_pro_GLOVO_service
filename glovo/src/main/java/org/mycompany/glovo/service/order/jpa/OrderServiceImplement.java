package org.mycompany.glovo.service.order.jpa;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.service.order.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService {
    private final Map<Integer, OrderDto> orders = new HashMap<>();

    @Override
    public OrderDto getOrderById(Integer id) {
        return orders.get(id);
    }

    @Override
    public List<OrderDto> getOrders() {
        return new ArrayList<>(orders.values());
    }

    @Override
    public void save(OrderDto dto) {
        orders.put(dto.getId(), dto);
    }

    @Override
    public void updatePrice(Integer id, double newCost) {
        for (Map.Entry<Integer, OrderDto> mapEl : orders.entrySet()) {
            if (mapEl.getKey().equals(id)) {
                OrderDto dto = mapEl.getValue();
                dto.setCost(newCost);
            }
        }
    }


    @Override
    public void delete(Integer id) {
        orders.remove(id);
    }
}
