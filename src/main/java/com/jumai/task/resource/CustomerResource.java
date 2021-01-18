package com.jumai.task.resource;

import com.jumai.task.entity.Customer;
import com.jumai.task.entity.enums.CountryEnum;
import com.jumai.task.entity.enums.StateEnum;
import com.jumai.task.service.CustomerService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public List<Customer> findAll(@RequestParam(required = false) CountryEnum country, @RequestParam(required = false) StateEnum state, Pageable pageable) {
        return customerService.findAll(country, state, pageable);
    }
}
