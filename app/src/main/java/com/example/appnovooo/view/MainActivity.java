package com.example.appnovooo.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appnovooo.R;

import model.Curso;
import model.Pessoa;

public class MainActivity extends AppCompatActivity {
    EditText nome;
    EditText sobrenome;
    EditText curso;
    EditText telefone;
    Button limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("vinicius");
        pessoa.setCurso(new Curso("Desenvolvimento de sistemas"));
        pessoa.setSobrenome("alves");
        pessoa.setTelefone("994564-4562");
        listeners();
        evento();
        nome.setText(pessoa.getNome());
        sobrenome.setText(pessoa.getSobrenome());
        curso.setText(pessoa.getCurso().getNomeCurso());
        telefone.setText(pessoa.getTelefone());

//        Pessoa outrapessoa = new Pessoa();
//        outrapessoa.setNome("Carlos");
//        outrapessoa.setCurso(new Curso("Pensador"));
//        outrapessoa.setSobrenome("Roberto");
//        outrapessoa.setTelefone("9148165");
//        Log.i("Pessoas:",pessoa.toString()+outrapessoa.toString());

    int parada = 0;

    }

    @SuppressLint("WrongViewCast")
    public void limpar(){
        nome.setText("Primeiro Nome");
        sobrenome.setText("Sobrenome");
        curso.setText("Nome do Curso Desejado");
        telefone.setText("Telefone de Contato");
    }

    public void listeners(){
        nome =(EditText) findViewById(R.id.primeironome);
        sobrenome =(EditText) findViewById(R.id.sobrenome);
        curso =(EditText) findViewById(R.id.curso);
        telefone =(EditText) findViewById(R.id.telefone);
        limpar = findViewById(R.id.limpar);

    }
    public void evento(){
        limpar.setOnClickListener(evt ->limpar());
    }

}

