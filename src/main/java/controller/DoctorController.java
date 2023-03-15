package controller;

import model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.DoctorService;

import java.util.List;
@RestController
@RequestMapping(path = "/")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;
    // returns all doctors on the table
    @RequestMapping(path = "doctor", method = RequestMethod.GET)
    public List<Doctor> getAllDoctor(){ return doctorService.getAllDoctor(); }
    // get a doctor by id
    @RequestMapping(path = "doctor/{id}", method = RequestMethod.GET)
    public Doctor getDoctorById(@PathVariable("id") int id){ return doctorService.getDoctorById(id); }
    // get all doctor with matching name
    @RequestMapping(path = "doctor/name/{name}", method = RequestMethod.GET)
    public List<Doctor> getDoctorsByName(@PathVariable("name") String name){ return doctorService.getDoctorByName(name); }
    //  add a doctor
    @RequestMapping(path = "doctor", method = RequestMethod.POST)
    public void addDoctor(@RequestBody Doctor doc){ doctorService.addDoctor(doc); }
    // delete a doctor
    @RequestMapping(path = "doctor", method = RequestMethod.DELETE)
    public void deleteDoctor(@RequestBody Doctor doc){ doctorService.deleteDoctor(doc); }
    // delete a doctor by id
    @RequestMapping(path = "doctor/{id}", method = RequestMethod.DELETE)
    public void deleteDoctorById(@PathVariable("id") int id){ doctorService.deleteDoctorById(id); }
    // update a doctor
    @RequestMapping(path = "doctor", method = RequestMethod.PUT)
    public void updateDoctor(@RequestBody Doctor doc){ doctorService.updateDoctor(doc); }




}
