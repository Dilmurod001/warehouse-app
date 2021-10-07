package uz.pdp.warehouseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.warehouseapp.entity.Warehouse;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.repository.WarehouseRepository;

import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public ApiResponse getOne(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
//        if (!optionalWarehouse.isPresent()) return new ApiResponse("NOT found!", false);
//        return new ApiResponse("Mana", true, optionalWarehouse.get());

        //2-usul
        return optionalWarehouse.map(warehouse -> new ApiResponse("Mana", true, warehouse)).orElseGet(() -> new ApiResponse("NOT found!", false));
    }

    public ApiResponse edit(Integer id, Warehouse warehouse) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent()) return new ApiResponse("NOT", false);
        Warehouse edit = optionalWarehouse.get();
        if (warehouse.getName() != null) edit.setName(warehouse.getName());
        warehouseRepository.save(edit);
        return new ApiResponse("Edit!", true);
    }

    public ApiResponse changeStatus(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent()) return new ApiResponse("NOT", false);
//        if (optionalWarehouse.get().isActive()) {
//            optionalWarehouse.get().setActive(false);
//        } else {
//            optionalWarehouse.get().setActive(true);
//        }
//        return new ApiResponse("Changed!", true);
//
        optionalWarehouse.get().setActive(!optionalWarehouse.get().isActive());
        warehouseRepository.save(optionalWarehouse.get());
        return new ApiResponse("Changed!", true);
    }
}
