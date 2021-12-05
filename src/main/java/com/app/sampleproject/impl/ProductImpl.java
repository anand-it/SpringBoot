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
    public Product getProductById(int productid) {
        return productrepository.findProductId(productid);
    }

    @Override
    public Product addProduct( Product product) {
        return productrepository.save(product);
    }

    @Override
    public String updateProduct(int productid, Product productDetails) {
        Product product = productrepository.findProductId(productid);
        product.setProductid(productid);
        if (productDetails.getProductname() != null) {
            product.setProductname(productDetails.getProductname());
        } else {
            product.setProductname(product.getProductname());
        }

        if (productDetails.getProductcode() != null) {
            product.setProductcode(productDetails.getProductcode());
        } else {
            product.setProductcode(product.getProductcode());
        }

        if (productDetails.getPrice() != 0) {
            product.setPrice(productDetails.getPrice());
        } else {
            product.setPrice(product.getPrice());
        }

        if (productDetails.getOffer() >= 0) {
            product.setOffer(productDetails.getOffer());
        } else {
            product.setOffer(product.getOffer());
        }

        if (productDetails.getDescription() != null) {
            product.setDescription(productDetails.getDescription());
        } else {
            product.setDescription(product.getDescription());
        }
        if (productDetails.getColor() != null) {
            product.setColor(productDetails.getColor());
        } else {
            product.setColor(product.getColor());
        }
        if (productDetails.getDate() != null) {
            product.setDate(productDetails.getDate());
        } else {
            product.setDate(product.getDate());
        }
         productrepository.save(product);
        return "product updated";
    }

    @Override
    public String deleteByProductId(int productid) {
        productrepository.deleteById(productid);
        return "deleted";
    }


}
