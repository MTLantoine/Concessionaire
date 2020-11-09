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
    private int num;
    private String street;
    private int cp;
    private String city;

}
