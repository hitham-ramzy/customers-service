package com.jumai.task.service;

import com.jumai.task.entity.Customer;
import com.jumai.task.entity.enums.CountryEnum;
import com.jumai.task.entity.enums.StateEnum;
import com.jumai.task.repository.CustomerRepository;
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
}
