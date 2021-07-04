package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class case3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case3);

    }

    public void openCase3_3(View view) {
        Intent intent = new Intent(case3.this, case3_3.class);
        startActivity(intent);
    }
}