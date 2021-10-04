package com.techelevator.model;

public class Office {

    private long officeId;
    private long doctorId;
    private String streetAddress;
    private String city;
    private String state;
    private String county;
    private String zip;
    private int consultationFee;


// Getter and Setter
    public long getOfficeId() {
        return officeId;
    }
    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public long getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(long doctorId) {
        this.doctorId = doctorId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getCounty() {
        return county;
    }
    public void setCounty(String county) {
        this.county = county;
    }

    public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getConsultationFee() {
        return consultationFee;
    }
    public void setConsultationFee(int consultationFee) {
        this.consultationFee = consultationFee;
    }
}
