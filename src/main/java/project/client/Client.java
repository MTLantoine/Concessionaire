package project.client;

import lombok.*;
import org.springframework.stereotype.*;
import project.car.*;

import javax.persistence.*;
import java.util.*;

@Component
@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    private int id;
    private String firstname;
    private String lastname;

    @OneToMany
    @JoinColumn(name = "client_id")
    private Set<Car> car = new HashSet<Car>();
}
