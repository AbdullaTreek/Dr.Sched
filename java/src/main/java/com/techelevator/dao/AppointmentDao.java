package com.techelevator.dao;

import com.techelevator.model.Appointment;

public interface AppointmentDao {

    Appointment createAppointment(Appointment appointment);

    Appointment getAppointment(long appointmentId);

    Appointment getAppointmentById(long appointmentId);
}
