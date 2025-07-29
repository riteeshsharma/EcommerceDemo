package dev.riteesh.EcommerceDemo.exceptions;

public class ProductNotFoundException extends RuntimeException{
    private String ProductNotFound(){
        return "Product Not Found";
    }
}
