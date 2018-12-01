package com.intern.jiraiya.onboarding;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SwipePagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    SwipePagerAdapter(Context context){
        this.context = context;
    }



    private String[] headings = new String[]{
            "Chemistry",
            "Enjoyment",
            "Sunshine"
    };

    private String[] description = new String[]{
            "Chemistry is a big part of your everyday life. You find chemistry in daily life in foods you eat, air you breathe, soap, your emotions and literally every object you can see or touch. Here's a look at some examples of everyday chemistry.",
            "Lighten up, just enjoy life, smile more, laugh more, and don't get so worked up about things.",
            "The Sun is the star at the center of the Solar System. It is a nearly perfect sphere of hot plasma, with internal convective motion that generates a magnetic field via a dynamo process."
    };

    @Override
    public int getCount() {
        return headings.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (ConstraintLayout)o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v= layoutInflater.inflate(R.layout.splash_screen_layout,container,false);
        ImageView imageView = v.findViewById(R.id.imageView);
        TextView heading = v.findViewById(R.id.textView);
        TextView desc = v.findViewById(R.id.textView2);

        if(position == 0){
            Drawable chemical=(AnimatedVectorDrawable)context.getDrawable(R.drawable.chemical_animate);
            imageView.setImageDrawable(chemical);
            if(chemical instanceof Animatable){
                ((Animatable)chemical).start();
            }
        }
        else if(position == 1){
            imageView.setImageResource(R.drawable.second);
        }
        else {
            Drawable sun=(AnimatedVectorDrawable)context.getDrawable(R.drawable.sun_rotate);
            imageView.setImageDrawable(sun);
            if(sun instanceof Animatable){
                ((Animatable)sun).start();
            }
        }

        heading.setText(headings[position]);
        desc.setText(description[position]);
        container.addView(v);

        return  v;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }
}
