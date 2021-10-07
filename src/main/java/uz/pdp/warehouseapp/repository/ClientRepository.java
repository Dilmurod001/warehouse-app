package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.Client;


public interface ClientRepository extends JpaRepository<Client, Integer> {
    boolean existsByPhoneNumber(String phone);
}
