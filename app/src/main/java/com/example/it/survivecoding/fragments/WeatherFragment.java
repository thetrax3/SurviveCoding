package com.example.it.survivecoding.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.adapters.WeatherAdapter;
import com.example.it.survivecoding.models.Weather;

import java.io.Serializable;
import java.util.List;

public class WeatherFragment extends Fragment {

    private List<Weather> mWeatherList;

    public static WeatherFragment newInstance(List<Weather> weatherList) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", (Serializable) weatherList);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.list_view);
        mWeatherList = (List<Weather>) getArguments().getSerializable("data");
        WeatherAdapter adapter = new WeatherAdapter(getActivity(), mWeatherList);

        listView.setAdapter(adapter);
    }
}
