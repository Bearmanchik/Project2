package com.example.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class QuoteG extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;

    Button btnM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quoteg);

        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);

        btnM = findViewById(R.id.btnM);

        textView1.setText("Подтянутая женщина всегда добивается того, о чем женщина в халате может только мечтать");
        textView2.setText("Тому, кто спит, не достается ничего, кроме грез");
        textView3.setText("Возможность преодолеть себя — без сомнений, самое ценное свойство спорта");
        textView4.setText("Менйся! Всем назло - себе на пользу!");
        textView5.setText("Каждое утро - это твой шанс стать лучше");
        textView6.setText("Лучший способо начатьжизнь с чистого лица - это привести себя в порядок!");

        View.OnClickListener touch = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnM:
                        Intent intent1 = new Intent(QuoteG.this, QuoteM.class);
                        startActivity(intent1);
                        break;
                }
            }

        };

        btnM.setOnClickListener(touch);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.quote_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();



        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.gym:
                Intent intent = new Intent(QuoteG.this, GymR.class);
                startActivity(intent);
                return true;
            case R.id.photo:
                Intent intent3 = new Intent(QuoteG.this, Photo.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
