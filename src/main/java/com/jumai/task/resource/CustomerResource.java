package com.jumai.task.resource;

import com.jumai.task.entity.Customer;
import com.jumai.task.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customer")
    public List<Customer> findAll() {
        return customerService.findAll();
    }
}
