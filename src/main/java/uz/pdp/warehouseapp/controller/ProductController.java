package uz.pdp.warehouseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.payload.ProductDTO;
import uz.pdp.warehouseapp.repository.CategoryRepository;
import uz.pdp.warehouseapp.repository.ProductRepository;
import uz.pdp.warehouseapp.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @PostMapping
    public ApiResponse save(@RequestBody ProductDTO productDTO) {
        return productService.save(productDTO);
    }

//    @GetMapping("/search")
//    public ApiResponse searchByName(@RequestParam String name) {
//        return productService.searchByName(name);
//    }

    @GetMapping("/{catId}")
    public ApiResponse getByCatId(@PathVariable Integer catId) {
        return productService.getByCatId(catId);
    }



}
