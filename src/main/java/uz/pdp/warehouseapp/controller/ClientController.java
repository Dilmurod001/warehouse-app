package uz.pdp.warehouseapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.warehouseapp.entity.Client;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.repository.ClientRepository;
import uz.pdp.warehouseapp.service.ClientService;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @GetMapping("/list")
    public List<Client> clients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public ApiResponse getOne(@PathVariable Integer id) {
        Optional byId = clientRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Not Found!", false);
        return new ApiResponse("Found!", true, byId.get());
    }

    @PostMapping("/add")
    public ApiResponse add(@RequestBody Client client) {
        return clientService.add(client);
    }

    @PutMapping("/edit/{id}")
    public ApiResponse edit(@PathVariable Integer id, @RequestBody Client client) {
        return clientService.edit(id, client);
    }

    @DeleteMapping("/{id}")
    public ApiResponse delete(@PathVariable Integer id) {
        Optional byId = clientRepository.findById(id);
        if (!byId.isPresent()) return new ApiResponse("Not Found!", false);

        clientRepository.deleteById(id);
        return new ApiResponse("Deleted!", true);
    }
}
