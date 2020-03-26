package com.bstu.spp.lab.spp_lab9.service.impl;

import com.bstu.spp.lab.spp_lab9.model.Customer;
import com.bstu.spp.lab.spp_lab9.repository.CustomerRepository;
import com.bstu.spp.lab.spp_lab9.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer findById(final Integer customerId) {
        return customerRepository.findById(customerId).get();
    }

    public Integer add(final Customer customer) {
        return customerRepository.save(customer).getCustomerId();
    }

    public void delete(final Integer customerId) {
        customerRepository.deleteById(customerId);
    }
}
