package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class case1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case1);
    }

    public void openCase1_1(View view) {
        Intent intent = new Intent(case1.this, case1_1.class);
        startActivity(intent);
    }
}