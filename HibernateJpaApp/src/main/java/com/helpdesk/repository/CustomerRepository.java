package com.helpdesk.repository;

import com.helpdesk.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insert(Customer customer) {
        entityManager.persist(customer);
    }

    public List<Customer> getAllCustomer() {
        String jpql="select c from Customer c"; // you query the class Customer
        String hql = "from Customer c";  // no select statement
        String nativeSql = "select * from customer";

        return entityManager.createQuery(jpql).getResultList();

        //return entityManager.createQuery(hql).getResultList();

        //return entityManager.createNativeQuery(nativeSql, Customer.class).getResultList();

    }

    public Optional<Customer> getCustomerById(int customerId) {
        return Optional
                .ofNullable(entityManager
                        .find(Customer.class, customerId));
    }
}
