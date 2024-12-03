package com.example.appnovooo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.appnovooo.R;

import controller.Controller_curso;
import controller.Controller_pessoa;
import model.Curso;
import model.Pessoa;

public class SplashScreen extends AppCompatActivity {


    public static final int SPLASHTIME=3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       splashScreenChange();
        

    }

    private void splashScreenChange() {
        final Runnable r = new Runnable() {
            public void run() {
                Intent i = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        };
        final Handler handler = new Handler();
        handler.postDelayed(r,5000);

    }


    ;



}