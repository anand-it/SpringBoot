package com.app.sampleproject.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
@Table(name ="subcategory")
//@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class,property = "subcategoryid")
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subcategoryid;
    private String subcategoryname;
    @ManyToOne
    @JoinColumn(name="categoryid")
    private Category categoryid;

    public int getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(int subcategoryid) {
        this.subcategoryid = subcategoryid;
    }

    public String getSubcategoryname() {
        return subcategoryname;
    }

    public void setSubcategoryname(String subcategoryname) {
        this.subcategoryname = subcategoryname;
    }

    public Category getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Category categoryid) {
        this.categoryid = categoryid;
    }
}
