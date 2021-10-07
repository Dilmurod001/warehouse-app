package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.OutputProduct;

import java.util.UUID;

public interface OutputProductRepository extends JpaRepository<OutputProduct, UUID> {
}
