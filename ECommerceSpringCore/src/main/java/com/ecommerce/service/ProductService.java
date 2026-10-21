package com.ecommerce.service;

import com.ecommerce.dto.ProductResponseDto;
import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    public ProductResponseDto getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    public void updateStock(Long id, int newQuantity) {
        productRepository.updateStock(id, newQuantity);
    }


    public Map<String, Integer> countProdByVendor() {
        return productRepository.countProdByVendor();
    }
}
