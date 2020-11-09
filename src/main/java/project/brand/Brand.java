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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getCar() {
        return car;
    }

    public void setCar(Set<Car> car) {
        this.car = car;
    }
}
