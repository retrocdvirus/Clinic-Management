package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Drug")
public class Drug {

    public Drug(){}
    // the Drug class contains the information of the drugs imported from the excel file
    // since the drug list is not going to be changed, there's no need for a controller or a service
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //the drug name can be a bit long, so i extended the length of the column
    @Column(length = 400)
    private String drugName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drug drug = (Drug) o;
        return Objects.equals(drugName, drug.drugName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drugName);
    }



}
