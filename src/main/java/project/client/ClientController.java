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

    @PostMapping("/add")
    public String postClient(@RequestBody Client newClient) throws AlreadyExistingException {
        final Optional<Client> optionalExistingClient = clientRepository.findAll().stream().filter(client -> client.getId() == newClient.getId()).findFirst();
        if (optionalExistingClient.isPresent()) {
            throw new AlreadyExistingException("Client : { id : " + newClient.getId() + " } already exists.");
        } else {
            clientRepository.save(newClient);
            return "New Client : { id : " + newClient.getId() + " } added successfully !";
        }
    }
}
