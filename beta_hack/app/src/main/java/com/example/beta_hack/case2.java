package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class case2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case2);
    }

    public void openCase2_2(View view) {
        Intent intent = new Intent(case2.this, case2_2.class);
        startActivity(intent);
    }
}