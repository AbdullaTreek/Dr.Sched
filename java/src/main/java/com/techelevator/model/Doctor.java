package com.techelevator.model;

import java.time.LocalDate;

public class Doctor {

    private long userId;
    private long accountId;
    private String firstName;
    private String lastName;
    private String userType;
    private String summary;

    private String accountUserType;
    //    private String officeName;
    //    private int accountId;

    private LocalDate practicingFrom;
//    private String accountUserType;





// Getter and Setter
    public long getUserId() {
        return userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }


    public String getAccountUserType() {
        return accountUserType;
    }
    public void setAccountUserType(String accountUserType) {
        this.accountUserType = accountUserType;
    }



    //    public String getOfficeName() {
//        return officeName;
//    }
//    public void setOfficeName(String officeName) {
//        this.officeName = officeName;
//    }


//    public int getAccountId() {
//        return accountId;

    public LocalDate getPracticingFrom() {
        return practicingFrom;
    }
    public void setPracticingFrom(LocalDate practicingFrom) {
        this.practicingFrom = practicingFrom;
    }


//    public String getAccountUserType() {
//        return accountUserType;

//    }
//    public void setAccountUserType(String accountUserType) {
//        this.accountUserType = accountUserType;
//    }
}

