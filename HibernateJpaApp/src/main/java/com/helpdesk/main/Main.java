package com.helpdesk.main;

import com.helpdesk.config.AppConfig;
import com.helpdesk.model.Customer;
import com.helpdesk.service.CustomerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        CustomerService customerService = context.getBean(CustomerService.class);

        customerService.insert("Harry Potter", "London");
        //System.out.println("Customer record added..");

        List<Customer> list =customerService.getAllCustomer();
        list.forEach(System.out::println);


    }
}
