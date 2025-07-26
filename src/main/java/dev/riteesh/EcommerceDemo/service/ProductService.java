package dev.riteesh.EcommerceDemo.service;

import dev.riteesh.EcommerceDemo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    Product getSingleProduct(long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);
}
