package com.example.myapplication;

import android.hardware.Camera;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

import java.io.IOException;

public class Photo extends Activity implements SurfaceHolder.Callback, View.OnClickListener{
    private Button bStop;
    private Button bStart;
    private SurfaceView surView;
    private SurfaceHolder surHolder;

    private Camera camera;
    boolean isCameraPreview = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);

        bStart = findViewById(R.id.bStart);
        bStop = findViewById(R.id.bStop);

        surView = findViewById(R.id.surfaceview);
        surHolder = surView.getHolder();
        surHolder.addCallback(this);
        surHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        bStart.setOnClickListener(this);
        bStop.setOnClickListener(this);

        bStop.setEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.photo_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // получим идентификатор выбранного пункта меню
        int id = item.getItemId();



        // Операции для выбранного пункта меню
        switch (id) {
            case R.id.gym:
                Intent intent = new Intent(Photo.this, GymR.class);
                startActivity(intent);
                return true;
            case R.id.quote:
                Intent intent2 = new Intent(Photo.this, QuoteM.class);
                startActivity(intent2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        if (isCameraPreview){
            camera.stopPreview();
            camera.release();
            isCameraPreview  = false;
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.bStart:
                try {
                    camera = Camera.open();
                    camera.setPreviewDisplay(surHolder);
                    camera.startPreview();
                    isCameraPreview = true;

                    bStart.setEnabled(!isCameraPreview);
                    bStop.setEnabled(isCameraPreview);
                }
                catch (IOException e){
                    Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.bStop:
                camera.stopPreview();
                camera.release();
                isCameraPreview = false;

                bStart.setEnabled(!isCameraPreview);
                bStop.setEnabled(isCameraPreview);
                break;

        }

    }
}
