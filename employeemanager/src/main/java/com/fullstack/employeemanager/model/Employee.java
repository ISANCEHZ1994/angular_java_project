package com.fullstack.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity // will make sure that this class is mapped to any database that we have configured on class path
public class Employee implements Serializable {
    // serializable helps transform class to send different types of string
    // will be sending some information to database as well as to frontend

    @Id // we want id to be the primary key in the database
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private String imageURL;
    private String employeeCode;

}
