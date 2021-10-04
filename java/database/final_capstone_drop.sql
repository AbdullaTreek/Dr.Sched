-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2021-09-26 01:44:46.677

-- foreign keys
ALTER TABLE account
    DROP CONSTRAINT account_users;

ALTER TABLE appointment
    DROP CONSTRAINT appointment_patient;

ALTER TABLE appointment_status
    DROP CONSTRAINT appointment_status_appointment;

ALTER TABLE doctor
    DROP CONSTRAINT doctor_account;

ALTER TABLE doctor_availability
    DROP CONSTRAINT doctor_availability_office;

ALTER TABLE doctor_response
    DROP CONSTRAINT doctor_response_office;

ALTER TABLE doctor_response
    DROP CONSTRAINT doctor_response_patient_review;

ALTER TABLE office
    DROP CONSTRAINT office_doctor;

ALTER TABLE patient
    DROP CONSTRAINT patient_account;

ALTER TABLE patient_review
    DROP CONSTRAINT patient_review_office;

ALTER TABLE patient_review
    DROP CONSTRAINT patient_review_patient;

-- tables
DROP TABLE account;

DROP TABLE appointment;

DROP TABLE appointment_status;

DROP TABLE doctor;

DROP TABLE doctor_availability;

DROP TABLE doctor_response;

DROP TABLE office;

DROP TABLE patient;

DROP TABLE patient_review;

DROP TABLE users;

-- sequences
DROP SEQUENCE IF EXISTS seq_account_id;

DROP SEQUENCE IF EXISTS seq_appointment_id;

DROP SEQUENCE IF EXISTS seq_appointment_status_id;

DROP SEQUENCE IF EXISTS seq_doctor_availability;

DROP SEQUENCE IF EXISTS seq_doctor_id;

DROP SEQUENCE IF EXISTS seq_doctor_response;

DROP SEQUENCE IF EXISTS seq_office_id;

DROP SEQUENCE IF EXISTS seq_patient_id;

DROP SEQUENCE IF EXISTS seq_patient_review_id;

DROP SEQUENCE IF EXISTS seq_user_id;

-- End of file.

