package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.Category;
import uz.pdp.warehouseapp.projection.CategoryProjection;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAllByParentCategoryIsNull();

    List<CategoryProjection> findAllByParentCategoryId(Integer id);


}
