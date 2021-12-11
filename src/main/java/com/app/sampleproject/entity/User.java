package com.app.sampleproject.entity;

import javax.persistence.*;

@Entity
@Table(name ="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userid;
    private String name;
    private String mobilenumber;
    private String emailid;
    private String imageurl;
    private String password;
    private String userreferral;
    private String affiliatecode;

    public User(){

    }
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserreferral() {
        return userreferral;
    }

    public void setUserreferral(String userreferral) {
        this.userreferral = userreferral;
    }

    public String getAffiliatecode() {
        return affiliatecode;
    }

    public void setAffiliatecode(String affiliatecode) {
        this.affiliatecode = affiliatecode;
    }


}
