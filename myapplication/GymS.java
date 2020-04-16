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

public class GymS extends AppCompatActivity {

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
        txt.setText("Тренировка Спины");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



              final ArrayList<Gym> gyms = new ArrayList<Gym>();

                gyms.add(new Gym("Подтягивания (широкий хват)", 0, 12));

                gyms.add(new Gym("Станвая тяга", 15, 12));

                gyms.add(new Gym("Тяга вертикального блока", 35, 15));

                gyms.add(new Gym("Тяга штанги в наклоне", 25, 12));

                gyms.add(new Gym("Тяга Т-грифа", 20, 10));




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
        getMenuInflater().inflate(R.menu.gyms_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();



        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.gym_p:
                Intent intent_p = new Intent(GymS.this, GymP.class);
                startActivity(intent_p);
                return true;
            case R.id.gym_r:
                Intent intent_r = new Intent(GymS.this, GymR.class);
                startActivity(intent_r);
                return true;
            case R.id.gym_g:
                Intent intent_g = new Intent(GymS.this, GymG.class);
                startActivity(intent_g);
                return true;
            case R.id.gym_n:
                Intent intent_n = new Intent(GymS.this, GymN.class);
                startActivity(intent_n);
                return true;
            case R.id.quote:
                Intent intent2 = new Intent(GymS.this, QuoteM.class);
                startActivity(intent2);
                return true;
            case R.id.photo:
                Intent intent3 = new Intent(GymS.this, Photo.class);
                startActivity(intent3);
                return true;
            case R.id.menu:
                Intent intentM = new Intent(GymS.this, MainActivity.class);
                startActivity(intentM);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
