package project.brand;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import project.address.Address;
import project.exception.AlreadyExistingException;

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

    @GetMapping("/{brandId}")
    public Optional<Brand> getBrandId(@PathVariable("brandId") int brandId) {
        return brandRepository.findById(brandId);
    }

    @PostMapping("/add")
    public Brand postBrand(@RequestBody Brand newBrand) throws AlreadyExistingException {
        final Optional<Brand> optionalExistingBrand = brandRepository.findAll().stream().filter(brand -> brand.getId() == newBrand.getId()).findFirst();
        if (optionalExistingBrand.isPresent()) {
            throw new AlreadyExistingException("Brand : { id : " + newBrand.getId() + " } already exists.");
        } else {
            return brandRepository.save(newBrand);
        }
    }

    @PutMapping("/{brandId}")
    public Brand putBrand(@RequestBody Brand newBrand, @PathVariable("brandId") int brandId) {
        return brandRepository.findById(brandId).map(brand -> {
            brand.setId(newBrand.getId());
            brand.setName(newBrand.getName());
            brand.setCar(newBrand.getCar());
            return brandRepository.save(brand);
        }).orElseGet(() -> {
            newBrand.setId(brandId);
            return brandRepository.save(newBrand);
        });
    }

    @DeleteMapping("/{brandId}")
    public void deleteBrand(@PathVariable("brandId") int brandId) {
        brandRepository.deleteById(brandId);
    }
}
