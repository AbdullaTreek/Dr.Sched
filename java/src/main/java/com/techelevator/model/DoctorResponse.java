package com.techelevator.model;

import java.time.LocalDate;

public class DoctorResponse {

    private long doctorResponseId;
    private long patientReviewId;
    private String response;
    private LocalDate responseDate;
    private long doctorOfficeId;

// Getter and Setter

    public long getDoctorResponseId() {
        return doctorResponseId;
    }
    public void setDoctorResponseId(long doctorResponseId) {
        this.doctorResponseId = doctorResponseId;
    }

    public long getPatientReviewId() {
        return patientReviewId;
    }
    public void setPatientReviewId(long patientReviewId) {
        this.patientReviewId = patientReviewId;
    }

    public String getResponse() {
        return response;
    }
    public void setResponse(String response) {
        this.response = response;
    }

    public LocalDate getResponseDate() {
        return responseDate;
    }
    public void setResponseDate(LocalDate responseDate) {
        this.responseDate = responseDate;
    }

    public long getDoctorOfficeId() {
        return doctorOfficeId;
    }
    public void setDoctorOfficeId(long doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }
}
