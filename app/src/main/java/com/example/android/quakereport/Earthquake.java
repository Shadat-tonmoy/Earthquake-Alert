package com.example.android.quakereport;

/**
 * Created by Shadat Tonmoy on 10/25/2017.
 */

public class Earthquake {
    private String magnitude,location,date;
    public Earthquake()
    {
        super();
    }

    public Earthquake(String magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
