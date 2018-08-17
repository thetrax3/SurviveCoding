package com.example.it.survivecoding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.it.survivecoding.MemoApp.MemoActivity;
import com.example.it.survivecoding.WeatherApp.WeatherActivity;
import com.example.it.survivecoding.admob.AdMobActivity;
import com.example.it.survivecoding.coffeeApp.MainActivity;
import com.example.it.survivecoding.lifecycle.LifeCycleActivity;
import com.example.it.survivecoding.managers.BankActivity;
import com.example.it.survivecoding.selectApp.ListViewItem;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {
    private ArrayList<ListViewItem> listViewItems = new ArrayList<ListViewItem>();
    private ListView mListView;
    private ListViewAdapter adapter;
    private static int i = 0;
    private ArrayList<Intent> intentArraylist = new ArrayList<Intent>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        //adapter생성
        adapter = new ListViewAdapter();

        //리스트뷰 참조 및 어댑터 달기
        mListView = findViewById(R.id.list_view);
        mListView.setAdapter(adapter);

        // 1 번째 아이템 추가.
        addItem("커피앱", "커피 주문하는 앱", MainActivity.class);
        // 2 번째 아이템 추가.
        addItem("날씨앱", "모델클래스를 활용하여 BaseAdapter 연습", WeatherActivity.class);
        addItem("메모장", "연습", MemoActivity.class);
        addItem("은행앱", "연습", BankActivity.class);
        addItem("LifeCycle", "생명주기", LifeCycleActivity.class);
        addItem("Fragment", "ColorFragment", ColorFragmentActivity.class);
        addItem("리스트뷰 연습", "리스트뷰 연습", ListViewExamActivity.class);
        addItem("프래그먼트 연습", "프래그먼트 연습", FragmentExam1Activity.class);
        addItem("애드몹 연습", "애드몹 연습", AdMobActivity.class);
        addItem("프래그먼트 콜백 연습", "프래그먼트 콜백 연습", ImageFragmentActivity.class);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int position, long id) {
                ListViewItem item = (ListViewItem) adapterView.getItemAtPosition(position);

                String title = item.getTitle();
                String context = item.getContext();
                startActivity(intentArraylist.get(position));
            }
        });
        mListView.setOnItemLongClickListener(this);
    }

    public void addItem(String title, String context, Class className) {
        ListViewItem item = new ListViewItem();

        item.setTitle(title);
        item.setContext(context);

        Intent intent = new Intent(this, className);
        listViewItems.add(item);
        intentArraylist.add(intent);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
        listViewItems.remove(i);
        return true;
    }

    public class ListViewAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return listViewItems.size();
        }

        @Override
        public Object getItem(int i) {
            return listViewItems.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            final Context context = viewGroup.getContext();

            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.list_view_item, viewGroup, false);
            }

            TextView titleTextView = view.findViewById(R.id.title);
            TextView contextTextView = view.findViewById(R.id.context);

            // Data Set(listViewItemList)에서 position에 위치한 데이터 참조 획득
            ListViewItem listViewItem = listViewItems.get(i);

            // 아이템 내 각 위젯에 데이터 반영
            titleTextView.setText(listViewItem.getTitle());
            contextTextView.setText(listViewItem.getContext());

            return view;
        }
    }
}
