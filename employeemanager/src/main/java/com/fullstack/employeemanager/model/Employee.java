package com.fullstack.employeemanager.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity // will make sure that this class is mapped to any database that we have configured on class path
public class Employee implements Serializable {
    // serializable helps transform class to send different types of string
    // will be sending some information to database as well as to frontend

    @Id // we want the id variable to be the primary key in the database
    @GeneratedValue(strategy = GenerationType.IDENTITY) // we want this to be specific so we use (information here)
    @Column(nullable = false, updatable = false) // id will never be updated in database
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private String imageURL;
    @Column(nullable = false, updatable = false) // employeeCode will never be updated in database
    private String employeeCode;

    public Employee(String n, String e, String j, String p, String i, String c){
        name = n;
        email = e;
        jobTitle = j;
        phoneNumber = p;
        imageURL = i;
        employeeCode = c;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        // this is known as shadowing and is not recommended to code like this
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String e){
        email = e;
    }

    public String getJobTitle(){
        return jobTitle;
    }

    public void setJobTitle(String j){
        jobTitle = j;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String p){
        phoneNumber = p;
    }

    public String getImageURL(){
        return imageURL;
    }

    public void setImageURL(String i){
        imageURL = i;
    }

    public String getEmployeeCode(){
        return employeeCode;
    }

    public void setEmployeeCode(String e){
        employeeCode = e;
    }
    
};
