package uz.pdp.warehouseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouseapp.entity.Supplier;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.repository.SupplierRepository;
import uz.pdp.warehouseapp.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    SupplierService supplierService;

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }

    @GetMapping("/list")
    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getById(@PathVariable Integer id) {
        return supplierService.getById(id);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody Supplier supplier) {
        return supplierService.update(id, supplier);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleted(@PathVariable Integer id) {
        if (!supplierRepository.existsById(id)) return new ApiResponse("Xatolik!", false);
        supplierRepository.deleteById(id);
        return new ApiResponse("deleted !", true);
    }
}
