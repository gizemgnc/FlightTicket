package com.example.flight.models;

public class Cabin {
    private String cabinName;
    private double price;
    private boolean icChecked;
    private int index ;


    public Cabin(String cabinName, double price, boolean icChecked, int index ) {
        this.cabinName = cabinName;
        this.price = price;
        this.icChecked = icChecked;
        this.index = index;

    }

    public String getCabinName() {
        return cabinName;
    }

    public void setCabinName(String cabinName) {
        this.cabinName = cabinName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIcChecked() {
        return icChecked;
    }

    public void setIcChecked(boolean icChecked) {
        this.icChecked = icChecked;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

}
