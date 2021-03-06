package uz.pdp.warehouseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouseapp.entity.Warehouse;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.repository.WarehouseRepository;
import uz.pdp.warehouseapp.service.WarehouseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/add")
    public ApiResponse save(@RequestBody Warehouse warehouse) {
        warehouseRepository.save(warehouse);
        return new ApiResponse("Saved!", true);
    }

    @GetMapping("/list")
    public ApiResponse getAll() {
        return new ApiResponse("List", true, warehouseRepository.findAll());
    }

    @GetMapping("/{id}")
    public ApiResponse getOne(@PathVariable Integer id) {
        return warehouseService.getOne(id);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody Warehouse warehouse) {
        return warehouseService.edit(id, warehouse);
    }

    @GetMapping("/changeStatus/{id}")
    public ApiResponse changeStatus(@PathVariable Integer id) {
        return warehouseService.changeStatus(id);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        boolean exists = warehouseRepository.existsById(id);
        if (!exists) return new ApiResponse("NOT", false);
        warehouseRepository.deleteById(id);
        return new ApiResponse("Delete!", true);
    }
}
