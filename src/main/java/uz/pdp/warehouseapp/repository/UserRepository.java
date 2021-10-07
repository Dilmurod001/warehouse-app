package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByPhoneNumber(String phone);

    List<User> findAllByWarehousesId(Integer id);
}
