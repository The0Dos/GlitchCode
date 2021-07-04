package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class result2 extends AppCompatActivity {
    TextView result1;
    int right = 0, left = 0, fall = 0, correct = 5;
    ImageView iv;
    SharedPreferences sp, sp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);
        result1 = (TextView) findViewById(R.id.res_tv);
        iv = (ImageView) findViewById(R.id.iv);
        SharedPreferences sp111 = getApplication().getSharedPreferences("count_left11", Context.MODE_PRIVATE);
        left = sp111.getInt("left_counter", -1);
        if(left == 5){
            result1.setText("5 / 5");
            iv.setImageResource(R.drawable.cute);
        }else if(left == 4){
            result1.setText("4 / 5");
            iv.setImageResource(R.drawable.cute);
        }else if(left == 3) {
            result1.setText("3 / 5");
            iv.setImageResource(R.drawable.what);
        }else if(left == 2) {
            result1.setText("2 / 5");
            iv.setImageResource(R.drawable.sad);
        }else if(left == 1) {
            result1.setText("1 / 5");
            iv.setImageResource(R.drawable.sad);
        }else if(left == 0) {
            result1.setText("0 / 5");
            iv.setImageResource(R.drawable.sad);
        }


    }

    public void openPuzzle(View view) {
        Intent intent = new Intent(result2.this, puzzle2.class);
        startActivity(intent);
    }

    public void open3d(View view) {
        Intent intent = new Intent(result2.this, wv2_2.class);
        startActivity(intent);
    }
}