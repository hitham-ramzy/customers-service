package com.jumia.task.resource;

import com.jumia.task.entity.Customer;
import com.jumia.task.entity.dto.CustomerResponseDTO;
import com.jumia.task.service.CustomerService;
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
public class CustomerResourceTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    private CustomerResource testee;

    @Test
    public void findAll() {
        when(customerService.findAll()).thenReturn(List.of(new Customer()));
        List<CustomerResponseDTO> customerResponseDTOList = testee.findAll();
        verify(customerService, only()).findAll();
        assertEquals(customerResponseDTOList.size(), 1);
    }

    @Test()
    public void findAllWithException() {
        when(customerService.findAll()).thenThrow(new NullPointerException());
        assertThrows(NullPointerException.class, () -> testee.findAll());
    }
}
