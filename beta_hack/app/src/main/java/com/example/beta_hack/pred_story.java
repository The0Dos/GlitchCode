package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class pred_story extends AppCompatActivity {
    int count = 1;
    ImageView im;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pred_story);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        im = (ImageView) findViewById(R.id.iv1);
        ViewDialog alert = new ViewDialog();
        alert.showDialogRight(pred_story.this, "Нажмите на экран, для просмотра предистории!");
        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pred2();
            }
        });
    }

    public void pred2() {

        if(count == 1){
            im.setImageResource(R.drawable.nuar);
        }else if(count == 2){
            im.setImageResource(R.drawable.story1);
        }else if (count == 3){
            im.setImageResource(R.drawable.draka);
        }else if(count == 4){
            Intent intent = new Intent(pred_story.this, ac_fr.class);
            startActivity(intent);
        }
        count++;



    }
}