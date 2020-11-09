package project.address;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import project.exception.*;

import java.text.*;
import java.util.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public Iterable<Address> getAddress() {
        return addressRepository.findAll();
    }

    @GetMapping("/{addressId}")
    public Optional<Address> getAddressId(@PathVariable("addressId") int addressId) {
        return addressRepository.findById(addressId);
    }

    @PostMapping("/add")
    public void postAddress(@RequestBody Address newAddress) throws AlreadyExistingException {
        final Optional<Address> optionalExistingAddress = addressRepository.findAll().stream().filter(address -> address.getId() == newAddress.getId()).findFirst();
        if (optionalExistingAddress.isPresent()) {
            throw new AlreadyExistingException("Address : { id : " + newAddress.getId() + " } already exists.");
        } else {
            addressRepository.save(newAddress);
        }
    }
}
