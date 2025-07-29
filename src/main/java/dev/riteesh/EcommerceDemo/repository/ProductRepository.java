package dev.riteesh.EcommerceDemo.repository;

import dev.riteesh.EcommerceDemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    Product findBytitle(String title);
    Product findBydescription(String description);
}
