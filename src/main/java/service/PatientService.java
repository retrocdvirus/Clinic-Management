package service;

import model.Patient;
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
public class PatientService {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    // returns all patients in the table
    public List<Patient> getAllPatient(){ return sessionFactory.getCurrentSession().createQuery("from Patient").list(); }
    // find a patient by id
    public Patient getPatientById(int id){ return (Patient) sessionFactory.getCurrentSession().get(Patient.class, id); }
    // add a new patient
    public void addPatient(Patient patient){ sessionFactory.getCurrentSession().save(patient); }
    // delete a patient
    public void deletePatient(Patient patient){ sessionFactory.getCurrentSession().delete(patient); }
    // update a patient
    public void updatePatient(Patient patient){ sessionFactory.getCurrentSession().update(patient); }
    // search for all patient with a matching name
    public List<Patient> getPatientByName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient p where p.name like :nameParam");
        query.setString("nameParam", "%"+name+"%");
        return query.list();
    }
    // find all patient by dob
    public List<Patient> getPatientByBirth(Date date){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient p where p.dob=:dateParam");
        query.setDate("dateParam", date);
        return query.list();
    }
    // updates only a patients address
    public void updatePatientAddress(int id, String newAddress){
        Patient pat = (Patient) sessionFactory.getCurrentSession().get(Patient.class, id);
        pat.setAddress(newAddress);
        sessionFactory.getCurrentSession().update(pat);
    }
    // delete a patient by id
    public void deletePatientById(int id){
        Patient pat = (Patient) sessionFactory.getCurrentSession().get(Patient.class, id);
        deletePatient(pat);
    }


}