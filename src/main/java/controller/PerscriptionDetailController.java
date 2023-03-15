package controller;

import model.PerscriptionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PerscriptionDetailService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class PerscriptionDetailController {

    @Autowired
    private PerscriptionDetailService perscriptionDetailService;
    // returns all perscription details on the table
    @RequestMapping(path = "perscriptiondetail", method = RequestMethod.GET)
    public List<PerscriptionDetail> getAllPerscriptionDetail(){ return perscriptionDetailService.getAllPerscriptionDetail(); }
    // get a perscription detail by id
    @RequestMapping(path = "perscriptiondetail/{id}", method = RequestMethod.GET)
    public PerscriptionDetail getPerscriptionDetailById(@PathVariable("id") int id){ return perscriptionDetailService.getPerscriptionDetailById(id); }
    // get all perscription detail by perscription
    @RequestMapping(path = "perscriptiondetail/perscription/{id}", method = RequestMethod.GET)
    public List<PerscriptionDetail> getPerscriptionDetailByPerscription(@PathVariable("id") int id){ return perscriptionDetailService.getPerscriptionDetailByPerscription(id); }
    // add a perscription detail
    @RequestMapping(path = "perscriptiondetail", method = RequestMethod.POST)
    public void addPerscriptionDetail(@RequestBody PerscriptionDetail perscriptionDetail){ perscriptionDetailService.addPerscriptionDetail(perscriptionDetail); }
    // delete a perscription detail
    @RequestMapping(path = "perscriptiondetail", method = RequestMethod.DELETE)
    public void deletePerscriptionDetail(@RequestBody PerscriptionDetail perscriptionDetail){ perscriptionDetailService.deletePerscriptionDetail(perscriptionDetail); }
    // delete a perscription detail by id
    @RequestMapping(path = "perscriptiondetail/{id}", method = RequestMethod.DELETE)
    public void deletePerscriptionDetail(@PathVariable("id") int id){ perscriptionDetailService.deletePerscriptionDetailById(id); }
     // update a perscription detail
    @RequestMapping(path = "perscriptiondetail", method = RequestMethod.PUT)
    public void updatePerscriptionDetail(@RequestBody PerscriptionDetail perscriptionDetail){ perscriptionDetailService.updatePerscriptionDetail(perscriptionDetail); }
    // set a perscription detail's drug by perscription detail id and drug id
    @RequestMapping(path = "perscriptiondetail/drug/{perscriptdetailId}/{drugId}", method = RequestMethod.PUT)
    public void setDrugById(@PathVariable("perscriptdetailId") int perscriptdetailId, @PathVariable("drugId") int drugId){ perscriptionDetailService.setDrugById(perscriptdetailId, drugId); }
    // set a perscription detail to a perscription by perscription detail id and perscription id
    @RequestMapping(path = "perscriptiondetail/perscription/{perscriptDetailId}/{perscriptId}", method = RequestMethod.PUT)
    public void addPerscriptionDetailById(@PathVariable("perscriptId") int perscriptId, @PathVariable("perscriptDetailId") int perscriptDetailId){ perscriptionDetailService.setPerscriptionById(perscriptDetailId, perscriptId); }

}