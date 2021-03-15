package com.fullstack.employeemanager.model;

import java.io.Serializable;

public class Employee implements Serializable {
    // serializable helps transform class to send different types of string
    // will be sending some information to database as well as to frontend

    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private String imageURL;
    private String employeeCode;

}
