package uz.pdp.warehouseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.payload.OutputDTO;
import uz.pdp.warehouseapp.service.OutputService;

@RestController
@RequestMapping("/api/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @PostMapping
    public ApiResponse save(@RequestBody OutputDTO outputDTO) {
        return outputService.save(outputDTO);
    }
}
