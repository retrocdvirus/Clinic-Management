package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Doctor")
public class Doctor {

    public Doctor(){}
    // the Doctor class contains information regarding doctors in the clinic
    // there's not much here right now because it's uneccessary
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column

    private String name;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(name, doctor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }



}
