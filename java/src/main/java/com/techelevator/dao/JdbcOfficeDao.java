package com.techelevator.dao;

import com.techelevator.model.Office;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcOfficeDao implements OfficeDao{
    private JdbcTemplate jdbcTemplate;
    public JdbcOfficeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Office getOfficeInfoByOfficeId(long officeId) {
        Office office = null;
        String sql = "SELECT street_address, city, state, county, zip, consultation_fee FROM office WHERE office_id = ?";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, officeId);
        if (result.next()) {
            office = mapRowToOffice(result);
        }
        return office;
    }

    @Override
    public void updateInfoByOfficeId(Office office) {
        String sql = "UPDATE office " +
                "SET street_address = ?, city = ?, state = ?, county = ?, zip = ?, consultation_fee = ? " +
                "WHERE office_id = ?;";
        jdbcTemplate.update(sql, office.getStreetAddress(), office.getCity(), office.getState(),
                office.getCounty(), office.getZip(), office.getConsultationFee());
    }

    @Override
    public void updateInfoByDoctorId(Office office) {
        String sql = "UPDATE office " +
                "SET street_address = ?, city = ?, state = ?, county = ?, zip = ?, consultation_fee = ? " +
                "WHERE doctor_id = ?;";
        jdbcTemplate.update(sql, office.getStreetAddress(), office.getCity(), office.getState(),
                office.getCounty(), office.getZip(), office.getConsultationFee());
    }


    private Office mapRowToOffice(SqlRowSet results) {
        Office office = new Office();
        office.setOfficeId(results.getLong("office_id"));
        office.setDoctorId(results.getLong("doctor_id"));
        office.setStreetAddress(results.getString("street_address"));
        office.setCity(results.getString("city"));
        office.setState(results.getString("state"));
        office.setCounty(results.getString("county"));
        office.setZip(results.getString("zip"));
        office.setConsultationFee(results.getInt("consultation_fee"));
        return office;
    }
}
