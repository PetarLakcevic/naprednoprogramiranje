package com.example.demo.dto;

public class DTOFilter {
    private String manufacturer;
    private int year;

    public DTOFilter() {
    }

    public DTOFilter(String manufacturer, int year) {
        this.manufacturer = manufacturer;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
