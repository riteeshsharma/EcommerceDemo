package dev.riteesh.EcommerceDemo.service;

import dev.riteesh.EcommerceDemo.exceptions.ProductNotFoundException;
import dev.riteesh.EcommerceDemo.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
