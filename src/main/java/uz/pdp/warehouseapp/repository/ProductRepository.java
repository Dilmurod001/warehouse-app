package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.pdp.warehouseapp.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
//    List<Product> findAllByNameIsLike(String name);

//    List<Product> findByNameLike(String name);

//    @Query(value = "select * from product p where name like '"%name%"', nativeQuery = true)
//    List<Product> getAllBySearchName(String name);

    List<Product> findAllByCategoryId(Integer catId);

}
