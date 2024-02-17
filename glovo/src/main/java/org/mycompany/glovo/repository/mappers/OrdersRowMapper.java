package org.mycompany.glovo.repository.mappers;

import org.mycompany.glovo.dto.order.OrderDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersRowMapper implements RowMapper<OrderDto> {
    @Override
    public OrderDto mapRow(ResultSet rs, int rowNumber) throws SQLException {
        OrderDto order = new OrderDto();
        order.setId(rs.getInt("id"));
        order.setDate(rs.getDate("date").toLocalDate());
        order.setCost(rs.getDouble("cost"));

        return order;
    }
}
