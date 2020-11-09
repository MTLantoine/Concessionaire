package project.concessionaire;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import project.exception.AlreadyExistingException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/concessionnaire")
public class ConcessionnaireController {

    @Autowired
    private ConcessionnaireRepository concessionnaireRepository;

    @GetMapping
    public Iterable<Concessionnaire> getConcessionnaire() {
        return concessionnaireRepository.findAll();
    }

    @PostMapping("/add")
    public String postConcessionnaire(@RequestBody Concessionnaire newConcessionnaire) throws AlreadyExistingException {
        final Optional<Concessionnaire> optionalExistingConcessionnaire = concessionnaireRepository.findAll().stream().filter(concessionnaire -> concessionnaire.getId() == newConcessionnaire.getId()).findFirst();
        if (optionalExistingConcessionnaire.isPresent()) {
            throw new AlreadyExistingException("Concessionnaire : { id : " + newConcessionnaire.getId() + " } already exists.");
        } else {
            concessionnaireRepository.save(newConcessionnaire);
            return "New Concessionnaire : { id : " + newConcessionnaire.getId() + " } added successfully !";
        }
    }


}
