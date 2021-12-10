package com.app.sampleproject.controller;

import com.app.sampleproject.entity.Category;
import com.app.sampleproject.entity.Product;
import com.app.sampleproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public String updateProduct(Product productDetails){
       productService.updateProduct(productDetails);
        return "Product Update";
    }

    @DeleteMapping ("delete/product")
    public String deleteProduct(int productid) {
        productService.deleteByProductId(productid);
        return "deleted";
    }

    @GetMapping("/allcategory")
    public List<Category> getAllCategory() {
        return productService.getAllCategory();
    }


    @PostMapping("/addmaincategory")
    public Category addMainCategory(Category category,MultipartFile file) throws IOException {
        return productService.addMainCategory(category, file);
    }
}
