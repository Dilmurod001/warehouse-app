package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.Warehouse;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
