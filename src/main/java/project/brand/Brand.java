package project.brand;

import lombok.*;
import org.springframework.stereotype.*;

import javax.persistence.*;

@Component
@Entity
@Data
@NoArgsConstructor
public class Brand {

    @Id
    private int id;
    private String name;

}
