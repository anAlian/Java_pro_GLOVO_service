package org.mycompany.glovo.repository.jdbc;
import lombok.RequiredArgsConstructor;
import org.mycompany.glovo.dto.order.OrderDto;
import org.mycompany.glovo.repository.mappers.OrdersRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrdersJDBCRepository {
    private final String SELECT_ALL_ORDERS = "SELECT * FROM orders";
    private final String SELECT_ORDER_BY_ID = "SELECT * FROM orders WHERE id = ";
    private final String SAVE_NEW_ORDER = "INSERT INTO orders VALUES ( ?, ?, ?)";
    private final String UPDATE_ORDER = "UPDATE orders set date=?,cost =?  WHERE id = ?";
    private final String DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE id =";


    private final JdbcTemplate jdbcTemplate;

    public List<OrderDto> getAll() {
        List<OrderDto> result = jdbcTemplate.query(SELECT_ALL_ORDERS, new OrdersRowMapper());
        return result;
    }

    public OrderDto getById(int id) {
        OrderDto result = jdbcTemplate.queryForObject(SELECT_ORDER_BY_ID + id, new OrdersRowMapper());
        return result;
    }

    public void save(OrderDto dto) {
        jdbcTemplate.update(SAVE_NEW_ORDER, dto.getId(), dto.getDate(), dto.getCost());
    }

    public void updateOrder(Integer id, OrderDto dto) {

               jdbcTemplate.update(UPDATE_ORDER, dto.getDate(),dto.getCost(),id);
    }

    public void deleteById(Integer id) {
        jdbcTemplate.update((DELETE_ORDER_BY_ID + id));
    }
}
