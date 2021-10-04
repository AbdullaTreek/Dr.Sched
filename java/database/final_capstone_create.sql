-- tables


-- Table: account
CREATE TABLE account (
    account_id int  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    email varchar(50)  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT account_pk PRIMARY KEY (account_id)
);

-- Table: appointment
CREATE TABLE appointment (
    appointment_id int  NOT NULL,
    patient_id int  NOT NULL,
    office_id int  NOT NULL,
    start_time timestamp  NOT NULL,
    end_time timestamp  NOT NULL,
    appointment_status_id int  NOT NULL,
    appointment_date date  NOT NULL,
    CONSTRAINT appointment_pk PRIMARY KEY (appointment_id)
);

-- Table: appointment_status
CREATE TABLE appointment_status (
    appointment_status_id int  NOT NULL,
    status varchar(20)  NOT NULL,
    appointment_id int  NOT NULL,
    CONSTRAINT appointment_status_pk PRIMARY KEY (appointment_status_id)
);

-- Table: doctor
CREATE TABLE doctor (
    doctor_id int  NOT NULL,
    summary varchar(500)  NOT NULL,
    user_type varchar(10)  NOT NULL,
    account_id int NOT NULL,
    CONSTRAINT account_fk FOREIGN KEY(account_id) REFERENCES account(account_id),
    CONSTRAINT doctor_pk PRIMARY KEY (doctor_id)
);

-- Table: doctor_availability
CREATE TABLE doctor_availability (
    doctor_availability_id int  NOT NULL,
    office_doctor_id int  NOT NULL,
    day_of_week varchar(10)  NOT NULL,
    start_time timestamp  NOT NULL,
    end_time timestamp  NOT NULL,
    availability char(1)  NOT NULL,
    CONSTRAINT doctor_availability_pk PRIMARY KEY (doctor_availability_id)
);

-- Table: doctor_response
CREATE TABLE doctor_response (
    doctor_response_id int  NOT NULL,
    patient_review_id int  NOT NULL,
    response varchar(500)  NOT NULL,
    response_date date  NOT NULL,
    office_doctor_id int  NOT NULL,
    CONSTRAINT doctor_response_pk PRIMARY KEY (doctor_response_id)
);

-- Table: office
CREATE TABLE office (
    office_id int  NOT NULL,
    doctor_id int,
<<<<<<< HEAD
=======
    consultation_fee int,
>>>>>>> b0a749c64ca51b22ab5ade6c6a4511087af1e215
    street_address varchar(100)  NOT NULL,
    city varchar(100)  NOT NULL,
    state varchar(100)  NOT NULL,
    zip varchar(50)  NOT NULL,
    CONSTRAINT office_pk PRIMARY KEY (office_id)
);

-- Table: patient
CREATE TABLE patient (
    patient_id int  NOT NULL,
    user_type varchar(10)  NOT NULL,
    account_id int NOT NULL,
    CONSTRAINT account_fk FOREIGN KEY(account_id) REFERENCES account(account_id),
    CONSTRAINT patient_pk PRIMARY KEY (patient_id)
);

-- Table: patient_review
CREATE TABLE patient_review (
    patient_review_id int  NOT NULL,
    patient_id int  NOT NULL,
    overall_rating int  NOT NULL,
    review varchar(500)  NOT NULL,
    office_id int  NOT NULL,
    CONSTRAINT patient_review_pk PRIMARY KEY (patient_review_id)
);

-- Table: users
CREATE TABLE users (
    user_id int  NOT NULL DEFAULT nextval( 'seq_user_id' :: regclass ),
    username varchar(50)  NOT NULL,
    password_hash varchar(200)  NOT NULL,
    role varchar(50)  NOT NULL,
    CONSTRAINT role_id UNIQUE (role) NOT DEFERRABLE  INITIALLY IMMEDIATE,
    CONSTRAINT PK_user PRIMARY KEY (user_id)
);

-- foreign keys
-- Reference: account_users (table: account)
ALTER TABLE account ADD CONSTRAINT account_users
    FOREIGN KEY (user_id)
    REFERENCES users (user_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: appointment_patient (table: appointment)
ALTER TABLE appointment ADD CONSTRAINT appointment_patient
    FOREIGN KEY (patient_id)
    REFERENCES patient (patient_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: appointment_status_appointment (table: appointment_status)
ALTER TABLE appointment_status ADD CONSTRAINT appointment_status_appointment
    FOREIGN KEY (appointment_id)
    REFERENCES appointment (appointment_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: doctor_account (table: doctor)
ALTER TABLE doctor ADD CONSTRAINT doctor_account
    FOREIGN KEY (doctor_id)
    REFERENCES account (account_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: doctor_availability_office (table: doctor_availability)
ALTER TABLE doctor_availability ADD CONSTRAINT doctor_availability_office
    FOREIGN KEY (office_doctor_id)
    REFERENCES office (office_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: doctor_response_office (table: doctor_response)
ALTER TABLE doctor_response ADD CONSTRAINT doctor_response_office
    FOREIGN KEY (office_doctor_id)
    REFERENCES office (office_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: doctor_response_patient_review (table: doctor_response)
ALTER TABLE doctor_response ADD CONSTRAINT doctor_response_patient_review
    FOREIGN KEY (patient_review_id)
    REFERENCES patient_review (patient_review_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: office_doctor (table: office)
ALTER TABLE office ADD CONSTRAINT office_doctor
    FOREIGN KEY (doctor_id)
    REFERENCES doctor (doctor_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: patient_account (table: patient)
ALTER TABLE patient ADD CONSTRAINT patient_account
    FOREIGN KEY (patient_id)
    REFERENCES account (account_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: patient_review_office (table: patient_review)
ALTER TABLE patient_review ADD CONSTRAINT patient_review_office
    FOREIGN KEY (office_id)
    REFERENCES office (office_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: patient_review_patient (table: patient_review)
ALTER TABLE patient_review ADD CONSTRAINT patient_review_patient
    FOREIGN KEY (patient_id)
    REFERENCES patient (patient_id)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- sequences
-- Sequence: seq_account_id
CREATE SEQUENCE seq_account_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_appointment_id
CREATE SEQUENCE seq_appointment_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 3001
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_appointment_status_id
CREATE SEQUENCE seq_appointment_status_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 4001
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_doctor_availability
CREATE SEQUENCE seq_doctor_availability
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 6001
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_doctor_id
CREATE SEQUENCE seq_doctor_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1001
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_doctor_response
CREATE SEQUENCE seq_doctor_response
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 8001
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_office_id
CREATE SEQUENCE seq_office_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 7001
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_patient_id
CREATE SEQUENCE seq_patient_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 2001
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_patient_review_id
CREATE SEQUENCE seq_patient_review_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 5001
      CACHE 1
      NO CYCLE
;

-- Sequence: seq_user_id
CREATE SEQUENCE seq_user_id
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      CACHE 1
      NO CYCLE
;

-- End of file.

