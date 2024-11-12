package com.example.appnovooo.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appnovooo.R;

import controller.Controller_pessoa;

public class MainActivity extends AppCompatActivity {
    EditText nome;
    EditText sobrenome;
    EditText curso;
    EditText telefone;
    Button limpar;
    Button finalizar;
    Button salvar;
    Context contexto;
    Controller_pessoa controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller= new Controller_pessoa();
        listeners();
        onClickListeners();




        //inicio setar

        controller.iniciar(nome,sobrenome,curso,telefone,contexto);




    }


public void onClickListeners(){
       limpar.setOnClickListener(Controller_pessoa.limpe(nome,sobrenome,curso,telefone));
       finalizar.setOnClickListener(evt -> controller.finalize(contexto));
       salvar.setOnClickListener(evt -> controller.salve(nome,sobrenome,curso,telefone,contexto));
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


}

