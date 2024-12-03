package com.example.appnovooo.view;


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

import androidx.appcompat.app.AppCompatActivity;

import com.example.appnovooo.R;

import controller.Controller_curso;
import controller.Controller_pessoa;
import model.Curso;
import model.Pessoa;

public class MainActivity extends AppCompatActivity {

    EditText nome;
    EditText sobrenome;
    int cursoId =0;
    EditText telefone;
    Button limpar;
    Button finalizar;
    Button salvar;
    Controller_pessoa controller;
    Controller_curso controller_curso;
    Spinner cursos;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);


        controller_curso = new Controller_curso();
        controller_curso.setCursosLista();

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
        adapter = new ArrayAdapter<String>(salvar.getContext(), android.R.layout.simple_list_item_1,controller_curso.getCursosLista());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cursos.setAdapter(adapter);
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
                controller.salve(new Pessoa(nome.getText().toString(),sobrenome.getText().toString(),new Curso(controller_curso.getCursobyId(cursoId)),telefone.getText().toString()));

            }

        });

        cursos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                cursoId = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    }





