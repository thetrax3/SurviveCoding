package com.example.it.survivecoding;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.it.survivecoding.fragments.ColorFragment;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
    }

    private static class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        //FragmentPagerAdapter는 페이지 수가 적고 고정되어 있을 때 최적적
        //FragmentStatePagerAdpater 페이지 수가 정해져 있지 않고 메모리를 최적화 할 때(이미지, 사진 사용시)

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return ColorFragment.newInstance(Color.RED);
                case 1:
                    return ColorFragment.newInstance(Color.BLUE);
                case 2:
                    return ColorFragment.newInstance(Color.YELLOW);
                case 3:
                    return ColorFragment.newInstance(Color.CYAN);
                case 4:
                    return ColorFragment.newInstance(Color.MAGENTA);
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }
}
