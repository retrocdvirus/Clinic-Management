package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Visit")
public class Visit {

    public Visit() {
    }
    // the Visit class stores information regarding the patient's visit to the Clinic
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    // the visitDate records the day the patient visit the clinic
    //@JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date visitDate;

    @Column
    // the visitTime records the time the patient visits
    // as hh:mm:ss
    private Time visitTime;

    //connect the visit to the patient
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Patient patientVisit;

    // EACH time the patient visits the clinic, the patient generally receives A diagnoses
    @OneToOne
    // no visit then no diagnoses
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Diagnose diagnose;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Time getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Time visitTime) {
        this.visitTime = visitTime;
    }

    public Patient getPatientVisit() {
        return patientVisit;
    }

    public void setPatientVisit(Patient patientVisit) {
        this.patientVisit = patientVisit;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(Diagnose diagnose) {
        this.diagnose = diagnose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(visitDate, visit.visitDate) &&
                Objects.equals(visitTime, visit.visitTime) &&
                Objects.equals(patientVisit, visit.patientVisit) &&
                Objects.equals(diagnose, visit.diagnose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(visitDate, visitTime, patientVisit, diagnose);
    }



}