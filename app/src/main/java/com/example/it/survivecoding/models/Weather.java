package com.example.it.survivecoding.models;

public class Weather {
    private int imageRes;
    private String location;

    public Weather(int imageRes, String location, String temperature) {
        this.imageRes = imageRes;
        this.location = location;
        this.temperature = temperature;
    }

    private String temperature;

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "imageRes=" + imageRes +
                ", location='" + location + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
