package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

   Button btnG;
   Button btnQ;
   Button btnP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnG = findViewById(R.id.btnG);
        btnQ = findViewById(R.id.btnQ);
        btnP = findViewById(R.id.btnP);

        View.OnClickListener touch = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnG:
                        Intent intent = new Intent(MainActivity.this, GymR.class);
                        startActivity(intent);
                        break;

                    case R.id.btnQ:
                        Intent intent2 = new Intent(MainActivity.this, QuoteM.class);
                        startActivity(intent2);
                        break;

                    case R.id.btnP:
                        Intent intent3 = new Intent(MainActivity.this, Photo.class);
                        startActivity(intent3);
                        break;

                }
            }

        };

        btnG.setOnClickListener(touch);
        btnQ.setOnClickListener(touch);
        btnP.setOnClickListener(touch);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mane_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();



        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.gym:
                Intent intent = new Intent(MainActivity.this, GymR.class);
                startActivity(intent);
                return true;
            case R.id.quote:
                Intent intent2 = new Intent(MainActivity.this, QuoteM.class);
                startActivity(intent2);
                return true;
            case R.id.photo:
                Intent intent3 = new Intent(MainActivity.this, Photo.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
