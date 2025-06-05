package com.alpacatours.form;

import org.apache.struts.action.ActionForm;

public class TourForm extends ActionForm {
    private String title;
    private String location;
    private double price;
    private String description;
    private int capacity;
    private int guideId;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getGuideId() { return guideId; }
    public void setGuideId(int guideId) { this.guideId = guideId; }
}
