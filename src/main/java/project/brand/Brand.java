package project.brand;

import lombok.*;
import org.springframework.stereotype.*;
import project.car.*;

import javax.persistence.*;
import java.util.*;

@Component
@Entity
@Data
@NoArgsConstructor
public class Brand {

    @Id
    private int id;
    private String name;

    @OneToMany
    @JoinColumn(name = "brand_id")
    private Set<Car> car = new HashSet<Car>();
}
