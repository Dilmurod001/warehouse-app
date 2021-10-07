package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
