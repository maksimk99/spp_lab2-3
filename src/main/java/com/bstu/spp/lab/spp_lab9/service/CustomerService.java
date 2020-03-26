package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer findById(Integer customerId);

    Integer add(Customer customer);

    void delete(Integer customerId);
}
