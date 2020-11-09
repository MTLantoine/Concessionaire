package project.brand;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import project.exception.AlreadyExistingException;

import java.text.MessageFormat;
import java.util.Optional;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public Iterable<Brand> getBrand() {
        return brandRepository.findAll();
    }

    @PostMapping("/add")
    public void postBrand(@RequestBody Brand newBrand) throws AlreadyExistingException {
        final Optional<Brand> optionalExistingBrand = brandRepository.findAll().stream().filter(brand -> brand.getId() == newBrand.getId()).findFirst();
        if (optionalExistingBrand.isPresent()) {
            throw new AlreadyExistingException("Brand : { id : " + newBrand.getId() + " } already exists.");
        } else {
            brandRepository.save(newBrand);
        }
    }
}
