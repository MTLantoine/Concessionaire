package project.concessionaire;

import lombok.*;
import org.springframework.stereotype.*;
import project.brand.*;

import javax.persistence.*;
import java.util.*;

@Component
@Entity
@Data
@NoArgsConstructor
public class Concessionnaire {

    @Id
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "brand_concessionnaire",
            joinColumns = @JoinColumn(name = "brand_id"),
            inverseJoinColumns = @JoinColumn(name = "concessionnaire_id")
    )
    private Set<Brand> brand = new HashSet<Brand>();

}
