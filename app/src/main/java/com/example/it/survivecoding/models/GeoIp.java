package com.example.it.survivecoding.models;


import android.location.Location;

public class GeoIp {
    private String continent_code;

    private Location location;

    private String type;

    private String country_code;

    private String country_name;

    private String ip;

    private String continent_name;

    private String longitude;

    private String latitude;

    public String getContinent_code() {
        return continent_code;
    }

    public void setContinent_code(String continent_code) {
        this.continent_code = continent_code;
    }

    public Location getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getContinent_name() {
        return continent_name;
    }

    public void setContinent_name(String continent_name) {
        this.continent_name = continent_name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "ClassPojo{" + "\n" +
                "continent_code='" + continent_code + '\'' + "\n" +
                ", location=" + location + "\n" +
                ", type='" + type + '\'' + "\n" +
                ", country_code='" + country_code + '\'' + "\n" +
                ", country_name='" + country_name + '\'' + "\n" +
                ", ip='" + ip + '\'' + "\n" +
                ", continent_name='" + continent_name + '\'' + "\n" +
                ", longitude='" + longitude + '\'' + "\n" +
                ", latitude='" + latitude + '\'' + "\n" +
                '}';
    }
}