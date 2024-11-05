package com.example.appnovooo.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appnovooo.R;

import model.Curso;
import model.Pessoa;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("vinicius");
        pessoa.setCurso(new Curso("Desenvolvimento de sistemas"));
        pessoa.setSobrenome("alves");
        pessoa.setTelefone("994564-4562");

        Pessoa outrapessoa = new Pessoa();
        outrapessoa.setNome("Carlos");
        outrapessoa.setCurso(new Curso("Pensador"));
        outrapessoa.setSobrenome("Roberto");
        outrapessoa.setTelefone("9148165");
        Log.i("Pessoas:",pessoa.toString()+outrapessoa.toString());
asda
    int parada = 0;

    }
}

