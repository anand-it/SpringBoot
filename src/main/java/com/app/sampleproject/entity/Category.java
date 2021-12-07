package com.app.sampleproject.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="category")
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property = "categoryid")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryid;
    private String categoryname;
    private String imageurl;
    @OneToMany(mappedBy="categoryid")
    private List<SubCategory> subcategory;

    public Category(){

    }
    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public List<SubCategory> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<SubCategory> subcategory) {
        this.subcategory = subcategory;
    }
}
