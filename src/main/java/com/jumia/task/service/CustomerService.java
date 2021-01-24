package com.jumia.task.service;

import com.jumia.task.entity.Customer;
import com.jumia.task.entity.enums.CountryEnum;
import com.jumia.task.entity.enums.StateEnum;
import com.jumia.task.repository.CustomerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll(CountryEnum country, StateEnum state, Pageable pageable) {
        return customerRepository.findAll((Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (country != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("phone"), "(" + country.code.substring(1) + ")%"));
            }
            return predicate;
        }, pageable).getContent();
    }

    public Page<Customer> findByRegex(CountryEnum country, StateEnum state, Pageable pageable) {
        customerRepository.init();
        return customerRepository.findByPhoneRegex(CountryEnum.Cameroon.regex, pageable);
    }
}
