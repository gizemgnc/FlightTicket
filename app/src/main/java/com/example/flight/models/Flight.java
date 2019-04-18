package com.example.flight.models;

import java.util.List;

public class Flight {
    private String departureCity; //kalkış şehri
    private String arrivedCity; //ulaştigi şehir
    private String airway; // havayolu
    private String time;
    private List<Cabin> cabinList;
    private boolean isSelected;

    public Flight(String departureCity, String arrivedCity, String airway, String time ,List<Cabin> cabinList) {
        this.departureCity = departureCity;
        this.arrivedCity = arrivedCity;
        this.airway = airway;
        this.time=time;
        this.cabinList = cabinList;
        isSelected = false;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivedCity() {
        return arrivedCity;
    }

    public void setArrivedCity(String arrivedCity) {
        this.arrivedCity = arrivedCity;
    }

    public String getAirway() {
        return airway;
    }

    public void setAirway(String airway) {
        this.airway = airway;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Cabin> getCabinList() {
        return cabinList;
    }

    public void setCabinList(List<Cabin> cabinList) {
        this.cabinList = cabinList;
    }
}
