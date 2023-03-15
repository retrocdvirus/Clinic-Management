package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "PerscriptionDetail")
public class PerscriptionDetail {

    public PerscriptionDetail(){}
    // the PerscriptionDetail class contains the drug details, dosage, usage, and qunatity of the drug
    // according to the particular circumstances

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Perscription perscription;

    // one perscription detail to one drug
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Drug drugDetail;

    @Column
    private String dosage;

    @Column
    private String usage;

    @Column
    private int quantity;





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Perscription getPerscription() {
        return perscription;
    }

    public void setPerscription(Perscription perscription) {
        this.perscription = perscription;
    }

    public Drug getDrugDetail() {
        return drugDetail;
    }

    public void setDrugDetail(Drug drugDetail) {
        this.drugDetail = drugDetail;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerscriptionDetail that = (PerscriptionDetail) o;
        return quantity == that.quantity &&
                Objects.equals(perscription, that.perscription) &&
                Objects.equals(drugDetail, that.drugDetail) &&
                Objects.equals(dosage, that.dosage) &&
                Objects.equals(usage, that.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perscription, drugDetail, dosage, usage, quantity);
    }

}
