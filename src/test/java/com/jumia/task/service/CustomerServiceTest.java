package com.jumia.task.service;

import com.jumia.task.entity.Customer;
import com.jumia.task.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService testee;

    @Test
    public void findAll() {
        when(customerRepository.findAll()).thenReturn(List.of(new Customer()));
        List<Customer> customers = testee.findAll();
        verify(customerRepository, only()).findAll();
        assertEquals(customers.size(), 1);
    }

    @Test()
    public void findAllWithException() {
        when(customerRepository.findAll()).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, () -> testee.findAll());
    }
}
