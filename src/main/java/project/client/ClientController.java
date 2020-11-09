package project.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.exception.AlreadyExistingException;

import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public Iterable<Client> getClient() {
        return clientRepository.findAll();
    }

    @GetMapping("/{addressId}")
    public Optional<Client> getClientId(@PathVariable("addressId") int addressId) {
        return clientRepository.findById(addressId);
    }

    @PostMapping("/add")
    public Client postClient(@RequestBody Client newClient) throws AlreadyExistingException {
        final Optional<Client> optionalExistingClient = clientRepository.findAll().stream().filter(client -> client.getId() == newClient.getId()).findFirst();
        if (optionalExistingClient.isPresent()) {
            throw new AlreadyExistingException("Client : { id : " + newClient.getId() + " } already exists.");
        } else {
            return clientRepository.save(newClient);
        }
    }

    @PutMapping("/{clientId}")
    public Client putAddress(@RequestBody Client newClient, @PathVariable("clientId") int clientId) {
        return clientRepository.findById(clientId).map(client -> {
            client.setId(newClient.getId());
            client.setFirstname(newClient.getFirstname());
            client.setLastname(newClient.getLastname());
            client.setCar(newClient.getCar());
            return clientRepository.save(client);
        }).orElseGet(() -> {
            newClient.setId(clientId);
            return clientRepository.save(newClient);
        });
    }
}
