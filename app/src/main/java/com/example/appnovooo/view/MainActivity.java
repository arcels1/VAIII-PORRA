package com.example.appnovooo.view;

import android.content.Context;
import android.content.SharedPreferences;
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
    Context contexto;
    Controller_pessoa controller;
    SharedPreferences listaVIP;

    public static final String NOME_PREFERENCES = "pref_listavip";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        onClickListeners();
        listaVIP = getSharedPreferences(NOME_PREFERENCES,MODE_PRIVATE);
        SharedPreferences.Editor editor = listaVIP.edit();
        listeners();

        contexto = (Context) salvar.getContext();

        controller= new Controller_pessoa(editor,contexto,listaVIP);
        controller.iniciar(nome,sobrenome,curso,telefone);

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
                controller.finalize();
                finish();
            }
        });
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!error()){
                    Pessoa pessoa =new Pessoa(nome.getText().toString(),sobrenome.getText().toString(),new Curso(curso.getText().toString()),telefone.getText().toString());
                    controller.salve(pessoa);

                }

            }
        });

    }



}

