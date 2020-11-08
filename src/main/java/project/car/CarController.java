package project.car;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public Iterable<Car> getCar() {
        return carRepository.findAll();
    }
}
