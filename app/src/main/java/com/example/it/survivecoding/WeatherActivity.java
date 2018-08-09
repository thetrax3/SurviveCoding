package com.example.it.survivecoding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.it.survivecoding.adapters.WeatherAdapter;
import com.example.it.survivecoding.models.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView mweatherListView;
    private ListAdapter adapter;
    private WeatherAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mweatherListView = findViewById(R.id.weather_list);

        //날씨 데이터
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(new Weather(R.drawable.sunny, "수원", "27도"));
        weatherList.add(new Weather(R.drawable.rainy, "서울", "25도"));
        weatherList.add(new Weather(R.drawable.cloud, "인천", "28도"));

        //어댑터
        mAdapter = new WeatherAdapter(this, weatherList);

        mweatherListView.setAdapter(mAdapter);

        mweatherListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mAdapter.setSelect(i);

        //데이터가 변경됨을 알려줌 == 다시 그려라
        mAdapter.notifyDataSetChanged();
    }
}
