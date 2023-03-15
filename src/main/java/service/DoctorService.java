package service;

import model.Doctor;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DoctorService {
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    // returns all doctors on the table
    public List<Doctor> getAllDoctor(){ return sessionFactory.getCurrentSession().createQuery("from Doctor").list(); }
    // get a doctor by id
    public Doctor getDoctorById(int id){ return (Doctor) sessionFactory.getCurrentSession().get(Doctor.class, id); }
    // add a doctor
    public void addDoctor(Doctor doc){ sessionFactory.getCurrentSession().save(doc); }
    // delete a doctor
    public void deleteDoctor(Doctor doc){ sessionFactory.getCurrentSession().delete(doc); }
    // update a doctor
    public void updateDoctor(Doctor doc){ sessionFactory.getCurrentSession().update(doc); }
    // get all doctor with matching name
    public List<Doctor> getDoctorByName(String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Doctor d where v.name like :nameParam");
        query.setString("nameParam", "%"+name+"%");
        return query.list();
    }
    // delete a doctor by id
    public void deleteDoctorById(int id){
        Doctor pat = (Doctor) sessionFactory.getCurrentSession().get(Doctor.class, id);
        deleteDoctor(pat);
    }


    
    
}
