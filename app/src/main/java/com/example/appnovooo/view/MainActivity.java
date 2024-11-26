package com.example.appnovooo.view;



import android.content.Context;
import android.os.Bundle;
import android.view.View;
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
        onClickListeners();
        controller.iniciar(nome,sobrenome,curso,telefone,contexto);

    }
    public void listeners(){
        nome =(EditText) findViewById(R.id.primeironome);
        sobrenome =(EditText) findViewById(R.id.sobrenome);
        curso =(EditText) findViewById(R.id.curso);
        telefone =(EditText) findViewById(R.id.telefone);
        limpar = findViewById(R.id.limpar);
        finalizar = findViewById(R.id.finalizar);
        salvar = findViewById(R.id.salvar);
        int teste = 0;

    }

    public boolean error(){
        String Testnome = nome.getText().toString();
        String Testsobrenome = sobrenome.getText().toString();
        String Testcurso = curso.getText().toString();
        String Testtelefone = telefone.getText().toString();
        boolean vazio = false;
        if ( Testnome.isEmpty()){
            vazio=true;
            nome.setError("Campo obrigatório");
        } else if (Testsobrenome.isEmpty()) {
            vazio=true;
            sobrenome.setError("Campo obrigatório");
        } else if (Testcurso.isEmpty()) {
            vazio=true;
            curso.setError("Campo obrigatório");
        } else if (Testtelefone.isEmpty()) {
            vazio=true;
            telefone.setError("Campo obrigatório");
        }
        return vazio;
        //salva
    }
    public void onClickListeners(){
        listeners();
        limpar.setOnClickListener(evt ->controller.limpe(nome,sobrenome,curso,telefone));
        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.finalize(contexto);
                finish();
            }
        });
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(error() == false){
                    controller.salve(nome,sobrenome,curso,telefone,contexto);
                }

            }
        });
        contexto = (Context) salvar.getContext();
    }



}

