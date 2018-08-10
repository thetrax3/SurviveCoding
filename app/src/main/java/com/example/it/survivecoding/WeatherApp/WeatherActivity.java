package com.example.it.survivecoding.WeatherApp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.adapters.WeatherAdapter;
import com.example.it.survivecoding.models.Weather;

import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private ListView mweatherListView;
    private ListAdapter adapter;
    private WeatherAdapter mAdapter;
    private ArrayList<Weather> weatherList;
    private GridView mGridView;
    private Spinner mSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mweatherListView = findViewById(R.id.weather_list);
        mGridView = findViewById(R.id.grid_view);
        mSpinner = findViewById(R.id.spinner);

        //날씨 데이터
        weatherList = new ArrayList<>();
        weatherList.add(new Weather(R.drawable.sunny, "수원", "27도"));
        weatherList.add(new Weather(R.drawable.rainy, "서울", "25도"));
        weatherList.add(new Weather(R.drawable.cloud, "인천", "28도"));
        weatherList.add(new Weather(R.drawable.sunny, "수원", "27도"));
        weatherList.add(new Weather(R.drawable.rainy, "서울", "25도"));
        weatherList.add(new Weather(R.drawable.cloud, "인천", "28도"));
        weatherList.add(new Weather(R.drawable.sunny, "수원", "27도"));
        weatherList.add(new Weather(R.drawable.rainy, "서울", "25도"));
        weatherList.add(new Weather(R.drawable.cloud, "인천", "28도"));


        //어댑터
        mAdapter = new WeatherAdapter(this, weatherList);

        mweatherListView.setAdapter(mAdapter);
        mGridView.setAdapter(mAdapter);
        mSpinner.setAdapter(mAdapter);

        mweatherListView.setOnItemClickListener(this);
        mweatherListView.setOnItemLongClickListener(this);

        mGridView.setOnItemClickListener(this);
        mGridView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mAdapter.setSelect(i);

        //이터가 변경됨을 알려줌 == 다시 그려라
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        //롱 클릭시 해당 아이템 삭제
        weatherList.remove(i);

        //어댑터에 변경을 통지 == 다시 그려라라
        mAdapter.notifyDataSetChanged();
        return true;
    }
}
