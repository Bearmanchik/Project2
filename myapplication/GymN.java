package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.Gym;
import com.example.myapplication.GymAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;

public class GymN extends AppCompatActivity {

    RecyclerView recyclerView;
    TextView txt;
    Button bPlus;
    Button bMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.probnik);



        txt = findViewById(R.id.txt);
        bPlus = findViewById(R.id.bPlus);
        bMine = findViewById(R.id.bMine);
        recyclerView = findViewById(R.id.recycler_view);

        txt.setText("Тренировка ног");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final  ArrayList<Gym> gyms = new ArrayList<Gym>();


        gyms.add(new Gym("Присяд со штангой на плечах", 50, 10));

        gyms.add(new Gym("Жим ногами лёжа ", 70, 12));

        gyms.add(new Gym("Выпады с весом", 15, 15));

        gyms.add(new Gym("Подъём на носки стоя", 40, 12));

        gyms.add(new Gym("Сгибание ног в тренажере", 30, 15));

        gyms.add(new Gym("Разгибание ног в тренажере", 30, 12));


        final GymAdapter gymAdapter = new GymAdapter(gyms);

        recyclerView.setAdapter(gymAdapter);

        View.OnClickListener touch = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.bPlus:
                        gyms.add(new Gym("Тренировка", 0, 0));
                        recyclerView.setAdapter(gymAdapter);
                        break;

                    case R.id.bMine:
                        int count;
                        count = gyms.size();
                        gyms.remove(count - 1);
                        recyclerView.setAdapter(gymAdapter);
                        break;

                }
            }

        };

        bPlus.setOnClickListener(touch);
        bMine.setOnClickListener(touch);






    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gymn_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();



        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.gym_p:
                Intent intent_p = new Intent(GymN.this, GymP.class);
                startActivity(intent_p);
                return true;
            case R.id.gym_s:
                Intent intent_s = new Intent(GymN.this, GymS.class);
                startActivity(intent_s);
                return true;
            case R.id.gym_g:
                Intent intent_g = new Intent(GymN.this, GymG.class);
                startActivity(intent_g);
                return true;
            case R.id.gym_r:
                Intent intent_r = new Intent(GymN.this, GymR.class);
                startActivity(intent_r);
                return true;
            case R.id.quote:
                Intent intent2 = new Intent(GymN.this, QuoteM.class);
                startActivity(intent2);
                return true;
            case R.id.photo:
                Intent intent3 = new Intent(GymN.this, Photo.class);
                startActivity(intent3);
                return true;
            case R.id.menu:
                Intent intentM = new Intent(GymN.this, MainActivity.class);
                startActivity(intentM);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
