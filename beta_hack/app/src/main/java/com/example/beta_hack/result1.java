package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class result1 extends AppCompatActivity {
    TextView result1;
    SharedPreferences sp, sp1;
    int right = 0, left = 0;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);


             result1 = (TextView) findViewById(R.id.res_tv);
             iv = (ImageView) findViewById(R.id.iv);


            result1.setText("5 / 5");
            iv.setImageResource(R.drawable.cute);

    }

    public void openPuzzle(View view) {
        Intent intent = new Intent(result1.this, puzzle_ac.class);
        startActivity(intent);
    }

    public void open3d(View view) {
        Intent intent = new Intent(result1.this, wv1_1.class);
        startActivity(intent);
    }
}