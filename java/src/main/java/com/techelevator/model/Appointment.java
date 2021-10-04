package com.techelevator.model;

import java.time.LocalDate;

public class Appointment {

    private long appointmentId;
    private long patientId;
    private long officeId;
    private String startTime;
    private String endTime;
    private long appointmentStatusId;
    private LocalDate appointmentDate;

//Getter and Setter

    public long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public long getPatientId() {
        return patientId;
    }
    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public long getOfficeId() {
        return officeId;
    }
    public void setOfficeId(long officeId) {
        this.officeId = officeId;
    }

    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public long getAppointmentStatusId() {
        return appointmentStatusId;
    }
    public void setAppointmentStatusId(long appointmentStatusId) {
        this.appointmentStatusId = appointmentStatusId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
}
