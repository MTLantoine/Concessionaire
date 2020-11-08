package project.car;

import lombok.*;
import org.springframework.stereotype.*;

import javax.persistence.*;

@Component
@Entity
@Data
@NoArgsConstructor
public class Car {

    @Id
    private int id;
    private String name;

}
