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

public class GymG extends AppCompatActivity {


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

        txt.setText("Тренировка груди");

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


               final ArrayList<Gym> gyms = new ArrayList<Gym>();

                gyms.add(new Gym("Жим штанги лёжа", 40, 12));

                gyms.add(new Gym("Жим гантелей на гаризонтальной скамье", 11, 10));

                gyms.add(new Gym("Жим штанги лёжа под углом вверх", 40, 12));

                gyms.add(new Gym("Жим в хамере на грудь", 25, 15));

                gyms.add(new Gym("Жим от груди на тренажере сидя", 30, 15));



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
        getMenuInflater().inflate(R.menu.gymg_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();



        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.gym_p:
                Intent intent_p = new Intent(GymG.this, GymP.class);
                startActivity(intent_p);
                return true;
            case R.id.gym_s:
                Intent intent_s = new Intent(GymG.this, GymS.class);
                startActivity(intent_s);
                return true;
            case R.id.gym_r:
                Intent intent_r = new Intent(GymG.this, GymR.class);
                startActivity(intent_r);
                return true;
            case R.id.gym_n:
                Intent intent_n = new Intent(GymG.this, GymN.class);
                startActivity(intent_n);
                return true;
            case R.id.quote:
                Intent intent2 = new Intent(GymG.this, QuoteM.class);
                startActivity(intent2);
                return true;
            case R.id.photo:
                Intent intent3 = new Intent(GymG.this, Photo.class);
                startActivity(intent3);
                return true;
            case R.id.menu:
                Intent intentM = new Intent(GymG.this, MainActivity.class);
                startActivity(intentM);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}