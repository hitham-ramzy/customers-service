package com.jumia.task.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    private Integer id;

    private String name;

    private String phone;

}
