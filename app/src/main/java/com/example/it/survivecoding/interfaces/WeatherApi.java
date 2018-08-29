package com.example.it.survivecoding.interfaces;

import com.example.it.survivecoding.models.Weather;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherApi {

    String BASE_URL = "https://gist.githubusercontent.com/junsuk5/6b293ac781b038366419ac6e4027abb7/raw/afd3f207203d1e84b87f37ffc41809989428f0ec/";

    @GET("weather.json")
    Call<List<Weather>> getWeatherList();
}
