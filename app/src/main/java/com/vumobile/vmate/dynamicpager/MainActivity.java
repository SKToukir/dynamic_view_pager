package com.vumobile.vmate.dynamicpager;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vumobile.vmate.dynamicpager.utils.MyPagerAdapter;
import com.vumobile.vmate.dynamicpager.utils.VerticalViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> list = new ArrayList<>();
    private VerticalViewPager viewPager;
    private MyPagerAdapter pagerAdapter;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list.add("http://202.164.213.242/VUMate/graphics/videos/636512866154380881Bangla_Comedy_Clips_26.mp4");
        list.add("http://202.164.213.242/VUMate/graphics/videos/636512866557202487a.mp4");
        list.add("http://202.164.213.242/VUMate/graphics/videos/636512875522873970a.mp4");
        list.add("http://202.164.213.242/VUMate/graphics/videos/636512880584863432a.mp4");


        fragmentManager = getSupportFragmentManager();

        viewPager = (VerticalViewPager) findViewById(R.id.list);
        viewPager.setOffscreenPageLimit(0);
        pagerAdapter = new MyPagerAdapter(fragmentManager, list);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
             //   Log.d("FragmentList","scrolled-"+String.valueOf(position));
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("FragmentList","position-"+String.valueOf(position));
                try{
                    fragmentManager.beginTransaction().remove(pagerAdapter.getItem(position-2)).commit();
                    fragmentManager.beginTransaction().remove(pagerAdapter.getItem(position+2)).commit();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("FragmentList","state"+String.valueOf(state));
            }
        });
    }

//    @Override
//    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//        Log.d("FragmentList","scrolled-"+String.valueOf(position));
//    }
//
//    @Override
//    public void onPageSelected(int position) {
//
//        Log.d("FragmentList","position-"+String.valueOf(position));
//    }
//
//    @Override
//    public void onPageScrollStateChanged(int state) {
//        pagerAdapter.getItem(state);
//        Log.d("FragmentList","state"+String.valueOf(state));
//    }
}
