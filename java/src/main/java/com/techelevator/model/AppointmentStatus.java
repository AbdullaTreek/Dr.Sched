package com.techelevator.model;

public class AppointmentStatus {

    private long appointmentStatusId;
    private long appointmentId;
    private long status;


// Getter and Setter

    public long getAppointmentStatusId() {
        return appointmentStatusId;
    }
    public void setAppointmentStatusId(long appointmentStatusId) {
        this.appointmentStatusId = appointmentStatusId;
    }

    public long getAppointmentId() {
        return appointmentId;
    }
    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public long getStatus() {
        return status;
    }
    public void setStatus(long status) {
        this.status = status;
    }
}
