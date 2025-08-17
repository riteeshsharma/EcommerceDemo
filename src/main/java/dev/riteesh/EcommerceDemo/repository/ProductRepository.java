package dev.riteesh.EcommerceDemo.repository;

import dev.riteesh.EcommerceDemo.models.Category;
import dev.riteesh.EcommerceDemo.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product save(Product product);
    Product findBytitle(String title);
    Product findBydescription(String description);

    @Query(value = "select * from product p where p.category_id = :categoryId", nativeQuery = true)
    List<Product> getProductsByCategoryIdWithNativeQueries(@Param("Id") Long categoryId);
    Page<Product> findAll(Pageable pageable);

}
