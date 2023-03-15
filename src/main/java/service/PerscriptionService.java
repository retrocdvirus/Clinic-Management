package service;

import model.*;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class PerscriptionService {
    
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    // returns all perscription on the table
    public List<Perscription> getAllPerscription(){ return sessionFactory.getCurrentSession().createQuery("from Perscription").list(); }
    // get a persciption by id
    public Perscription getPerscriptionById(int id){ return (Perscription) sessionFactory.getCurrentSession().get(Perscription.class, id); }
    // add a perscription
    public void addPerscription(Perscription perscript){ sessionFactory.getCurrentSession().save(perscript); }
    // delete a perscription
    public void deletePerscription(Perscription perscript){ sessionFactory.getCurrentSession().delete(perscript); }
    // update a perscription
    public void updatePerscription(Perscription perscript){ sessionFactory.getCurrentSession().update(perscript); }
    // get a perscription by diagnose id
    public List<Perscription> getPerscriptionByDiagnose(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from Perscription p where p.diagnosePerscription =:idParam");
        query.setInteger("idParam", id);
        return query.list();
    }
    // return a map of drug and quantity of each drug in the persription
    // i intended to return Drug an Integer but the Drug object is un-readable in the json
    // so i decided to return the drug name and quantity instead
    public Map<String, Integer> getDrugAndQuantity(int id){
        Map<String, Integer> drugAndQuantity = new HashMap<>();
        Perscription perscript = (Perscription) sessionFactory.getCurrentSession().get(Perscription.class, id);
        for (PerscriptionDetail p :perscript.getPerscriptionDetailList()){
            drugAndQuantity.put(p.getDrugDetail().getDrugName(), p.getQuantity());
        }
        return drugAndQuantity;
    }
    // add a perscription detail to a perscription by perscription detail id and perscription id
    public void addPerscriptionDetailById(int perscriptId, int perscriptionDetailId){
        Perscription perscript = (Perscription) sessionFactory.getCurrentSession().get(Perscription.class, perscriptId);
        PerscriptionDetail perscriptDetail = (PerscriptionDetail) sessionFactory.getCurrentSession().get(PerscriptionDetail.class, perscriptionDetailId);
        //perscript.getPerscriptionDetailList().add(perscriptDetail);
        perscriptDetail.setPerscription(perscript);
    }
    // delete a perscription by id
    public void deletePerscriptionById(int id){
        Perscription perscript = (Perscription) sessionFactory.getCurrentSession().get(Perscription.class, id);
        deletePerscription(perscript);
    }
    // set a list perscription details to a perscription
    public void setPerscriptionDetailByList(int id, List<PerscriptionDetail> perscriptDetails){
        Perscription perscript = (Perscription) sessionFactory.getCurrentSession().get(Perscription.class, id);
        for(PerscriptionDetail p: perscriptDetails){
            sessionFactory.getCurrentSession().save(p);
            p.setPerscription(perscript);
        }
    }

}
