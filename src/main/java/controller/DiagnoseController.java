package controller;

import model.Diagnose;
import model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DiagnoseService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class DiagnoseController {
    
    @Autowired
    private DiagnoseService diagnoseService;
    // returns all diagnose on the table
    @RequestMapping(path = "diagnose", method = RequestMethod.GET)
    public List<Diagnose> getAllDiagnose(){ return diagnoseService.getAllDiagnose(); }
    // get a diagnose by id
    @RequestMapping(path = "diagnose/{id}", method = RequestMethod.GET)
    public Diagnose getDiagnoseById(@PathVariable("id") int id){ return diagnoseService.getDiagnoseById(id); }
    // get all diagnose a doctor has made
    @RequestMapping(path = "diagnose/doc/{id}", method = RequestMethod.GET)
    public List<Diagnose> getDiagnoseByDoc(@PathVariable("id") int id){ return diagnoseService.getDiagnoseByDoc(id); }
    // get all patient with the same illness
    @RequestMapping(path = "diagnose/ill/{id}", method = RequestMethod.GET)
    public List<Diagnose> getDiagnoseByIllness(@PathVariable("id") int id){ return diagnoseService.getDiagnoseByIllness(id); }
    // add a diagnose
    @RequestMapping(path = "diagnose", method = RequestMethod.POST)
    public void addDiagnose(@RequestBody Diagnose diagnose){ diagnoseService.addDiagnose(diagnose); }
    // delete a diagnose
    @RequestMapping(path = "diagnose", method = RequestMethod.DELETE)
    public void deleteDiagnose(@RequestBody Diagnose diagnose){ diagnoseService.deleteDiagnose(diagnose); }
    // delete a diagnose by id
    @RequestMapping(path = "diagnose/{id}", method = RequestMethod.DELETE)
    public void deleteDiagnose(@PathVariable("id") int id){ diagnoseService.deleteDiagnoseById(id); }
    //  update a diagnose
    @RequestMapping(path = "diagnose", method = RequestMethod.PUT)
    public void updateDiagnose(@RequestBody Diagnose diagnose){ diagnoseService.updateDiagnose(diagnose); }
    // set a diagnose's illness code by diagnose id and illness code id
    @RequestMapping(path = "diagnose/ill/{diaId}/{IllId}", method = RequestMethod.PUT)
    public void setIllnessById(@PathVariable("IllId") int IllId, @PathVariable("diaId") int diaId){ diagnoseService.setIllnessById(diaId, IllId); }
    // set a doctor to a diagnose by diagnose id and doctor id
    @RequestMapping(path = "diagnose/doc/{diaId}/{docId}", method = RequestMethod.PUT)
    public void setDocById(@PathVariable("docId") int docId, @PathVariable("diaId") int diaId){ diagnoseService.setDocById(diaId, docId); }
    // set a diagnose's perscription by diagnose id and perscription id
    @RequestMapping(path = "diagnose/perscript/{diaId}/{perscriptId}", method = RequestMethod.PUT)
    public void setPerscriptionById(@PathVariable("perscriptId") int perscriptId, @PathVariable("diaId") int diaId){ diagnoseService.setPerscriptionById(diaId, perscriptId); }
}
