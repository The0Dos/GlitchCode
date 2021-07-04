package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class onboard_ac extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    private SliderAdapter sliderAdapter;
    private TextView mNextBtn, mBackBtn;
    SharedPreferences sp;
    int launch = 0;

    private int mCurrentPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboard_ac);

        mSlideViewPager = (ViewPager) findViewById(R.id.viewPager);

        mDotLayout = (LinearLayout) findViewById(R.id.linearl);

        mNextBtn = (TextView) findViewById(R.id.nextBtn);
        mBackBtn = (TextView) findViewById(R.id.prevBtn);


        sliderAdapter = new SliderAdapter(this);
        mSlideViewPager.setAdapter(sliderAdapter);
        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage + 1);

            }
        });
        mBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSlideViewPager.setCurrentItem(mCurrentPage - 1);

            }
        });




    }

    public void addDotsIndicator(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for(int i = 0; i<mDots.length; i++){
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));

            mDots[i].setTextSize(35);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            mDotLayout.addView(mDots[i]);


        }

        if(mDots.length>0){
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));



        }

    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

            addDotsIndicator(position);
            mCurrentPage = position;
            if(position == 0){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("");
            }else if(position == mDots.length - 1){
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mNextBtn.setVisibility(View.VISIBLE);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Finish");
                mBackBtn.setText("Back");

                    mNextBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            if (mNextBtn.getText().toString().equals("Finish")){
                                Intent intent = new Intent(onboard_ac.this, pred_story.class );
                                startActivity(intent);
                                finish();
                                sp = getSharedPreferences("Launch1", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sp.edit();
                                editor.putInt("Launch", 1);
                                editor.commit();

                            }

                        }
                    });





            }else{
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };



}