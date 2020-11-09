package project.car;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import project.exception.AlreadyExistingException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping
    public Iterable<Car> getCar() {
        return carRepository.findAll();
    }

    @PostMapping("/add")
    public String postCar(@RequestBody Car newCar) throws AlreadyExistingException {
        final Optional<Car> optionalExistingCar = carRepository.findAll().stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (optionalExistingCar.isPresent()) {
            throw new AlreadyExistingException("Car : { id : " + newCar.getId() + " } already exists.");
        } else {
            carRepository.save(newCar);
            return "New Car : { id : " + newCar.getId() + " } added successfully !";
        }
    }
}
