package uz.pdp.warehouseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehouseapp.entity.Supplier;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.repository.SupplierRepository;

import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public ApiResponse save(Supplier supplier) {
        Supplier supplier1 = new Supplier();
        supplier1.setName(supplier.getName());
        supplier1.setPhoneNumber(supplier.getPhoneNumber());
        supplierRepository.save(supplier1);
        return new ApiResponse("Saved !", true);
    }

    public ApiResponse getById(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent()) return new ApiResponse("Not Found !", false);
        return new ApiResponse("Found !", true, optionalSupplier.get());
    }

    public ApiResponse update(Integer id, Supplier supplier) {
        Optional<Supplier> supplierOptional = supplierRepository.findById(id);
        if (!supplierOptional.isPresent()) return new ApiResponse("NOt Found", false);
        Supplier edit = supplierOptional.get();
        if (supplier.getName() != null) {
            edit.setName(supplier.getName());
        }
        if (supplier.getPhoneNumber() != null) {
            edit.setPhoneNumber(supplier.getPhoneNumber());
        }
        supplierRepository.save(edit);
        return new ApiResponse("Updated !", true);
    }

}

