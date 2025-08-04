package dev.riteesh.EcommerceDemo.controller;

import dev.riteesh.EcommerceDemo.exceptions.ProductNotFoundException;
import dev.riteesh.EcommerceDemo.models.Category;
import dev.riteesh.EcommerceDemo.models.Product;
import dev.riteesh.EcommerceDemo.repository.ProductRepository;
import dev.riteesh.EcommerceDemo.service.ProductService;
import dev.riteesh.EcommerceDemo.service.ProductServiceDemo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController("/products")
public class ProductController {
//    @RequestBody({
//            "id": 0,
//            "title": "string",
//            "price": 0.1,
//            "description": "string",
//            "category": "string",
//            "image": "http://example.com"
//            })

    private ProductServiceDemo productService;

    public ProductController(ProductServiceDemo productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) throws ProductNotFoundException{
        Product postRequestResponse = productService.createProduct(product);
        return new ResponseEntity<>(postRequestResponse, HttpStatus.CREATED);

    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long productId)throws ProductNotFoundException {
                Product getRequestSingleProduct = productService.getSingleProduct(productId);
                return new ResponseEntity<>(getRequestSingleProduct, HttpStatus.OK);
    }

}
