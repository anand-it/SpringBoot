package com.app.sampleproject.service;

import com.app.sampleproject.entity.Category;
import com.app.sampleproject.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(int productid);

    Product addProduct(Product product);

    String updateProduct(Product productDetails);

     String deleteByProductId(int productid);

    List<Category> getAllCategory();

    Category addMainCategory(Category category , MultipartFile file) throws IOException;

}
