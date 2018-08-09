package com.example.it.survivecoding.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.it.survivecoding.R;
import com.example.it.survivecoding.models.Weather;

import java.util.List;

public class WeatherAdapter extends BaseAdapter {
    private List<Weather> mData;
    private Context mContext;
    private String TAG = WeatherAdapter.class.getSimpleName();

    public WeatherAdapter(Context context, List<Weather> data) {
        mData = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    //DB를 쓰지 않는 이상 i(position)과 같음
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        //ConvertView : 재사용되는 뷰

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();

            //뷰를 새로 만들 때
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.item_weather, viewGroup, false);

            //레이아웃 들고오기
            ImageView imageView = convertView.findViewById(R.id.weather_image);
            TextView locationTextView = convertView.findViewById(R.id.location_text);
            TextView temperatureTextView = convertView.findViewById(R.id.temperature_text);

            //뷰 홀더에 저장
            viewHolder.weatherImage = imageView;
            viewHolder.locationTextView = locationTextView;
            viewHolder.temperatureTextView = temperatureTextView;

            convertView.setTag(viewHolder);
        } else {
            //재사용할 때
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Log.d(TAG, "getView: " + i);
        //데이터
        Weather weather = mData.get(i);

        //화면에 뿌리기
        viewHolder.weatherImage.setImageResource(weather.getImageRes());
        viewHolder.locationTextView.setText(weather.getLocation());
        viewHolder.temperatureTextView.setText(weather.getTemperature());

        //홀수 줄은 빨간 색
        if (i % 2 == 1) {
            convertView.setBackgroundColor(Color.RED);
        } else convertView.setBackgroundColor(Color.WHITE);

        //클릭 된 아이템은 노란색
        if (mSelPosition == i) {
            convertView.setBackgroundColor(Color.YELLOW);
        }

        return convertView;
    }

    //-1이면 선택된게 없다고 정의
    private int mSelPosition = -1;

    public void setSelect(int position) {
        mSelPosition = position;
    }

    //findViewById로 가져온 View들을 보관
    private static class ViewHolder {
        ImageView weatherImage;
        TextView locationTextView;
        TextView temperatureTextView;
    }
}

