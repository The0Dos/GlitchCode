package com.example.beta_hack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

public class SliderAdapter extends PagerAdapter {


    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context){
        this.context = context;
    }

    public int[] slide_images = {

            R.drawable.robot_head,
            R.drawable.smartphone,
            R.drawable.puzzle
    };

    public String[] slide_headings = {

        "Компаньон",
        "Отслеживание прогресса",
        "Пазл"
    };

    public String[] slide_desc = {

            "На протяжении обучения вам будет помогать робот, вам точно не будет скучно!",
            "Вы всегда сможете посмотреть на какой уровне ваши знания информационной безопасности!",
            "С каждым пройденным уровнем будет открываться новый элемент улучшения робота!"
    };




    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.im);
        TextView slideHeading = (TextView) view.findViewById(R.id.tv1);
        TextView slideDesc = (TextView) view.findViewById(R.id.tv2);
        slideHeading.setFontFeatureSettings(String.valueOf(R.font.font_main));
        slideDesc.setFontFeatureSettings(String.valueOf(R.font.font_main));

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDesc.setText(slide_desc[position]);

        container.addView(view);



        return  view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);


    }
}
