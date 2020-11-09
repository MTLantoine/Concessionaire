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
    public String postAddress(@RequestBody Address newAddress) throws AlreadyExistingException {
        final Optional<Address> optionalExistingAddress = addressRepository.findAll().stream().filter(address -> address.getId() == newAddress.getId()).findFirst();
        if (optionalExistingAddress.isPresent()) {
            throw new AlreadyExistingException("Address : { id : " + newAddress.getId() + " } already exists.");
        } else {
            addressRepository.save(newAddress);
            return "New Address : { id : " + newAddress.getId() + " } added successfully !";
        }
    }

    @PutMapping("/{addressId}")
    public String putAddress(@RequestBody Address newAddress, @PathVariable("addressId") int addressId) throws AlreadyExistingException {
        final Optional<Address> optionalExistingAddress = getAddressId(addressId);
        if (optionalExistingAddress.isPresent()) {
            Address address = optionalExistingAddress.get();
            address.setNum(newAddress.getNum());
            address.setStreet(newAddress.getStreet());
            address.setCp(newAddress.getCp());
            address.setCity(newAddress.getCity());



        }else{
            postAddress(newAddress);
            return "Brand does not exist, creation of a new brand.";
        }

    }
}
