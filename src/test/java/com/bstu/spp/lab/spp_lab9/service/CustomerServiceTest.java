package com.bstu.spp.lab.spp_lab9.service;

import com.bstu.spp.lab.spp_lab9.model.Customer;
import com.bstu.spp.lab.spp_lab9.model.WorkType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    CustomerService customerService;
    static Customer customer;

    @BeforeAll
    static void setup() {
        customer = Customer.builder()
                .firstName("Vadim")
                .lastName("Igorevich")
                .phoneNumber("+375298778877")
                .build();
    }

    @Test
    void findById() {
        Integer customerId = 2;
        Customer customer = customerService.findById(customerId);
        assertNotNull(customer);
        assertEquals(customerId, customer.getCustomerId());
        assertEquals("Pasha", customer.getFirstName());
    }

    @Test
    void add() {
        Integer customerId = customerService.add(customer);
        assertNotNull(customerId);
        Customer generatedCustomer = customerService.findById(customerId);
        assertNotNull(generatedCustomer);
        assertEquals(customer.getFirstName(), generatedCustomer.getFirstName());
        assertEquals(customer.getLastName(), generatedCustomer.getLastName());
        assertEquals(customer.getPhoneNumber(), generatedCustomer.getPhoneNumber());
    }

    @Test
    void delete() {
        Integer customerId = customerService.add(customer);
        assertNotNull(customerId);
        assertNotNull(customerService.findById(customerId));
        customerService.delete(customerId);
        assertThrows(NoSuchElementException.class, () -> customerService.findById(customerId));
    }
}