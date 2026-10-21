package com.ecommerce.repository;

import com.ecommerce.dto.ProductResponseDto;
import com.ecommerce.dto.VendorProdCountDto;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.mapper.VendorProdMapper;
import com.ecommerce.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository {

    private final JdbcTemplate jdbcTemplate;
    private final ProductMapper productMapper;
    private final VendorProdMapper vendorProdMapper;

    public ProductRepository(JdbcTemplate jdbcTemplate, ProductMapper productMapper, VendorProdMapper vendorProdMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productMapper = productMapper;
        this.vendorProdMapper = vendorProdMapper;
    }

    public void saveProduct(Product product) {
        String sql = """
                insert into product (name,price,stock_quantity,category_id,vendor_id) values (?,?,?,?,?)
                """;

        Object[] values = new Object[]{product.getName(),product.getPrice(),product.getStockQuantity(),product.getCategoryId(),product.getVendorId()};

        jdbcTemplate.update(sql,values);
        System.out.println("Product added successfully...");

    }


    public ProductResponseDto getProductById(Long id) {
        String sql = """
                select p.name as product_name,
                c.name as category_name,
                v.name as vendor_name
                from product p
                join category c on p.category_id = c.id
                join vendor v on p.vendor_id = v.id
                where p.id = ?
                """;

        return jdbcTemplate.queryForObject(sql, productMapper ,id);
    }

    public void updateStock(Long id, int newQuantity) {
        String sql = """
                update product set stock_quantity = ? where id =?;
                """;

        Object[] values = new Object[]{newQuantity,id};
        jdbcTemplate.update(sql,values);
        System.out.println("Product updated successfully...");
    }


    public Map<String, Integer> countProdByVendor() {
        String sql = """
                select v.name as vendor_name, count(p.id) as prod_count from product p
                join vendor v on v.id =p.vendor_id
                group by v.name;
                """;
        List<VendorProdCountDto> result = jdbcTemplate.query(sql,vendorProdMapper);

        Map<String,Integer> vendorProd = new HashMap<>();

        for(VendorProdCountDto dto : result){
            vendorProd.put(dto.vendorName(),dto.productCount());
        }

        return vendorProd;
    }
}
