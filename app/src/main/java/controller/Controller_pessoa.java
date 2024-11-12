package controller;

import android.content.Context;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import model.Curso;
import model.Pessoa;

public class Controller_pessoa {
    private ArrayList<Pessoa> listaSave = new ArrayList<Pessoa>();


    //testar inicio
    public void iniciar(EditText nome, EditText sobrenome, EditText curso, EditText telefone, Context contexto){
        nome.setText("Vinicius");
        sobrenome.setText("Alves");
        curso.setText("Desenvolvimento de sistemas");
        telefone.setText("99989-7798");
        Log.d("MVC CONTROLLER","Controller iniciado com sucesso");
        int teste=0;
    }

    public void salve(EditText nome, EditText sobrenome, EditText curso, EditText telefone, Context contexto){
            Pessoa pessoa =new Pessoa(nome.getText().toString(),sobrenome.getText().toString(),new Curso(curso.getText().toString()),telefone.getText().toString());
            listaSave.add(pessoa);
            Log.i("MVC CONTROLLER","Pessoa Salva ["+listaSave.size()+"]"+pessoa.toString());
            Toast.makeText(contexto, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
        }

    public void finalize(Context contexto){
        for(int i=0; i< listaSave.size();i++){
            Toast.makeText(contexto, (String)listaSave.get(i).toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void limpe(EditText nome, EditText sobrenome, EditText curso, EditText telefone){
        nome.setText("");
        sobrenome.setText("");
        curso.setText("");
        telefone.setText("");

    }

}
