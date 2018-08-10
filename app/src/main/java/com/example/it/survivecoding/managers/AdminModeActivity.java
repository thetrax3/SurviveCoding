package com.example.it.survivecoding.managers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.models.Account;

import java.util.List;

public class AdminModeActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_mode_activity);

        ListView listView = findViewById(R.id.admin_accountInfo);

        Bank bank = Bank.newInstance();

        BankAdapter adapter = new BankAdapter(bank.getAccountList());
        listView.setAdapter(adapter);
    }

    public void onClick(View view) {
        finish();
    }

    private static class BankAdapter extends BaseAdapter {

        private final List<Account> mData;

        public BankAdapter(List<Account> accountList) {
            mData = accountList;
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
            //ConvertView : 재사용되는 뷰

            ViewHolder viewHolder;

            if (view == null) {
                viewHolder = new ViewHolder();

                //뷰를 새로 만들 때
                view = LayoutInflater.from(viewGroup.getContext())
                        .inflate(R.layout.item_account_info, viewGroup, false);

                //레이아웃 들고오기
                TextView idTextView = view.findViewById(R.id.account_title_TextView);
                TextView balanceTextView = view.findViewById(R.id.balance_TextView);

                //뷰 홀더에 저장
                viewHolder.idTextView = idTextView;
                viewHolder.balanceTextView = balanceTextView;

                view.setTag(viewHolder);
            } else {
                //재사용할 때
                viewHolder = (ViewHolder) view.getTag();
            }

            //데이터
            Account account = mData.get(i);

            //화면에 뿌리기
            viewHolder.idTextView.setText(account.getId());
            viewHolder.balanceTextView.setText("" + account.getBalance());


            return view;
        }

        private static class ViewHolder {
            TextView idTextView;
            TextView balanceTextView;
        }
    }
}
