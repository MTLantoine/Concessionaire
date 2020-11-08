package project.address;

import lombok.*;
import org.springframework.stereotype.*;

import javax.persistence.*;

@Component
@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    private int id;
    private String name;

}
