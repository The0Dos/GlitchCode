package com.example.beta_hack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ac_fr extends AppCompatActivity {
    Boolean f = false, s = false, t = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_fr);

        BottomNavigationView btnNav = findViewById(R.id.bottomNavigationview);
        btnNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, new HomeFragment()).commit();




    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case  R.id.item1:
                    selectedFragment = new HomeFragment();
                    if(!f){
                        ViewDialog alert = new ViewDialog();
                        alert.showDialogFragments(ac_fr.this, "Здесь ты сможешь выбрать интересующий тебя уровень!");
                        f = true;

                    }

                    break;
                case R.id.item2:
                    selectedFragment = new ProgressFragment();
                    if(!s){
                        ViewDialog alert1 = new ViewDialog();
                        alert1.showDialogFragments(ac_fr.this, "Здесь ты сможешь посмотреть текущий прогресс!");
                        s = true;
                    }

                    break;
                case R.id.item3:
                    selectedFragment = new SettingsFragment();
                    if(!t){
                        ViewDialog alert2 = new ViewDialog();
                        alert2.showDialogFragments(ac_fr.this, "Здесь ты сможешь изменить настройки!");
                        t = true;
                    }

                    break;
            }

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_layout
                    ,selectedFragment).commit();

            return true;
        }
    };
}