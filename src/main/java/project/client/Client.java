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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Car> getCar() {
        return car;
    }

    public void setCar(Set<Car> car) {
        this.car = car;
    }
}
