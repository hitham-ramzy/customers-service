package com.jumia.task.service;

import com.jumia.task.entity.Customer;
import com.jumia.task.entity.enums.CountryEnum;
import com.jumia.task.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;

/**
 * The type Customer service.
 * holds all implementations of the business logic
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Find all list without any filtration or pagination
     *
     * @return the list of customers
     */
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }


    /**
     * Find a list of customers with a filtration passed in the input.
     *
     * @param country  the country
     * @param state    the state
     * @param pageable the pageable
     * @return the list
     */
    public List<Customer> findAll(CountryEnum country, Pageable pageable) {
        return customerRepository.findAll((Specification<Customer>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            if (country != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("phone"), "(" + country.code.substring(1) + ")%"));
            }
            return predicate;
        }, pageable).getContent();
    }
}
