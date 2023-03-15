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
public class PerscriptionDetailService {
    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) { this.sessionFactory = sessionFactory; }
    // returns all perscription detail on the table
    public List<PerscriptionDetail> getAllPerscriptionDetail(){ return sessionFactory.getCurrentSession().createQuery("from PerscriptionDetail").list(); }
    // get perscription detail by id
    public PerscriptionDetail getPerscriptionDetailById(int id){ return (PerscriptionDetail) sessionFactory.getCurrentSession().get(PerscriptionDetail.class, id); }
    // add a perscription detail
    public void addPerscriptionDetail(PerscriptionDetail perscriptionDetail){ sessionFactory.getCurrentSession().save(perscriptionDetail); }
    // delete a perscription detail
    public void deletePerscriptionDetail(PerscriptionDetail perscriptionDetail){ sessionFactory.getCurrentSession().delete(perscriptionDetail); }
    // update a perscription detail
    public void updatePerscriptionDetail(PerscriptionDetail perscriptionDetail){ sessionFactory.getCurrentSession().update(perscriptionDetail); }
    // get all perscription detail by perscription
    public List<PerscriptionDetail> getPerscriptionDetailByPerscription(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from PerscriptionDetail p where p.perscription =:idParam");
        query.setInteger("idParam", id);
        return query.list();
    }
    // delete a perscription detail by id
    public void deletePerscriptionDetailById(int id){
        PerscriptionDetail vis = (PerscriptionDetail) sessionFactory.getCurrentSession().get(PerscriptionDetail.class, id);
        deletePerscriptionDetail(vis);
    }
    // set a perscription detail to a perscription by perscription detail id and perscription id
    public void setPerscriptionById(int perscriptDetialId, int perscriptId){
        PerscriptionDetail perscriptDetail = (PerscriptionDetail) sessionFactory.getCurrentSession().get(PerscriptionDetail.class, perscriptDetialId);
        Perscription perscript = (Perscription) sessionFactory.getCurrentSession().get(Perscription.class, perscriptId);
        perscriptDetail.setPerscription(perscript);
    }
    // set a drug to a perscription detail by perscription detail id and drug id
    public void setDrugById(int perscriptdetailId, int drugId){
        PerscriptionDetail perscriptdetail = (PerscriptionDetail) sessionFactory.getCurrentSession().get(PerscriptionDetail.class, perscriptdetailId);
        Drug drug = (Drug) sessionFactory.getCurrentSession().get(Drug.class, drugId);
        perscriptdetail.setDrugDetail(drug);
    }
}
