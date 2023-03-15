package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Perscription")
public class Perscription {

    public Perscription(){}
    // the Persccription class that contains the information regarding the drugs the patient is perscribed
    // according to the patient's diagnoses
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // a perscription has many drugs, and each drug are different,
    // hence one Perscription has many PerscriptionDetail with specify the different drugs
    @OneToMany(mappedBy = "perscription")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    List<PerscriptionDetail> perscriptionDetailList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PerscriptionDetail> getPerscriptionDetailList() {
        return perscriptionDetailList;
    }

    public void setPerscriptionDetailList(List<PerscriptionDetail> perscriptionDetailList) {
        this.perscriptionDetailList = perscriptionDetailList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perscription that = (Perscription) o;
        return Objects.equals(perscriptionDetailList, that.perscriptionDetailList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perscriptionDetailList);
    }



}
