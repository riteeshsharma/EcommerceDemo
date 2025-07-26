package dev.riteesh.EcommerceDemo.controller;

import dev.riteesh.EcommerceDemo.service.ProductService;
import org.springframework.web.bind.annotation.*;

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

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void createProduct(){

    }

    @GetMapping("/products/{id}")
    public void getSingleProduct(@PathVariable("id") String productName){

    }

    @GetMapping("/products")
    public void getAllProducts(){

    }
}
