package dev.riteesh.EcommerceDemo.controller;

import dev.riteesh.EcommerceDemo.exceptions.ProductNotFoundException;
import dev.riteesh.EcommerceDemo.service.ProductService;
import dev.riteesh.EcommerceDemo.service.ProductServiceDemo;
import dev.riteesh.EcommerceDemo.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
//    @RequestBody({
//            "id": 0,
//            "title": "string",
//            "price": 0.1,
//            "description": "string",
//            "category": "string",
//            "image": "http://example.com"
//            })

    private ProductService productService;

    public ProductController(@Qualifier ("fakeStoreProductService") ProductService productService) {
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

    @GetMapping("/Allproducts")
    public ResponseEntity<Page<Product>> getAllProducts(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNumber") Integer pageNumber){
        Page<Product> getRequestAllProducts = productService.getAllProducts(pageSize,pageNumber);
        return new ResponseEntity<>(getRequestAllProducts, HttpStatus.OK);
    }
}
