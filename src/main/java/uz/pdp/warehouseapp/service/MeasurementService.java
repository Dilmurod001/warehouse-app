package uz.pdp.warehouseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehouseapp.entity.Measurement;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.repository.MeasurementRepository;

import java.util.Optional;

@Service
public class MeasurementService {

    @Autowired
    MeasurementRepository measurementRepository;

    public ApiResponse edit(Integer id, Measurement measurement) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent()) return new ApiResponse("NOT FOUND!", false);
        Measurement m = optionalMeasurement.get();
        if (measurement.getName() != null) m.setName(measurement.getName());
        m.setActive(measurement.isActive());
        measurementRepository.save(m);
        return new ApiResponse("UPDATED!", true);
    }

    public ApiResponse addMeasurement(Measurement measurement) {
        Measurement m = new Measurement();
        m.setName(measurement.getName());
        m.setActive(measurement.isActive());
        measurementRepository.save(m);
        return new ApiResponse("SAVED!", true);
    }
}
