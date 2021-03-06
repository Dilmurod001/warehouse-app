package uz.pdp.warehouseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouseapp.entity.Input;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.payload.InputDTO;
import uz.pdp.warehouseapp.repository.InputRepository;
import uz.pdp.warehouseapp.service.InputService;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/input")
public class InputController {
    @Autowired
    InputService inputService;
    @Autowired
    InputRepository inputRepository;

    @PostMapping
    public HttpEntity<?> save(@RequestBody InputDTO inputDTO) throws ParseException {
        ApiResponse apiResponse = inputService.addInput(inputDTO);
        return ResponseEntity.status(apiResponse.isSuccess()
                ? HttpStatus.CREATED:
                HttpStatus.CONFLICT).
                body(apiResponse);

    }

    @GetMapping
    public HttpEntity<List<Input>> getAll() {
        return  ResponseEntity.ok(inputRepository.findAll());
    }

}
