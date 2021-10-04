package com.techelevator.dao;

import com.techelevator.model.AppointmentStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcAppointmentStatusDao implements AppointmentStatusDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcAppointmentStatusDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public AppointmentStatus getAppointmentStatusById(long appointmentStatusId) {
        String sql = "SELECT * FROM appointment_status WHERE appointment_status_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, appointmentStatusId);
        if(results.next()) {
            return mapRowToAppointmentStatus(results);
        } else {
            throw new RuntimeException("Appointment id " + appointmentStatusId + " was not found.");
        }
    }

//  ***Appointment Status MAP ***
    private AppointmentStatus mapRowToAppointmentStatus(SqlRowSet results){
        AppointmentStatus appointmentStatus = new AppointmentStatus();
        appointmentStatus.setAppointmentStatusId(results.getLong("appointment_status_id"));
        appointmentStatus.setAppointmentId(results.getLong("appointment_id"));
        appointmentStatus.setStatus(results.getLong("status"));

        return appointmentStatus;
    }
}
