package com.jumia.task.resource;

import com.jumia.task.entity.dto.CustomerResponseDTO;
import com.jumia.task.entity.enums.CountryEnum;
import com.jumia.task.entity.enums.StateEnum;
import com.jumia.task.mapper.CustomerMapper;
import com.jumia.task.service.CustomerService;
import io.swagger.annotations.ApiParam;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Customer resource.
 */
@RestController
@RequestMapping("/api")
public class CustomerResource {

    private final CustomerService customerService;

    /**
     * Instantiates a new Customer resource.
     *
     * @param customerService the customer service
     */
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Find all by criteria list.
     *
     * @param country  the country
     * @param state    the state
     * @param pageable the pageable
     * @return the list
     */
    @GetMapping("/customer")
    public List<CustomerResponseDTO> findAllByCriteria(CountryEnum country, @ApiParam Pageable pageable) {
        return customerService.findAll(country, pageable).stream().map(CustomerMapper::mapToResponseDTO).collect(Collectors.toList());
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    @GetMapping("/customer/all")
    public List<CustomerResponseDTO> findAll() {
        return customerService.findAll().stream().map(CustomerMapper::mapToResponseDTO).collect(Collectors.toList());
    }
}
