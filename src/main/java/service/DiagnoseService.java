package service;

import model.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DiagnoseService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    // returns all the diagnose on the table
    public List<Diagnose> getAllDiagnose(){ return sessionFactory.getCurrentSession().createQuery("from Diagnose").list(); }
    // get a diagnose by id
    public Diagnose getDiagnoseById(int id){ return (Diagnose) sessionFactory.getCurrentSession().get(Diagnose.class, id); }
    // add a diagnose
    public void addDiagnose(Diagnose diagnose){ sessionFactory.getCurrentSession().save(diagnose); }
    // delete a diagnose
    public void deleteDiagnose(Diagnose diagnose){
        sessionFactory.getCurrentSession().delete(diagnose);
    }
    // update a diagnose
    public void updateDiagnose(Diagnose diagnose){ sessionFactory.getCurrentSession().update(diagnose); }
    // get all the diangose a doctor has made by doctor id
    public List<Diagnose> getDiagnoseByDoc(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Diagnose d where d.doctorDiagnose =:idParam");
        query.setInteger("idParam", id);
        return query.list();
    }
    // get all the patient who has the same illness by illness id
    public List<Diagnose> getDiagnoseByIllness(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Diagnose d where d.illnessDiagnose =:idParam");
        query.setInteger("idParam", id);
        return query.list();
    }
    // delete a diagnose by id
    public void deleteDiagnoseById(int id){
        Diagnose dia = (Diagnose) sessionFactory.getCurrentSession().get(Diagnose.class, id);
        deleteDiagnose(dia);
    }
    // set the icd of the diagnoses by illness id and diagnose id
    public void setIllnessById(int diaId, int illId){
        Diagnose dia = (Diagnose) sessionFactory.getCurrentSession().get(Diagnose.class, diaId);
        IllnessCode ill = (IllnessCode) sessionFactory.getCurrentSession().get(IllnessCode.class, illId);
        dia.setIllnessDiagnose(ill);
    }
    // set the doctor who did the diagnoses by doctor id and diagnose id
    public void setDocById(int diaId, int docId){
        Diagnose dia = (Diagnose) sessionFactory.getCurrentSession().get(Diagnose.class, diaId);
        Doctor doc = (Doctor) sessionFactory.getCurrentSession().get(Doctor.class, docId);
        dia.setDoctorDiagnose(doc);
    }
    // set theperscription to the diagnose by perscription id and diagnose id
    public void setPerscriptionById(int diaId, int perscriptId){
        Diagnose dia = (Diagnose) sessionFactory.getCurrentSession().get(Diagnose.class, diaId);
        Perscription perscript = (Perscription) sessionFactory.getCurrentSession().get(Perscription.class, perscriptId);
        dia.setPerscriptionDiagnose(perscript);
    }
}
