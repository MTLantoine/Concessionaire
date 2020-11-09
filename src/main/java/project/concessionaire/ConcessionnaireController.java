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

    @GetMapping("/{concessionnaireId}")
    public Optional <Concessionnaire> getConcessionnaireId(@PathVariable("concessionnaireId") int concessionnaireId) {
        return concessionnaireRepository.findById(concessionnaireId);
    }

    @PostMapping("/add")
    public Concessionnaire postConcessionnaire(@RequestBody Concessionnaire newConcessionnaire) throws AlreadyExistingException {
        final Optional<Concessionnaire> optionalExistingConcessionnaire = concessionnaireRepository.findAll().stream().filter(concessionnaire -> concessionnaire.getId() == newConcessionnaire.getId()).findFirst();
        if (optionalExistingConcessionnaire.isPresent()) {
            throw new AlreadyExistingException("Concessionnaire : { id : " + newConcessionnaire.getId() + " } already exists.");
        } else {
            return concessionnaireRepository.save(newConcessionnaire);
        }
    }

    @PutMapping("{concessionnaireId}")
    public Concessionnaire putConcessionnaire(@RequestBody Concessionnaire newConcessionnaire, @PathVariable("concessionnaireId") int concessionnaireId) {
        return concessionnaireRepository.findById(concessionnaireId).map(concessionnaire -> {
            concessionnaire.setId(newConcessionnaire.getId());
            concessionnaire.setName(newConcessionnaire.getName());
            concessionnaire.setAddress(newConcessionnaire.getAddress());
            concessionnaire.setBrand(newConcessionnaire.getBrand());
            return concessionnaireRepository.save(concessionnaire);
        }).orElseGet(() -> {
            newConcessionnaire.setId(concessionnaireId);
            return concessionnaireRepository.save(newConcessionnaire);
        });
    }


}
