package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Diagnose")
public class Diagnose {

    public Diagnose(){}
    // the Diagnose class store the diagnoses details of a patient during one of the patient's visits
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // i used to think that problems should be a class, but the class is simply to small, the only property it has is problem and id
    // plus the Diagnose to Problem relation would be one to many, and that won't display on the Diangose table
    @Column
    private String problems;

    // a patient is diagnoses by a doctor
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Doctor doctorDiagnose;

    // as the doctor diagnose a patient, the patient is given an illness code that classifies the patient's condition
    // if the patient qualifies many illness code, and one if which is the main/cause of the patient's condition,
    // it's better to turn this property into one called illnessMainDiagnose that specify the "main illness"
    // and have another property that lists the many illness the patient have: List<IllnessCode>
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private IllnessCode illnessDiagnose;

    // once the diagnose is complete the patient will have A perscription according to the patient's condition
    // it is more logical to have the Perscription connected to the Diagnose rather than the Vist
    // although you can say that each visit will have a perscription,
    // the perscription should be according to the diagnoses of the patient
    // hence i make one visit has one diagnose, and one diagnose has one
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Perscription perscriptionDiagnose;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public Doctor getDoctorDiagnose() {
        return doctorDiagnose;
    }

    public void setDoctorDiagnose(Doctor doctorDiagnose) {
        this.doctorDiagnose = doctorDiagnose;
    }

    public IllnessCode getIllnessDiagnose() {
        return illnessDiagnose;
    }

    public void setIllnessDiagnose(IllnessCode illnessDiagnose) {
        this.illnessDiagnose = illnessDiagnose;
    }

    public Perscription getPerscriptionDiagnose() {
        return perscriptionDiagnose;
    }

    public void setPerscriptionDiagnose(Perscription perscriptionDiagnose) {
        this.perscriptionDiagnose = perscriptionDiagnose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Diagnose diagnose = (Diagnose) o;
        return Objects.equals(problems, diagnose.problems) &&
                Objects.equals(doctorDiagnose, diagnose.doctorDiagnose) &&
                Objects.equals(illnessDiagnose, diagnose.illnessDiagnose) &&
                Objects.equals(perscriptionDiagnose, diagnose.perscriptionDiagnose);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problems, doctorDiagnose, illnessDiagnose, perscriptionDiagnose);
    }



}
