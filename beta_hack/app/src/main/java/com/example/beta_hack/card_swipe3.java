package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;

public class card_swipe3 extends AppCompatActivity {
    private ArrayAdapter<String> arrayAdapter;
    List<String> data;
    SwipeFlingAdapterView flingAdapterView;
    int count_right = 0;
    int count_left = 0;
    int counter = 0;
    int five = 5;
    SharedPreferences sp11, sp1;
    SharedPreferences.Editor editor, editor1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_swipe1);

        swipeAdapter();
    }



    private void swipeAdapter(){
        flingAdapterView=findViewById(R.id.swipe);

        data=new ArrayList<>();
        data.add("С помощью VPN можно менять IP?");
        data.add("Вам на почту пришло сообщение с ссылкой. Перейдете ли вы по ней?");
        data.add("Купите ли вы товар на непроверенном сайте??");
        data.add("С помощью прокси - сервера можно менять IP??");
        data.add("Пакеты данных при смене идут через отдельный сервер??");

        arrayAdapter=new ArrayAdapter<>(card_swipe3.this, R.layout.swipeitem, R.id.data, data);

        flingAdapterView.setAdapter(arrayAdapter);

        flingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                data.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                counter++;


                count_left++;


                if((count_left+count_right)==5){
                    sp11 = getSharedPreferences("count_left111", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp11.edit();
                    editor.putInt("left_counter", count_left);
                    editor.commit();




                    Intent intent  = new Intent(card_swipe3.this, result3.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onRightCardExit(Object o) {
                ViewDialog alert = new ViewDialog();
                counter++;

                count_right++;





                if (counter == 1){
                    alert.showDialog(card_swipe3.this, "Мошенники могут привториться вашими росдтвенниками!");
                    five--;

                }else if (counter == 2){
                    alert.showDialog(card_swipe3.this, "Такие ссылки часто явялются фишинговыми!");
                    five--;
                }else if (counter == 3){
                    alert.showDialog(card_swipe3.this, "Всегда проверяйте товар перед покупкой!");
                    five--;
                }else if(counter == 4){
                    alert.showDialog(card_swipe3.this, "Никогда не предоплачивайте полную цену товара!");
                    five--;
                }else if(counter == 5){
                    alert.showDialog(card_swipe3.this, "Никогда не распространяйте личные данные!");
                    five--;
                }
                if((count_left+count_right)==5){


                    Intent intent  = new Intent(card_swipe3.this, result3.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
            }

            @Override
            public void onScroll(float v) {
            }
        });

        flingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                Toast.makeText(card_swipe3.this, "data is "+data.get(i),Toast.LENGTH_SHORT).show();
            }
        });

        TextView like,dislike;

        like=findViewById(R.id.like);
        dislike=findViewById(R.id.dislike);

        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingAdapterView.getTopCardListener().selectRight();
            }
        });

        dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingAdapterView.getTopCardListener().selectLeft();
            }
        });

    }
}