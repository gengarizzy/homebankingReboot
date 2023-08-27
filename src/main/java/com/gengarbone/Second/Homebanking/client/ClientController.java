package com.gengarbone.Second.Homebanking.client;

import com.gengarbone.Second.Homebanking.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/clients")
    public List<ClientDTO> getClients() {
        return clientRepository.findAll()
                .stream().map(ClientDTO::new).collect(toList());
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDTO> getclient(@PathVariable Long id) {
        return clientRepository.findById(id)
                .map(ClientDTO::new)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/clients")
    public ResponseEntity<?> createClient(@RequestBody ClientDTO clientDTO) {
        try {
            Client newClient = new Client(clientDTO.getFirstName(), clientDTO.getLastName(), clientDTO.getEmail());
            clientRepository.save(newClient);
            return new ResponseEntity<>(new ClientDTO(newClient), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
