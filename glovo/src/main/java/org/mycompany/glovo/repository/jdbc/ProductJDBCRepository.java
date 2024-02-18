package org.mycompany.glovo.repository.jdbc;

import lombok.RequiredArgsConstructor;
import org.mycompany.glovo.dto.order.ProductDto;
import org.mycompany.glovo.repository.mappers.ProductRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductJDBCRepository {
    private final String SELECT_ALL_PRODUCTS = "SELECT * FROM product";
    private final String SELECT_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = ";
    private final String SAVE_NEW_PRODUCT = "INSERT INTO product VALUES ( ?, ?, ?, ?)";
    private final String UPDATE_PRODUCT = "UPDATE product set orders=?,name=?, cost =?  WHERE id = ?";
    private final String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE id =";


    private final JdbcTemplate jdbcTemplate;

    public List<ProductDto> getAll() {
        List<ProductDto> result = jdbcTemplate.query(SELECT_ALL_PRODUCTS, new ProductRowMapper());
        return result;
    }

    public ProductDto getById(int id) {
        ProductDto result = jdbcTemplate.queryForObject(SELECT_PRODUCT_BY_ID + id, new ProductRowMapper());
        return result;
    }

    public void save(ProductDto productDto) {
        jdbcTemplate.update(SAVE_NEW_PRODUCT, productDto.getId(), productDto.getOrders(), productDto.getName(), productDto.getCost());
    }

    public void updateOrder(Integer id, ProductDto dto) {

        jdbcTemplate.update(UPDATE_PRODUCT, dto.getOrders(), dto.getName(), dto.getCost(), id);
    }

    public void deleteById(Integer id) {
        jdbcTemplate.update((DELETE_PRODUCT_BY_ID + id));
    }
}
