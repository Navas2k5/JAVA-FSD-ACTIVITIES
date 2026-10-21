package com.ecommerce.main;

import com.ecommerce.config.AppConfig;
import com.ecommerce.dto.ProductResponseDto;
import com.ecommerce.model.Category;
import com.ecommerce.model.Product;
import com.ecommerce.model.Vendor;
import com.ecommerce.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = context.getBean(ProductService.class);

        // TASK 1:------ SAVE PRODUCT-----

        /*
        Product product =new Product("HP RAYZEN", 100000, 6, 6l, 6l);
        productService.saveProduct(product);
        System.out.println("Product added successfully...");
        **/


        //TASK 2:---- GET SINGLE PRODUCT BY PRODUCT ID-----

        /*
        Long id = 5l;
        ProductResponseDto singleProduct = productService.getProductById(id);
        System.out.println(singleProduct);
        **/


        //TASK 3:-----
        /*
        int newQuantity = 20;
        Long id = 5l;
        productService.updateStock(id,newQuantity);
        System.out.println("Product updated successfully...");
        **/

        //TASK 4:-

        Map<String, Integer> result = productService.countProdByVendor();
        System.out.println(result);


    }
}
