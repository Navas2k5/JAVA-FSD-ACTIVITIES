package com.ecommerce.mapper;

import com.ecommerce.dto.VendorProdCountDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class VendorProdMapper implements RowMapper<VendorProdCountDto> {

    @Override
    public VendorProdCountDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new VendorProdCountDto(
                rs.getString("vendor_name"),
                rs.getInt("prod_count")
        );
    }
}
