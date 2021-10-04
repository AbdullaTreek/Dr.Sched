package com.techelevator.dao;

import com.techelevator.model.DoctorResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorResponse implements DoctorResponseDao{
    private JdbcTemplate jdbcTemplate;
    public void JdbcDoctorResponseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<DoctorResponse> getAllDoctorResponse() {
        List<DoctorResponse> response = new ArrayList<>();
        String sql = "SELECT response, response_date FROM doctor_response_id ";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            DoctorResponse responses = mapRowToDoctorResponse(results);
            response.add(responses);
        }
        return response;
    }

    @Override
    public DoctorResponse getDoctorResponse(long doctorResponseId) {
        DoctorResponse response = null;
        String sql = "SELECT doctor_response_id, patient_review_id, response, response_date, office_doctor_id " +
                "FROM doctor_response " +
                "WHERE doctor_response_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorResponseId);
        if (results.next()) {
            response = mapRowToDoctorResponse(results);
        }
        return response;
    }


//  *** Dr. Response MAP ***
    private DoctorResponse mapRowToDoctorResponse(SqlRowSet results) {
        DoctorResponse response = new DoctorResponse();
        response.setDoctorResponseId(results.getLong("doctor_response_id"));
        response.setPatientReviewId(results.getLong("patient_review_id"));
        response.setResponse(results.getString("response"));
        response.setResponseDate(results.getDate("response_date").toLocalDate());
        response.setDoctorOfficeId(results.getLong("office_doctor_id"));

        return response;
    }
}
