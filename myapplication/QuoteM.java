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


public class QuoteM extends AppCompatActivity {

    TextView textView;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;

    Button btnG;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quotem);

        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);

        btnG = findViewById(R.id.btnG);


        textView1.setText("Триумф не дарует настоящей силы, ее формирует борьба. Борьба с сомнениями, страхами, ленью. Борись и не сдавайся и обретешь силу");
        textView2.setText("Пребывание в форме очень важно. Делать что-нибудь хорошо требует энергии, и у тебя гораздо больше энергии, когда ты в форме. Я убежден, что занимаюсь спортом по крайней мере три раза в неделю — обычно это первое, что я делаю, когда я просыпаюсь!");
        textView3.setText("Уделите время самому себе. Тренировки не истощают мой запас энергии. Наоборот, они насыщают меня энергией и заставляют меня снова почувствовать себя юным пареньком");
        textView4.setText("Что мною движет на пути к цели? Моя слабость, которую я не переношу и превращаю в силу, чтобы продолжать борьбу");
        textView5.setText("Если человек встает после падения, это не физика, это характер");
        textView6.setText("Физические упражнения могут заменить множество лекарств, но ни одно лекарство в мире не может заменить физические упражнения");



        View.OnClickListener touch = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.btnG:
                        Intent intent1 = new Intent(QuoteM.this, QuoteG.class);
                        startActivity(intent1);
                        break;

                }
            }

        };

        btnG.setOnClickListener(touch);

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
                Intent intent = new Intent(QuoteM.this, GymR.class);
                startActivity(intent);
                return true;
            case R.id.photo:
                Intent intent3 = new Intent(QuoteM.this, Photo.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
