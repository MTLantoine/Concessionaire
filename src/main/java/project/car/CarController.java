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

    @GetMapping("/{carId}")
    public Optional<Car> getCarId(@PathVariable("carId") int carId) {
        return carRepository.findById(carId);
    }

    @PostMapping("/add")
    public Car postCar(@RequestBody Car newCar) throws AlreadyExistingException {
        final Optional<Car> optionalExistingCar = carRepository.findAll().stream().filter(car -> car.getId() == newCar.getId()).findFirst();
        if (optionalExistingCar.isPresent()) {
            throw new AlreadyExistingException("Car : { id : " + newCar.getId() + " } already exists.");
        } else {
            return carRepository.save(newCar);
        }
    }

    @PutMapping("/{carId}")
    public Car putAddress(@RequestBody Car newCar, @PathVariable("carId") int carId) {
        return carRepository.findById(carId).map(car -> {
            car.setId(newCar.getId());
            car.setName(newCar.getName());
            return carRepository.save(car);
        }).orElseGet(() -> {
            newCar.setId(carId);
            return carRepository.save(newCar);
        });
    }

    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable("carId") int carId) {
        carRepository.deleteById(carId);
    }
}
