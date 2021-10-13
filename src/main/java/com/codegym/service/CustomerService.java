package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements  ICustomerService{
    private  static final Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1,"A","A@gmail.com","Ha Noi 1"));
        customers.put(2, new Customer(2,"B","B@gmail.com","Ha Noi 2"));
        customers.put(3, new Customer(3,"C","C@gmail.com","Ha Noi 3"));
        customers.put(4, new Customer(4,"D","D@gmail.com","Ha Noi 4"));
        customers.put(5, new Customer(5,"E","E@gmail.com","Ha Noi 5"));

    }




    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
