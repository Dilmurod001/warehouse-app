package uz.pdp.warehouseapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.warehouseapp.entity.Client;
import uz.pdp.warehouseapp.payload.ApiResponse;
import uz.pdp.warehouseapp.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;


    public ApiResponse add(Client client) {
        Client c = new Client();
        c.setName(client.getName());
        if (clientRepository.existsByPhoneNumber(client.getPhoneNumber()))
            return new ApiResponse("Tel bor bunaqa!", false);
        c.setPhoneNumber(client.getPhoneNumber());
        clientRepository.save(client);
        return new ApiResponse("Added", true);

    }

    public ApiResponse edit(Integer id, Client client) {
        Optional<Client> byId = clientRepository.findById(id);

        if (!byId.isPresent()) return new ApiResponse("Not Found", false);
        Client editing = byId.get();
        if (client.getName() != null) editing.setName(client.getName());
        if (client.getPhoneNumber() != null && !editing.getPhoneNumber().equals(client.getPhoneNumber())) {
            if (!clientRepository.existsByPhoneNumber(client.getPhoneNumber())) return new ApiResponse("Xato", false);
            editing.setPhoneNumber(client.getPhoneNumber());
        }
        clientRepository.save(editing);
        return new ApiResponse("Success", true);
    }
}
