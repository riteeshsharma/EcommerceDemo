package dev.riteesh.EcommerceDemo.service;

import dev.riteesh.EcommerceDemo.exceptions.ProductNotFoundException;
import dev.riteesh.EcommerceDemo.models.Category;
import dev.riteesh.EcommerceDemo.models.Product;
import dev.riteesh.EcommerceDemo.repository.CategoryRepository;
import dev.riteesh.EcommerceDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service("ProductServiceDemo")
public class ProductServiceDemo implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product getSingleProduct(Long productId) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(productId);
        if(p.isPresent()) {
            return p.get();
        }
        throw new ProductNotFoundException("Product not found");
    }

    @Override
    public Page<Product> getAllProducts(int pageSize, int pageNumber) {
        return productRepository.findAll(PageRequest.of(pageNumber,pageSize));
    }


    @Override
    public Product createProduct(Product product) throws ProductNotFoundException {
        Product response = new Product();
        try{
            String p = product.getCategory().getTitle();
            Category cat = categoryRepository.findByTitle(p);
            if(cat == null){
                Category newCat = new Category();
                newCat.setTitle(product.getCategory().getTitle());
                newCat.setDescription(product.getCategory().getDescription());
                Category newRow = categoryRepository.save(newCat);
                product.setCategory(newRow);
            }
            else{
                product.setCategory(cat);
            }
            response = productRepository.save(product);
        }
        catch(Exception e){
            e.printStackTrace();
            throw new ProductNotFoundException("Product Not Found");
        }
        return response;
    }
}
