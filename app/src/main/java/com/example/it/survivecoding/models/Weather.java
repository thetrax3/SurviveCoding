package com.example.it.survivecoding.models;

public class Weather {
    private int imageRes;
    private String weather;
    private String country;
    private String temperature;

    public Weather(int imageRes, String country, String temperature) {
        this.imageRes = imageRes;
        this.country = country;
        this.temperature = temperature;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getLocation() {
        return country;
    }

    public void setLocation(String country) {
        this.country = country;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "imageRes=" + imageRes +
                ", weather='" + weather + '\'' +
                ", country='" + country + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
