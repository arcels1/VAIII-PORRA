package com.example.appnovooo.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appnovooo.R;

import java.util.ArrayList;

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
    ArrayList<Pessoa> listaSave = new ArrayList<Pessoa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listeners();

        //inicio setar

        nome.setText("Vinicius");
        sobrenome.setText("Alves");
        curso.setText("Desenvolvimento de sistemas");
        telefone.setText("99989-7798");


//button
        limpar.setOnClickListener(evt ->limpar());
        finalizar.setOnClickListener(evt ->finalizar());
        salvar.setOnClickListener(evt ->salvar());
//variavel


        //finalizar


//        Pessoa outrapessoa = new Pessoa();
//        outrapessoa.setNome("Carlos");
//        outrapessoa.setCurso(new Curso("Pensador"));
//        outrapessoa.setSobrenome("Roberto");
//        outrapessoa.setTelefone("9148165");
//        Log.i("Pessoas:",pessoa.toString()+outrapessoa.toString());



    }

    public void salvar(){
        //detecta erro
        boolean vazio = false;
        if (nome.toString().isEmpty()){
            vazio=true;
            nome.setError("Campo obrigatório");
        } else if (sobrenome.toString().isEmpty()) {
            vazio=true;
            sobrenome.setError("Campo obrigatório");
        } else if (curso.toString().isEmpty()) {
            vazio=true;
            curso.setError("Campo obrigatório");
        } else if (telefone.toString().isEmpty()) {
            vazio=true;
            telefone.setError("Campo obrigatório");
        }
        //salva
        if(vazio==false){
            Pessoa pessoa =new Pessoa(nome.getText().toString(),sobrenome.getText().toString(),new Curso(curso.getText().toString()),telefone.getText().toString());
            listaSave.add(pessoa);
            Log.i("Pessoa Salva ["+listaSave.size()+"]",pessoa.toString());
            Toast.makeText(getBaseContext(),"Salvo com sucesso", Toast.LENGTH_SHORT).show();
        }

    }

    public void finalizar(){
        for(int i=0; i< listaSave.size();i++){
            Toast.makeText(getBaseContext(), (String)listaSave.get(i).toString(), Toast.LENGTH_SHORT).show();

        }
        finish();


    }

    @SuppressLint("WrongViewCast")
    public void limpar(){
        nome.setText("");
        sobrenome.setText("");
        curso.setText("");
        telefone.setText("");
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

