package project.brand;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @GetMapping
    public Iterable<Brand> getBrand() {
        return brandRepository.findAll();
    }
}
