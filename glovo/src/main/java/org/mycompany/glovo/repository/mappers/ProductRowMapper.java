package org.mycompany.glovo.repository.mappers;

import org.mycompany.glovo.dto.order.ProductDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<ProductDto> {
    @Override
    public ProductDto mapRow (ResultSet rs, int rowNumber) throws SQLException{
        ProductDto productDto = new ProductDto();
        productDto.setId(rs.getInt("id"));
        productDto.setOrders(rs.getInt("orders"));
        productDto.setName(rs.getString("name"));
        productDto.setCost(rs.getDouble("cost"));
        return productDto;

    }
}
