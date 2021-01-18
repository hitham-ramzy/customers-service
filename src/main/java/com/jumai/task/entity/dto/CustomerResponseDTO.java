package com.jumai.task.entity.dto;

import com.jumai.task.entity.enums.StateEnum;
import lombok.Data;

@Data
public class CustomerResponseDTO {

    private Integer id;
    private String name;
    private String phone;
    private String country;
    private String countryCode;
    private StateEnum state;
}
