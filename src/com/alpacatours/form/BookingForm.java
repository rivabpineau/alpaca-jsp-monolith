package com.alpacatours.form;

import org.apache.struts.action.ActionForm;

public class BookingForm extends ActionForm {
    private int tourId;
    private int numPeople;

    public int getTourId() { return tourId; }
    public void setTourId(int tourId) { this.tourId = tourId; }

    public int getNumPeople() { return numPeople; }
    public void setNumPeople(int numPeople) { this.numPeople = numPeople; }
}
