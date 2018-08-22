package com.example.it.survivecoding.project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.it.survivecoding.R;

import java.util.ArrayList;
import java.util.List;

public class MainBoardActivity extends AppCompatActivity {


    private List<String> mData;
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_board);

        mData = new ArrayList<String>();

        mAdapter = new MyAdapter(mData);

        ListView listView = findViewById(R.id.board_listview);
        listView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_write:
                startActivity(new Intent(this, WriteBoardActivity.class));
                return true;
            case R.id.action_search:
                //검색 기능 추가
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private static class MyAdapter extends BaseAdapter {

        private final List<String> mData;

        public MyAdapter(List<String> data) {
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
                        .inflate(R.layout.project_borad__read_item, viewGroup, false);

                viewHolder.titleView = view.findViewById(R.id.view_title);
                viewHolder.userNameView = view.findViewById(R.id.view_user_nickname);
                viewHolder.dateView = view.findViewById(R.id.view_write_date);

                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }

            //데이터 표시
            String title = mData.get(i);
            String userName = mData.get(i);
            String date = mData.get(i);
            viewHolder.titleView.setText(title);
            viewHolder.userNameView.setText(userName);
            viewHolder.dateView.setText(date);
            return view;
        }

        private static class ViewHolder {
            TextView titleView;
            TextView userNameView;
            TextView dateView;

        }
    }

}
