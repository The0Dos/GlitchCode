package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class level1_1 extends AppCompatActivity {
    TextView yes, no, threed;
    int y, n;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1_1);
        yes = (TextView) findViewById(R.id.yes1_1);
        no = (TextView) findViewById(R.id.no1_1);
        sp = getApplication().getSharedPreferences("level_1_1", Context.MODE_PRIVATE);

        if(sp.getInt("yess", -1) == 1 &&sp.getInt("nooo", -1) == 0 ){
            yes.setTextColor(Color.parseColor("#23CB10"));
            yes.setBackgroundDrawable( getResources().getDrawable(R.drawable.choice_btn_right));
            threed = (TextView) findViewById(R.id.threed);
            threed.setVisibility(View.VISIBLE);
            no.setClickable(false);

        }else if(sp.getInt("nooo", -1) == 1 &&sp.getInt("yess", -1) == 0 ){
            no.setTextColor(Color.parseColor("#C41111"));
            no.setBackgroundDrawable(getResources().getDrawable(R.drawable.choice_btn_false));
            yes.setClickable(false);
        }

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(y == 0 && n==0){
                    yes.setTextColor(Color.parseColor("#23CB10"));
                    yes.setBackgroundDrawable( getResources().getDrawable(R.drawable.choice_btn_right));
                    ViewDialog alert = new ViewDialog();
                    alert.showDialogRight(level1_1.this, "Правильно!");
                    threed = (TextView) findViewById(R.id.threed);
                    threed.setVisibility(View.VISIBLE);
                    y = 1;
                    sp = getSharedPreferences("level_1_1", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("yess", 1);
                    editor.putInt("nooo", 0);
                    no.setTextColor(Color.parseColor("#ffffff"));
                    no.setBackgroundDrawable( getResources().getDrawable(R.drawable.choice_btn));
                    threed = (TextView) findViewById(R.id.threed);
                    threed.setVisibility(View.VISIBLE);
                    editor.commit();
                    no.setClickable(false);


                }

            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(y == 0 && n==0){
                    no.setTextColor(Color.parseColor("#C41111"));
                    no.setBackgroundDrawable(getResources().getDrawable(R.drawable.choice_btn_false));
                    ViewDialog alert = new ViewDialog();
                    alert.showDialog(level1_1.this, "Неправильно!");
                    n = 1;
                    sp = getSharedPreferences("level_1_1", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt("nooo", 1);
                    editor.putInt("yess", 0);
                    yes.setTextColor(Color.parseColor("#ffffff"));
                    yes.setBackgroundDrawable( getResources().getDrawable(R.drawable.choice_btn));
                    threed = (TextView) findViewById(R.id.threed);
                    threed.setVisibility(View.INVISIBLE);
                    editor.commit();
                    yes.setClickable(false);

                }

            }
        });

    }

    public void open3d(View view) {
        Intent intent = new Intent(level1_1.this, wv1_1.class);
        startActivity(intent);

    }


}