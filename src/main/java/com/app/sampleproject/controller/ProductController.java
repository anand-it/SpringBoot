package com.app.sampleproject.controller;

import com.app.sampleproject.entity.Product;
import com.app.sampleproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sample")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/product/id")
    public Product getProductById(int productid) {
        return productService.getProductById(productid);
    }

    @PostMapping("/addproduct")
    public Product addProduct(Product product){
        return productService.addProduct(product);
    }

    @PutMapping("/updateproduct")
    public String updateProduct(int productid, Product productDetails){
       productService.updateProduct(productid,productDetails);
        return "Product Update";
    }

    @DeleteMapping ("delete/product")
    public String deleteProduct(int productid) {
        productService.deleteByProductId(productid);
        return "deleted";
    }
}
