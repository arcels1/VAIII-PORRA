package controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import model.Pessoa;

public class Controller_pessoa {
    private ArrayList<Pessoa> listaSave = new ArrayList<Pessoa>();



    //testar inicio
    @SuppressLint("SetTextI18n")
    public void iniciar(EditText nome, EditText sobrenome, EditText curso, EditText telefone){
        nome.setText("Vinicius");
        sobrenome.setText("Alves");
        curso.setText("Desenvolvimento de sistemas");
        telefone.setText("99989-7798");
        Log.d("MVC CONTROLLER","Controller iniciado com sucesso");
    }

    public void salve(Pessoa pessoa, SharedPreferences.Editor editor,Context contexto) {
            listaSave.add(pessoa);
            adicionarPreferencias(editor,pessoa);
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

    private void adicionarPreferencias(SharedPreferences.Editor editor, Pessoa pessoa){
        editor.putString("Primeiro nome", pessoa.getNome());
        editor.putString("Sobrenome", pessoa.getSobrenome());
        editor.putString("Curso", pessoa.getCurso().getNomeCurso());
        editor.putString("Telefone", pessoa.getTelefone());
        editor.commit();


    }


}
