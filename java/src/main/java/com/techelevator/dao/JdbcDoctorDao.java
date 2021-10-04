package com.techelevator.dao;

import com.techelevator.model.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcDoctorDao implements DoctorDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcDoctorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Doctor> findAll() {
        List<Doctor> doctors = new ArrayList<>();
        String sql = "SELECT * FROM doctor";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Doctor doctor = mapRowToDoctor(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public Doctor createDoctor(Doctor doctor) {

            String sql = "INSERT INTO doctor (first_name, last_name, user_type, summary, practicing_from, account_user_type) " +
                    "VALUES (?, ?, ?, ?, ?) RETURNING doctor_id;";
            Long newId = jdbcTemplate.queryForObject(sql, Long.class,
                    doctor.getFirstName(), doctor.getLastName(), doctor.getUserType(), doctor.getSummary(), doctor.getAccountUserType());
            return getDoctor(newId);
    }

    @Override
    public Doctor getDoctor(long userId) {
        Doctor doctor = null;
        String sql = "SELECT user_id, user_type, summary, practicing_from " +
                "FROM doctor " +
                "WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public Doctor getDoctorByAccountId(long accountId) {
        Doctor doctor = null;
        String sql = "SELECT user_id, user_type, summary, practicing_from " +
                "FROM doctor " +
                "WHERE account_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if (results.next()) {
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public Doctor getUserType(String userType) {
        return null;
    }


    @Override
    public Doctor getSummary(String summary) {
        Doctor doctor = null;
        String sql = "SELECT summary " +
                     "FROM doctor ";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            doctor = mapRowToDoctor(results);
        }
        return doctor;
    }

    @Override
    public boolean create(String firstName, String lastName, String officeName) {
        return false;
    }

    private Doctor mapRowToDoctor(SqlRowSet results) {
        Doctor doctor = new Doctor();
        doctor.setUserId(results.getLong("user_id"));
        doctor.setAccountId(results.getLong("account_id"));
        doctor.setUserType(results.getString("user_type"));
        doctor.setSummary(results.getString("summary"));

        doctor.setAccountUserType(results.getString("account_user_type"));
//        doctor.setOfficeName(results.getString("office_id"));

        doctor.setPracticingFrom(results.getDate("practicing_from").toLocalDate());
        doctor.setFirstName(results.getString("first_name"));
        doctor.setLastName(results.getString("last_name"));
        //        doctor.setAccountUserType(results.getString("account_user_type"));

        return doctor;
    }
}
