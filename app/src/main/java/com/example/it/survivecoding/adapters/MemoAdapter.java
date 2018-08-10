package com.example.it.survivecoding.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.models.Memo;

import java.util.List;

public class MemoAdapter extends BaseAdapter {
    private final List<Memo> mData;

    public MemoAdapter(List<Memo> memoList) {
        mData = memoList;
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        //ConvertView : 재사용되는 뷰

        MemoAdapter.ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new MemoAdapter.ViewHolder();

            //뷰를 새로 만들 때
            convertView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_memo, viewGroup, false);

            //레이아웃 들고오기
            TextView titleTextView = convertView.findViewById(R.id.title_text);
            TextView contentTextView = convertView.findViewById(R.id.content_text);

            //뷰 홀더에 저장
            viewHolder.titleTextView = titleTextView;
            viewHolder.contentTextView = contentTextView;

            convertView.setTag(viewHolder);
        } else {
            //재사용할 때
            viewHolder = (MemoAdapter.ViewHolder) convertView.getTag();
        }

        //데이터
        Memo memo = mData.get(i);

        //화면에 뿌리기
        viewHolder.titleTextView.setText(memo.getTitle());
        viewHolder.contentTextView.setText(memo.getContent());


        return convertView;
    }

    //findViewById로 가져온 View들을 보관
    private static class ViewHolder {
        TextView titleTextView;
        TextView contentTextView;
    }
}
