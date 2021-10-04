package com.techelevator.dao;

import com.techelevator.model.Doctor;

import java.util.List;

public interface DoctorDao {
    List<Doctor> findAll();

    Doctor createDoctor(Doctor doctor);

    Doctor getDoctor(long userId); // get the Doctors Id

    Doctor getDoctorByAccountId(long accountId);

    Doctor getUserType(String userType); // user is doctor

    Doctor getSummary(String summary);

    boolean create(String firstName, String lastName, String officeName);

}
