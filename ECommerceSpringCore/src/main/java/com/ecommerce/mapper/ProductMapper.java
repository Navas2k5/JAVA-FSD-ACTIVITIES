package com.ecommerce.mapper;

import com.ecommerce.dto.ProductResponseDto;
import com.ecommerce.model.Product;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements RowMapper<ProductResponseDto> {

    @Override
    public ProductResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductResponseDto(
                rs.getString("product_name"),
                rs.getString("category_name"),
                rs.getString("vendor_name")
        );
    }
}
