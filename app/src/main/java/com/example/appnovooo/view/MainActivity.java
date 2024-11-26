package com.example.appnovooo.view;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appnovooo.R;

import controller.Controller_pessoa;
import model.Curso;
import model.Pessoa;

public class MainActivity extends AppCompatActivity {
    EditText nome;
    EditText sobrenome;
    EditText curso;
    EditText telefone;
    Button limpar;
    Button finalizar;
    Button salvar;
    Controller_pessoa controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListeners();
        listeners();
        controller= new Controller_pessoa(nome,sobrenome,curso,telefone);
        controller.iniciar();
    }

    public void listeners(){
        nome =(EditText) findViewById(R.id.primeironome);
        sobrenome =(EditText) findViewById(R.id.sobrenome);
        curso =(EditText) findViewById(R.id.curso);
        telefone =(EditText) findViewById(R.id.telefone);
        limpar = findViewById(R.id.limpar);
        finalizar = findViewById(R.id.finalizar);
        salvar = findViewById(R.id.salvar);
    }

    public void onClickListeners(){
        listeners();
        limpar.setOnClickListener(evt ->controller.limpe());
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.finalize();
                finish();
            }
        });
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    controller.salve(new Pessoa(nome.getText().toString(),sobrenome.getText().toString(),new Curso(curso.getText().toString()),telefone.getText().toString()));

                }

            });

    }



}

