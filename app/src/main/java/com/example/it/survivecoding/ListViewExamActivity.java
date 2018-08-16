package com.example.it.survivecoding;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListViewExamActivity extends AppCompatActivity implements View.OnClickListener {

    private List<Integer> mData;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_exam);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);

        mData = new ArrayList<>();

            for (int i = 0; i < 100; i++) {
                mData.add(i);
            }

        mAdapter = new MyAdapter(mData);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View view) {
        //데이터 뒤집기
        Collections.reverse(mData);
        mAdapter.notifyDataSetChanged();
    }

    private static class MyAdapter extends BaseAdapter {

        private final List<Integer> mData;

        public MyAdapter(List<Integer> data) {
            mData = data;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public Object getItem(int i) {
            return mData.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;

            //레이아웃
            if (view == null) {
                viewHolder = new ViewHolder();
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_text, viewGroup, false);

                viewHolder.textView = view.findViewById(R.id.text_text);

                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            //데이터 표시
            int data = mData.get(i);
            viewHolder.textView.setText("" + data);
            return view;
        }

        private static class ViewHolder {
            TextView textView;
        }
    }
}
