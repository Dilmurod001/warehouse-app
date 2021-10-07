package uz.pdp.warehouseapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.warehouseapp.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
