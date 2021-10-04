package com.techelevator.model;

import java.time.LocalDate;

public class Reviews {

    private long patientId;
    private long officeId;
    private int reviewRating;
    private LocalDate reviewDate;
    private long patientReviewId;
    private String review;


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

    public int getReviewRating() {
        return reviewRating;
    }
    public void setReviewRating(int reviewRating) {
        this.reviewRating = reviewRating;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }
    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public long getPatientReviewId() {
        return patientReviewId;
    }
    public void setPatientReviewId(int patientReviewId) {
        this.patientReviewId = patientReviewId;
    }

    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }

}
