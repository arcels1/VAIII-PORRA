package com.example.appnovooo.view;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appnovooo.R;

import controller.Controller_pessoa;
import model.Curso;
import model.Pessoa;

public class MainActivity extends AppCompatActivity {
    EditText nome;
    EditText sobrenome;
    int cursoId;
    EditText telefone;
    Button limpar;
    Button finalizar;
    Button salvar;
    Controller_pessoa controller;

    Spinner cursos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickListeners();
        listeners();
        controller= new Controller_pessoa(nome,sobrenome,telefone,cursos);
        controller.iniciar();


    }

    public void listeners(){
        nome =(EditText) findViewById(R.id.primeironome);
        sobrenome =(EditText) findViewById(R.id.sobrenome);
        telefone =(EditText) findViewById(R.id.telefone);
        limpar = findViewById(R.id.limpar);
        finalizar = findViewById(R.id.finalizar);
        salvar = findViewById(R.id.salvar);
        cursos = findViewById(R.id.curso_spinner);
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
                    controller.salve(new Pessoa(nome.getText().toString(),sobrenome.getText().toString(),new Curso(controller.getCursosLista(cursoId), cursoId),telefone.getText().toString()));

                }

            });

        cursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),controller.getCursosLista(i),Toast.LENGTH_LONG).show();
                cursoId = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }



}

