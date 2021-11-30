package com.app.sampleproject.controller;

import com.app.sampleproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sampleproject")
public class ProductController {
    @Autowired
    private ProductService productService;



}
