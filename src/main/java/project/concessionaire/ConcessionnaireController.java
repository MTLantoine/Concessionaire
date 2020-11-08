package project.concessionaire;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "")
public class ConcessionnaireController {

    @Autowired
    private ConcessionnaireRepository concessionnaireRepository;

    @GetMapping
    public Iterable<Concessionnaire> getConcessionnaire() {
        return concessionnaireRepository.findAll();
    }
}
