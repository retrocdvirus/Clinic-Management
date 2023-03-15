package controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PatientService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(path = "/")
public class PatientController {

    @Autowired
    private PatientService patientService;
    // returns all patient on the table
    @RequestMapping(path = "patient", method = RequestMethod.GET)
    public List<Patient> getAllPatient(){ return patientService.getAllPatient(); }
    // get a patient by id
    @RequestMapping(path = "patient/{id}", method = RequestMethod.GET)
    public Patient getPatientById(@PathVariable("id") int id){ return patientService.getPatientById(id); }
    // get all patient with matching name
    @RequestMapping(path = "patient/name/{name}", method = RequestMethod.GET)
    public List<Patient> getPatientByName(@PathVariable("name") String name){ return patientService.getPatientByName(name); }
    // get all patient by dob
    @RequestMapping(path = "patient/date/{year}/{month}/{day}", method = RequestMethod.GET)
    public List<Patient> getPatientByBirth(@PathVariable("year") String year,@PathVariable("month") String month,@PathVariable("day") String day) throws ParseException {
        String dateString = year + "-" + month + "-" + day;
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        return patientService.getPatientByBirth(date);
    }
    // add a patient
    @RequestMapping(path = "patient", method = RequestMethod.POST)
    public void addPatient(@RequestBody Patient patient){ patientService.addPatient(patient); }
    // delete a patient
    @RequestMapping(path = "patient", method = RequestMethod.DELETE)
    public void deletePatient(@RequestBody Patient patient){ patientService.deletePatient(patient); }
    // delete a patient by id
    @RequestMapping(path = "patient/{id}", method = RequestMethod.DELETE)
    public void deletePatientById(@PathVariable("id") int id){ patientService.deletePatientById(id); }
    // update a patient
    @RequestMapping(path = "patient", method = RequestMethod.PUT)
    public void updatePatient(@RequestBody Patient patient){ patientService.updatePatient(patient); }
    // update a patient address
    @RequestMapping(path = "patient/address/{id}", method = RequestMethod.PUT)
    public void updatePatientAddress(@RequestBody String newAddress, @PathVariable("id") int id){ patientService.updatePatientAddress(id, newAddress); }

}
