package dev.riteesh.EcommerceDemo.repository;

import dev.riteesh.EcommerceDemo.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);
    Category findByTitle(String title);

}
