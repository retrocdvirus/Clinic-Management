package service;
import model.Diagnose;
import model.Patient;
import model.Visit;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Transactional
@Service
public class VisitService {


    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    // returns all visits on the table
    public List<Visit> getAllVisit(){ return sessionFactory.getCurrentSession().createQuery("from Visit").list(); }
    // get a visit by id
    public Visit getVisitById(int id){ return (Visit) sessionFactory.getCurrentSession().get(Visit.class, id); }
    // add a visit
    public void addVisit(Visit visit){ sessionFactory.getCurrentSession().save(visit); }
    // delete a visit
    public void deleteVisit(Visit visit){ sessionFactory.getCurrentSession().delete(visit); }
    // update a visit
    public void updateVisit(Visit Visit){ sessionFactory.getCurrentSession().update(Visit); }
    // get all the visit of a patient by patient id
    public List<Visit> getVisitByPatient(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit v where v.patientVisit =:idParam");
        query.setInteger("idParam", id);
        return query.list();
    }
    // get all the visits by a date
    public List<Visit> getVisitByDate(Date date){
        Query query = sessionFactory.getCurrentSession().createQuery("from Visit v where v.visitDate=:dateParam");
        query.setDate("dateParam", date);
        return query.list();
    }
    // get a visit count by a date
    public int visitCountByDate(Date date){
        return getVisitByDate(date).size();
    }
    // delete a visit by id
    public void deleteVisitById(int id){
        Visit vis = (Visit) sessionFactory.getCurrentSession().get(Visit.class, id);
        deleteVisit(vis);
    }
    // set the visit's diagnoses by visit id and diagnose id
    public void setDiagnoseById(int visId, int diaId){
        Diagnose dia = (Diagnose) sessionFactory.getCurrentSession().get(Diagnose.class, diaId);
        Visit vis = (Visit) sessionFactory.getCurrentSession().get(Visit.class, visId);
        vis.setDiagnose(dia);
    }
    // set a patient's visit by patient id and visit id
    public void setPatientById(int visId, int patId){
        Patient pat = (Patient) sessionFactory.getCurrentSession().get(Patient.class, patId);
        Visit vis = (Visit) sessionFactory.getCurrentSession().get(Visit.class, visId);
        // i tried to do this by adding a Visit to the patient's visitList
        // unfortunately, no dice
        // pat.getVisitList().add(vis);
        vis.setPatientVisit(pat);
    }




}
