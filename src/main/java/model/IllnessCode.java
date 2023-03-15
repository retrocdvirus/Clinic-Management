package model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IllnessCode")
public class IllnessCode {

    public IllnessCode(){}
    // the IllnessCode contains information of the icd imported from the excel file
    // the icd rarely changes, and is a semi-permanente data, controller and service is not needed
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String groupCode;

    @Column
    private String groupName;

    @Column
    private String typeCode;

    @Column
    private String typeName;

    @Column
    private String diseaseCode;

    @Column
    private String diseaseName;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(String diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IllnessCode that = (IllnessCode) o;
        return Objects.equals(groupCode, that.groupCode) &&
                Objects.equals(groupName, that.groupName) &&
                Objects.equals(typeCode, that.typeCode) &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(diseaseCode, that.diseaseCode) &&
                Objects.equals(diseaseName, that.diseaseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupCode, groupName, typeCode, typeName, diseaseCode, diseaseName);
    }



}
