package com.app.sampleproject.impl;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.app.sampleproject.entity.Category;
import com.app.sampleproject.entity.Product;
import com.app.sampleproject.repository.CategoryRepository;
import com.app.sampleproject.repository.ProductRepository;
import com.app.sampleproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
public class ProductImpl implements ProductService {

    //AWS S3 BUCKET ACCESS
    @Value("${cloud.aws.credentials.accessKey}")
    private String accessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String secretKey;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${app.awsServices.bucketName}")
    private String bucketName;

    private AmazonS3 s3Client;
    private String db2 = "https://oheliamoon.s3.ap-south-1.amazonaws.com/products/";
    private String db ="https://oheliamoon.s3.ap-south-1.amazonaws.com/category/";

    @Autowired
    private ProductRepository productrepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getProducts() {
        return productrepository.findAll();
    }

    @Override
    public Product getProductById(int productid) {
        return productrepository.findByProductid(productid);
    }

    @Override
    public Product addProduct( Product product) {
        return productrepository.save(product);
    }

    @Override
    public String updateProduct(Product productDetails) {
        Product product = productrepository.findByProductid(productDetails.getProductid());
        product.setProductid(product.getProductid());

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

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addMainCategory( Category category , MultipartFile file) throws IOException {
        if(file!=null) {
            this.uploadImage(file,"category");
            category.setImageurl(db + file.getOriginalFilename());
        }else {
            category.setImageurl(db + "profile.jpg");
        }
        return categoryRepository.save(category);
    }

    public String deleteS3Img(String keyName, String name) {
        final DeleteObjectRequest deleteObjectRequest = new DeleteObjectRequest(bucketName + "/" + name, keyName);
        s3Client.deleteObject(deleteObjectRequest);
        return "deleted";
    }

    @PostConstruct
    private void initAmazon() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
        this.s3Client = AmazonS3ClientBuilder.standard().withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();
    }

    public void uploadImage(MultipartFile image,String name) throws IOException {
        if (!image.isEmpty()) {
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(image.getContentType());
            this.s3Client.putObject(new PutObjectRequest(bucketName +"/"+name, image.getOriginalFilename(),
                    image.getInputStream(), objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead));
        }
    }


}
