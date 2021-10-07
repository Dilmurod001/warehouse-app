package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.Output;

import java.util.UUID;

public interface OutputRepository extends JpaRepository<Output, UUID> {
}
