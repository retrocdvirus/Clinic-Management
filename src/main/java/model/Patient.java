package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Patient")
public class Patient {

    public Patient(){}
    //the Patient class stored informations regarding the patient
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    //TemporalType.DATE let the dob be recieved and save as yyyy-MM-dd
    //I struggled quite a bit to find this, which is much better than @JsonFormat or @DateTimeFormat
    //because it works with all my date method
    @Temporal(TemporalType.DATE)
    private Date dob;

    @Column
    private String gender;

    @Column
    private String address;

    // a patient can have many visits, hence one to many
    @OneToMany(mappedBy = "patientVisit")
    //if a patient is deleted, there's no need to leave any visit, diagnose or perscriptions
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private List<Visit> visitList = new ArrayList<Visit>();


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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name) &&
                Objects.equals(dob, patient.dob) &&
                Objects.equals(gender, patient.gender) &&
                Objects.equals(address, patient.address) &&
                Objects.equals(visitList, patient.visitList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dob, gender, address, visitList);
    }



}
