package controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import model.Pessoa;

public class Controller_pessoa {
    SharedPreferences.Editor editor;
    Context contexto;
    SharedPreferences listaVIP;

    public Controller_pessoa(SharedPreferences.Editor editor, Context contexto, SharedPreferences listaVIP) {
        this.editor = editor;
        this.contexto = contexto;
        this.listaVIP = listaVIP;
    }

    //testar inicio
    @SuppressLint("SetTextI18n")
    public void iniciar(EditText nome,EditText sobrenome, EditText curso, EditText telefone){
        if(listaVIP.contains("Primeiro nome")){
           nome.setText(listaVIP.getString("Primeiro nome",""));
        }
        if(listaVIP.contains("Sobrenome")){
          sobrenome.setText(listaVIP.getString("Sobrenome",""));
        }
        if(listaVIP.contains("Curso")){
          curso.setText(listaVIP.getString("Curso",""));
        }
        if(listaVIP.contains("Telefone")){
          telefone.setText(listaVIP.getString("Telefone",""));
        }
        Log.d("MVC CONTROLLER","Controller iniciado com sucesso");
    }

    public void salve(Pessoa pessoa) {
            adicionarPreferencias(pessoa);
            Log.i("MVC CONTROLLER","Pessoa Salva "+pessoa.toString());
            Toast.makeText(contexto, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
        }

    public void finalize(){
            Toast.makeText(contexto,listaVIP.getString("Primeiro nome","")+" \n"
                    +listaVIP.getString("Sobrenome","")+" \n"
                    +listaVIP.getString("Curso","")+" \n"
                    +listaVIP.getString("Telefone","")+" \n",Toast.LENGTH_SHORT).show();
        }


    public void limpe(EditText nome, EditText sobrenome, EditText curso, EditText telefone){
        nome.setText("");
        sobrenome.setText("");
        curso.setText("");
        telefone.setText("");

    }

    private void adicionarPreferencias( Pessoa pessoa){
        editor.putString("Primeiro nome", pessoa.getNome());
        editor.putString("Sobrenome", pessoa.getSobrenome());
        editor.putString("Curso", pessoa.getCurso().getNomeCurso());
        editor.putString("Telefone", pessoa.getTelefone());
        editor.commit();


    }


}
