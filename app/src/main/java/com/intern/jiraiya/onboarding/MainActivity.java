package com.intern.jiraiya.onboarding;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager swipe_pager;
    private LinearLayout linearLayout;
    private SwipePagerAdapter adapter;

    private TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipe_pager = (ViewPager)findViewById(R.id.view_pager);
        linearLayout = (LinearLayout)findViewById(R.id.ll);
        adapter = new SwipePagerAdapter(MainActivity.this);

        swipe_pager.setAdapter(adapter);
        swipe_pager.addOnPageChangeListener(listener);
        addDots();
    }

    void addDots(){
        dots = new TextView[3];

        for(int i = 0; i< dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            //dots[i].setTextColor(getResources().getColor(R.color.notSelectedWhite));
            dots[i].setTextColor(Color.RED);
            linearLayout.addView(dots[i]);

        }
        dots[0].setTextColor(Color.WHITE);
    }


    ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            changeColor(i);

        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    void changeColor(int i){

        Log.d("MAIN","Page Number "+i);
        for(int j=0;j<3;j++){
            Log.d("MAIN","J= "+j);
            if(j != i) {
                dots[j].setTextColor(Color.RED);
                Log.d("MAIN","Setting Red");
            }
            else {
                dots[j].setTextColor(Color.WHITE);
                Log.d("MAIN","Setting White");
            }

        }
    }


}
