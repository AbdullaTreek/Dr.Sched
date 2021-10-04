package com.techelevator.dao;

import com.techelevator.model.AppointmentStatus;

public interface AppointmentStatusDao {

    AppointmentStatus getAppointmentStatusById(long appointmentStatusId);
}
