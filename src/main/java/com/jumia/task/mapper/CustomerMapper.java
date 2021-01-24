package com.jumia.task.mapper;

import com.jumia.task.entity.Customer;
import com.jumia.task.entity.dto.CustomerResponseDTO;
import com.jumia.task.entity.enums.CountryEnum;
import com.jumia.task.entity.enums.StateEnum;
import com.jumia.task.util.ApplicationUtils;

public class CustomerMapper {

    public static CustomerResponseDTO mapToResponseDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setPhone(customer.getPhone());
        CountryEnum countryEnum = ApplicationUtils.getCountry(customer.getPhone());
        if (countryEnum != null) {
            dto.setState(ApplicationUtils.isValidPhone(countryEnum, customer.getPhone()) ? StateEnum.VALID : StateEnum.INVALID);
            dto.setCountry(countryEnum.name());
            dto.setCountryCode(countryEnum.code);
        }
        return dto;
    }
}
