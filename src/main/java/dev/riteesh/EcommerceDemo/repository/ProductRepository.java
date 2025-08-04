package dev.riteesh.EcommerceDemo.repository;

import dev.riteesh.EcommerceDemo.models.Category;
import dev.riteesh.EcommerceDemo.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    Product findBytitle(String title);
    Product findBydescription(String description);

//    static Optional<Product> findById(Long Id);
    @Query(value = "select * from product p where p.category_id = :categoryId", nativeQuery = true)
    List<Product> getProductsByCategoryIdWithNativeQueries(@Param("Id") Long categoryId);


}
