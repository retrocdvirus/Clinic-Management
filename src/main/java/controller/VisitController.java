package controller;

import model.Patient;
import model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.VisitService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path = "/")
public class VisitController {
    
    @Autowired
    private VisitService visitService;
    // returns all visit on the table
    @RequestMapping(path = "visit", method = RequestMethod.GET)
    public List<Visit> getAllVisit(){ return visitService.getAllVisit(); }
    // get a visit by id
    @RequestMapping(path = "visit/{id}", method = RequestMethod.GET)
    public Visit getVisitById(@PathVariable("id") int id){ return visitService.getVisitById(id); }
    // get all visit of a patient
    @RequestMapping(path = "visit/patient/{id}", method = RequestMethod.GET)
    public List<Visit> getVisitByPatient(@PathVariable("id") int id){ return visitService.getVisitByPatient(id); }
    //  get all visit by a date
    @RequestMapping(path = "visit/date/{year}/{month}/{day}", method = RequestMethod.GET)
    public List<Visit> getVisitByDate(@PathVariable("year") String year,@PathVariable("month") String month,@PathVariable("day") String day) throws ParseException {
        String dateString = year + "-" + month + "-" + day;
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        return visitService.getVisitByDate(date);
    }
    // get visit count by date
    @RequestMapping(path = "visit/date/count/{year}/{month}/{day}", method = RequestMethod.GET)
    public int getVisitCountByDate(@PathVariable("year") String year,@PathVariable("month") String month,@PathVariable("day") String day) throws ParseException {
        String dateString = year + "-" + month + "-" + day;
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        return visitService.visitCountByDate(date);
    }
    // add a visit
    @RequestMapping(path = "visit", method = RequestMethod.POST)
    public void addVisit(@RequestBody Visit Visit){ visitService.addVisit(Visit); }
    // delete a visit
    @RequestMapping(path = "visit", method = RequestMethod.DELETE)
    public void deleteVisit(@RequestBody Visit visit){ visitService.deleteVisit(visit); }
    // delete a visit by id
    @RequestMapping(path = "visit/{id}", method = RequestMethod.DELETE)
    public void deleteVisitById(@PathVariable("id") int id){ visitService.deleteVisitById(id); }
    // update a visit
    @RequestMapping(path = "visit", method = RequestMethod.PUT)
    public void updateVisit(@RequestBody Visit Visit){ visitService.updateVisit(Visit); }
    // set a visit's diagnose by visit id and diagnose id
    @RequestMapping(path = "visit/{visId}/{diaId}", method = RequestMethod.PUT)
    public void setDiagnoseById(@PathVariable("visId") int visId, @PathVariable("diaId") int diaId){ visitService.setDiagnoseById(visId, diaId); }
    // set a patient's visit by visit is and patient id
    @RequestMapping(path = "visit/patient/{visId}/{patId}", method = RequestMethod.PUT)
    public void setPatientById(@PathVariable("patId") int patId, @PathVariable("visId") int visId){ visitService.setPatientById(visId, patId); }


}
