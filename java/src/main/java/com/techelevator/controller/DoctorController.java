package com.techelevator.controller;


import com.techelevator.dao.DoctorDao;
import com.techelevator.dao.OfficeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Doctor;
import com.techelevator.model.Office;
import com.techelevator.model.Patient;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("isAuthenticated()")
//@RequestMapping("doctor")
public class DoctorController {

    private DoctorDao doctorDao;
    private UserDao userDao;
    private OfficeDao officeDao;

    public DoctorController(DoctorDao doctorDao, UserDao userDao, OfficeDao officeDao) {
        this.doctorDao = doctorDao;
        this.userDao = userDao;
        this.officeDao = officeDao;
    }

//  Create doctor
    @PreAuthorize("isAuthenticated")
    @RequestMapping( path = "/doctor/{id}", method = RequestMethod.POST)
    public Doctor createDoctor(@RequestBody Doctor doctor, @PathVariable("id") long doctorId) {
        return doctorDao.createDoctor(doctor);
    }

//  Get doctor by id
    @RequestMapping(path = "/doctor", method = RequestMethod.GET)
    public Doctor getDoctor(@PathVariable long doctorId){
        return doctorDao.getDoctor(doctorId);
    }

    // get office by Office Id
    @RequestMapping(path = "/office", method = RequestMethod.GET)
    public Office getOffice(@PathVariable long officeId){return officeDao.getOfficeInfoByOfficeId(officeId);}

    //@RequestMapping( path = "/Office/{id}", method = RequestMethod.POST)
    // public Patient updateInfoByOfficeId(@RequestBody Office Office, @PathVariable("id") long OfficeId){
    // return OfficeDao.updateInfoByOfficeId(Office);}
}
