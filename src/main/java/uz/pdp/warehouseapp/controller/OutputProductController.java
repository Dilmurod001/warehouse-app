package uz.pdp.warehouseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouseapp.entity.OutputProduct;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.payload.OutputProductDTO;
import uz.pdp.warehouseapp.repository.OutputProductRepository;
import uz.pdp.warehouseapp.service.OutputProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/outputProduct")
public class OutputProductController {

    @Autowired
    OutputProductService outputProductService;

    @Autowired
    OutputProductRepository outputProductRepository;

    @GetMapping("/list")
    public List<OutputProduct> list() {
        return outputProductRepository.findAll();
    }

    @PostMapping("/add")
    public ApiResponse save(@RequestBody OutputProductDTO outputProductDTO) {
        return outputProductService.save(outputProductDTO);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable UUID id, @RequestBody OutputProductDTO outputProductDTO) {
        return outputProductService.edit(id, outputProductDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse delete(@PathVariable UUID id) {
        return outputProductService.delete(id);
    }

    @GetMapping("/byId/{id}")
    public ApiResponse byId(@PathVariable UUID id) {
        return outputProductService.byId(id);
    }


}
