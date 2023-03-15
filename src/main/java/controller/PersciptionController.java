package controller;

import model.Diagnose;
import model.Drug;
import model.Perscription;
import model.PerscriptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PerscriptionService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/")
public class PersciptionController {
    
    @Autowired
    private PerscriptionService perscriptionService;
    // returns all perscription on the table
    @RequestMapping(path = "perscription", method = RequestMethod.GET)
    public List<Perscription> getAllPerscription(){ return perscriptionService.getAllPerscription(); }
    // get a perscription by id
    @RequestMapping(path = "perscription/{id}", method = RequestMethod.GET)
    public Perscription getPerscriptionById(@PathVariable("id") int id){ return perscriptionService.getPerscriptionById(id); }
    // get all drugs and quantity of each drug in the perscription
    @RequestMapping(path = "perscription/detail/{id}", method = RequestMethod.GET)
    public Map<String, Integer> getDrugAndQuantity(@PathVariable("id") int id){ return perscriptionService.getDrugAndQuantity(id); }
    // get a perscription by diagnose
    @RequestMapping(path = "perscription/diagnose/{id}", method = RequestMethod.GET)
    public List<Perscription> getPerscriptionByDiagnose(@PathVariable("id") int id){ return perscriptionService.getPerscriptionByDiagnose(id); }
    // add a perscription
    @RequestMapping(path = "perscription", method = RequestMethod.POST)
    public void addPerscription(@RequestBody Perscription perscription){ perscriptionService.addPerscription(perscription); }
    // delete a perscription
    @RequestMapping(path = "perscription", method = RequestMethod.DELETE)
    public void deletePerscription(@RequestBody Perscription perscription){ perscriptionService.deletePerscription(perscription); }
    // delete a perscription by id
    @RequestMapping(path = "perscription/{id}", method = RequestMethod.DELETE)
    public void deletePerscriptionById(@PathVariable("id") int id) { perscriptionService.deletePerscriptionById(id); }
    // update a persciption
    @RequestMapping(path = "perscription", method = RequestMethod.PUT)
    public void updatePerscription(@RequestBody Perscription perscription){ perscriptionService.updatePerscription(perscription); }
    // add a list of perscription detail to a perscription
    @RequestMapping(path = "perscription/detail/{perscriptId}", method = RequestMethod.PUT)
    public void setPerscriptionDetailByList(@PathVariable("perscriptId") int perscriptId, @RequestBody List<PerscriptionDetail> perscriptDetails) { perscriptionService.setPerscriptionDetailByList(perscriptId, perscriptDetails); }
    // set a perscription's percripion detail by perscription id and perscription detail id
    @RequestMapping(path = "perscription/detail/{perscriptId}/{perscriptDetailId}", method = RequestMethod.PUT)
    public void addPerscriptionDetailById(@PathVariable("perscriptId") int perscriptId, @PathVariable("perscriptDetailId") int perscriptDetailId){ perscriptionService.addPerscriptionDetailById(perscriptId, perscriptDetailId); }

}
