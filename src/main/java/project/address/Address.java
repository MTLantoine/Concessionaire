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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
