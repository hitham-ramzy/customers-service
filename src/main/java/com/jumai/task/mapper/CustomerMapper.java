package com.jumai.task.mapper;

import com.jumai.task.entity.Customer;
import com.jumai.task.entity.dto.CustomerResponseDTO;
import com.jumai.task.entity.enums.CountryEnum;
import com.jumai.task.entity.enums.StateEnum;
import com.jumai.task.util.ApplicationUtils;

public class CustomerMapper {

    public static CustomerResponseDTO mapToResponseDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setPhone(customer.getPhone());
        dto.setState(ApplicationUtils.isValidPhone(customer.getPhone()) ? StateEnum.VALID : StateEnum.INVALID);
        CountryEnum countryEnum = ApplicationUtils.getCountry(customer.getPhone());
        if (countryEnum != null) {
            dto.setCountry(countryEnum.name());
            dto.setCountryCode(countryEnum.code);
        }
        return dto;
    }
}
