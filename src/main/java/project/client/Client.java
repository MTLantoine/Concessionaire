package project.client;

import lombok.*;
import org.springframework.stereotype.*;

import javax.persistence.*;

@Component
@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    private int id;
    private String name;
}
