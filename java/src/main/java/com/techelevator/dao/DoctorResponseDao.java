package com.techelevator.dao;

import com.techelevator.model.DoctorResponse;

import java.util.List;

public interface DoctorResponseDao {

    List<DoctorResponse> getAllDoctorResponse();

    DoctorResponse getDoctorResponse(long doctorResponseId);


}
