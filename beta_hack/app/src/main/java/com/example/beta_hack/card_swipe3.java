package com.example.beta_hack;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_swipe3);
        swipeAdapter();
    }
    private void swipeAdapter(){
        flingAdapterView=findViewById(R.id.swipe);

        data=new ArrayList<>();
        data.add("Вам пришло сообщение с незнакмого номера от человека, представившегося вашим сыном, с просьбой перевести сумму денег. Переведете ли вы деньги?");
        data.add("Вам на почту пришло сообщение с ссылкой. Перейдете ли вы по ней?");
        data.add("Стоит ли проверять сайты перед покупкой товаров?");
        data.add("Стоит ли совершать полную предоплату в интернет магазинах?");
        data.add("Вы получили паспорт, поделитесь им в инстраграмме?");

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
                Toast.makeText(card_swipe3.this,"нет",Toast.LENGTH_SHORT).show();
                count_left++;
                if((count_left+count_right)==5){
                    finish();
                }
            }

            @Override
            public void onRightCardExit(Object o) {
                Toast.makeText(card_swipe3.this,"да",Toast.LENGTH_SHORT).show();
                count_right++;
                if((count_left+count_right)==5){
                    finish();
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