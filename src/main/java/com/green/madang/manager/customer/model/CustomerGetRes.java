package com.green.madang.manager.customer.model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerGetRes {
    private int custId;
    private String name;
    private String address;
    private String phone;
}
