

DROP TABLE doctor CASCADE;
DROP TABLE account CASCADE;
DROP TABLE patient CASCADE;
DROP TABLE office CASCADE;
DROP TABLE patient_review CASCADE;


CREATE TABLE account (
    account_id int  NOT NULL,
    first_name varchar(50)  NOT NULL,
    last_name varchar(50)  NOT NULL,
    email varchar(50)  NOT NULL,
    user_id int  NOT NULL,
    CONSTRAINT user_fk FOREIGN KEY(user_id) REFERENCES users(user_id),
    CONSTRAINT account_pk PRIMARY KEY (account_id)
);

CREATE TABLE doctor (
    doctor_id int  NOT NULL,
    summary varchar(500)  NOT NULL,
    user_type varchar(10)  NOT NULL,
    account_id int NOT NULL,
    CONSTRAINT account_fk FOREIGN KEY(account_id) REFERENCES account(account_id),
    CONSTRAINT doctor_pk PRIMARY KEY (doctor_id)
);

-- Table: patient
CREATE TABLE patient (
    patient_id int  NOT NULL,
    user_type varchar(10)  NOT NULL,
    account_id int NOT NULL,
    CONSTRAINT account_fk FOREIGN KEY(account_id) REFERENCES account(account_id),
    CONSTRAINT patient_pk PRIMARY KEY (patient_id)
); 

-- Table: office
CREATE TABLE office (
    office_id int  NOT NULL,
    doctor_id int,
    street_address varchar(100)  NOT NULL,
    city varchar(100)  NOT NULL,
    state varchar(100)  NOT NULL,
    zip varchar(50)  NOT NULL,
    CONSTRAINT doctor_fk FOREIGN KEY(doctor_id) REFERENCES doctor(doctor_id),
    CONSTRAINT office_pk PRIMARY KEY (office_id)
);

-- Table: patient_review
CREATE TABLE patient_review (
    patient_review_id int  NOT NULL,
    patient_id int  NOT NULL,
    overall_rating int  NOT NULL,
    review varchar(500)  NOT NULL,
    doctor_id int  NOT NULL,
    CONSTRAINT doctor_fk FOREIGN KEY(doctor_id) REFERENCES doctor(doctor_id),
    CONSTRAINT patient_review_pk PRIMARY KEY (patient_review_id)
);

-- Creates Users/Accounts
-- UPDATE HASH TO A KNOWN password!!!!
INSERT INTO users (username,password_hash,role) VALUES ('userJC','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('userAT','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('userAP','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('userYK','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');


INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(1,'James','Caserta','JC@gmail.com',1);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(2,'Abdulla','Treek','AT@gmail.com',2);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(3,'AJ','Page','AP@gmail.com',3);
INSERT INTO account(account_id,first_name,last_name,email,user_id) VALUES(4,'Yousef','Khudair','YK@gmail.com',4);

-- Creates Patients
INSERT INTO patient(patient_id,user_type, account_id) VALUES(1,'patient',1);
INSERT INTO patient(patient_id,user_type, account_id) VALUES(4,'patient',4);

--Creates Doctors
INSERT INTO doctor(doctor_id, summary,user_type, account_id) VALUES(2,'I am a doctor','doctor',2);
INSERT INTO doctor(doctor_id, summary,user_type, account_id) VALUES(3,'I am a doctor','doctor',3);

--Creates Offices
INSERT INTO office(office_id, doctor_id, street_address, city, state, zip) VALUES(1,2, '123 Seaview Ave', 'BK', 'NY', 10301);
INSERT INTO office(office_id, doctor_id, street_address, city, state, zip) VALUES(2,3, '123 Wall St', 'LA', 'CA', 90210);

--Creates Office Review

INSERT INTO patient_review(patient_review_id, patient_id, overall_rating, review, doctor_id) VALUES(1,1,4,'I had a great experience with my doctor and this office!', 2);
INSERT INTO patient_review(patient_review_id, patient_id, overall_rating, review, doctor_id) VALUES(2,4,3,'Clean office and easy parking.', 3);



--SELECT first_name, last_name, summary, practicing_from,consulation_fee,street_address,city,state,county,zip FROM account
--JOIN doctor ON account.account_id = doctor.doctor_id
--JOIN office ON office.office_id = doctor.doctor_id

--INSERT INTO doctor_availability (doctor_avalibility_id, office_doctor_id, day_of_week, start_time, end_time, availability)
--VALUES(1,1,'Monday','0700','1500','A')

--INSERT INTO users(username,password_hash,role)
--VALUES ('patient_test','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER')

--INSERT INTO patient (patient_id,contact_number,city,state,zipcode,user_type)
--VALUES(3,'','','','','')

--SELECT * FROM account
--JOIN patient ON account.account_id = patient.patient_id 

--SELECT * FROM users
--JOIN account ON users.user_id = account.account_id
--JOIN doctor ON doctor.doctor_id = account.account_id

--SELECT * FROM users 
--JOIN account ON users.user_id = account.account_id
--JOIN patient ON patient.patient_id = account.account_id

--SELECT * FROM users
--JOIN account ON users.user_id = account.account_id
--JOIN doctor ON doctor.doctor_id = account.account_id
--JOIN office ON office.office_id = doctor.doctor_id

--INSERT INTO patient_review (patient_review_id,patient_id,overall_rating,review,review_date,office_id)
--VALUES (1,3,5,'doctor Abdulla was very great and careful','2021-09-26',1)

--SELECT * FROM account
--JOIN patient ON account.account_id = patient.patient_id
--JOIN patient_review ON patient_review.patient_id = patient.patient_id

--INSERT INTO doctor_response (doctor_response_id,patient_review_id,response,response_date,office_doctor_id)
--VALUES(1,1,'Thank you so much James so you soon','2021-09-26',1)

--SELECT first_name, last_name, review, response FROM account
--JOIN doctor ON account.account_id = doctor.doctor_id
--JOIN office ON doctor.doctor_id = office.office_id
--JOIN patient_review ON patient_review.office_id = office.office_id
--JOIN doctor_response ON doctor_response.office_doctor_id = office.office_id

--SELECT first_name, last_name, review FROM account
--JOIN patient ON account.account_id = patient.patient_id
--JOIN patient_review ON patient_review.patient_id = patient.patient_id

--SELECT first_name, last_name, response FROM account
--JOIN doctor ON account.account_id = doctor.doctor_id
--JOIN office ON doctor.doctor_id = office.office_id
--JOIN doctor_response ON doctor_response.office_doctor_id = office.office_id