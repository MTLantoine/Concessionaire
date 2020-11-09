package project.address;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import project.exception.*;

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
    public Address postAddress(@RequestBody Address newAddress) throws AlreadyExistingException {
        final Optional<Address> optionalExistingAddress = addressRepository.findAll().stream().filter(address -> address.getId() == newAddress.getId()).findFirst();
        if (optionalExistingAddress.isPresent()) {
            throw new AlreadyExistingException("Address : { id : " + newAddress.getId() + " } already exists.");
        } else {
            return addressRepository.save(newAddress);
        }
    }

    @PutMapping("/{addressId}")
    public Address putAddress(@RequestBody Address newAddress, @PathVariable("addressId") int addressId) {
        return addressRepository.findById(addressId).map(address -> {
            address.setId(newAddress.getId());
            address.setNum(newAddress.getNum());
            address.setStreet(newAddress.getStreet());
            address.setCp(newAddress.getCp());
            address.setCity(newAddress.getCity());
            return addressRepository.save(address);
        }).orElseGet(() -> {
            newAddress.setId(addressId);
            return addressRepository.save(newAddress);
        });
    }
}
