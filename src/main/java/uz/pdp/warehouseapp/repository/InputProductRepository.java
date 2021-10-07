package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.InputProduct;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface InputProductRepository extends JpaRepository<InputProduct, UUID> {
    List<InputProduct> findAllByInputId(UUID id);

    List<InputProduct> findAllByExpireDateBefore(Date date);
}
