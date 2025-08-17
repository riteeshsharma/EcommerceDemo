package dev.riteesh.EcommerceDemo.service;

import dev.riteesh.EcommerceDemo.exceptions.ProductNotFoundException;
import dev.riteesh.EcommerceDemo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    Page<Product> getAllProducts(int pageSize, int pageNumber);

    Product createProduct(Product product);

}
