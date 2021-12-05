package com.app.sampleproject.repository;

import com.app.sampleproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("from Product where productid=:productid")
    Product findProductId(int productid);
}
