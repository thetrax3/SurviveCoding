package com.example.it.survivecoding.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.it.survivecoding.R;

public class LifeCycleFragment extends Fragment {

    //빈 생성자가 반드시 필요함
    //파라미터를 가질 수 없다(액티비티의 라이프사이클에 맞게 하기 위해)
    public LifeCycleFragment() {
        // Required empty public constructor
    }

    //액티비티에 붙을 때 호출
    @Override
    public void onAttach(Context context) {
        //context: 액티비티
        super.onAttach(context);
    }

    //프래그먼트가 생성될 때
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        //savedInstanceState로 복원 처리 가능
        super.onCreate(savedInstanceState);
    }

    //액티비티의 oncreate()부분과 같음
    //레이아웃 완성
    //위의 attach와 create을 다 구현 가능함
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //savedInstanceState로 복원 처리 가능

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    //액티비티가 실제로 생성된 직후 호출
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //뷰 소멸
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //프레그먼트 소멸
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    //액티비티에서 떨어짐
    @Override
    public void onDetach() {
        super.onDetach();
    }
}
