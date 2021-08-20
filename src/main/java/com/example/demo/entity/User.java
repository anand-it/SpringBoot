package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name ="userprofile")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int userid;

    public  String  firstname;
    public  String  lastname;
    public  String  password;
    public  String  email;
    public  String  phonenumber;
    public  String  dob;

}
