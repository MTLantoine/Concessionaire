package project.concessionaire;

import lombok.*;
import org.springframework.stereotype.*;
import project.address.*;
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

    @OneToMany
    @JoinColumn(name = "concessionnaire_id")
    private Set<Address> address = new HashSet<Address>();

    @ManyToMany
    @JoinTable(
            name = "brand_concessionnaire",
            joinColumns = @JoinColumn(name = "concessionnaire_id"),
            inverseJoinColumns = @JoinColumn(name = "brand_id")
    )
    private Set<Brand> brand = new HashSet<Brand>();

}
