package com.app.sampleproject.impl;

import com.app.sampleproject.entity.Product;
import com.app.sampleproject.repository.ProductRepository;
import com.app.sampleproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {

    @Autowired
    private ProductRepository productrepository;

    @Override
    public List<Product> getProducts() {
        return productrepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productrepository.findProductId(productId);
    }
}
