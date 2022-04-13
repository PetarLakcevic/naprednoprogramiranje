package com.example.demo.dto;

public class DTOFromTo {
    int min;
    int max;

    public DTOFromTo() {
    }

    public DTOFromTo(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
