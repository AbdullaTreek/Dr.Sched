package com.techelevator.dao;

import com.techelevator.model.Office;

public interface OfficeDao {

    Office getOfficeInfoByOfficeId(long officeId);

    void updateInfoByOfficeId(Office office);

    void updateInfoByDoctorId(Office office);


}
