package controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import model.Pessoa;

public class Controller_pessoa {


    EditText nome;
    EditText sobrenome;
    EditText curso;
    EditText telefone;

    Controller_pessoa controller;

    public static final String NOME_PREFERENCES = "pref_listavip";
    Context contexto;
    SharedPreferences listaVIP;
    SharedPreferences.Editor editor;


    public Controller_pessoa(EditText nome,EditText sobrenome, EditText curso, EditText telefone) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.curso = curso;
        this.telefone = telefone;
        this.contexto = nome.getContext();

    }

    //testar inicio
    @SuppressLint("SetTextI18n")
    public void iniciar(){
        listaVIP = contexto.getSharedPreferences(NOME_PREFERENCES,Context.MODE_PRIVATE);
        editor = listaVIP.edit();

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
        if(!error(pessoa)) {
            adicionarPreferencias(pessoa);
            Log.i("MVC CONTROLLER", "Pessoa Salva " + pessoa.toString());
            Toast.makeText(contexto, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
        }
        }

    public void finalize(){
            Toast.makeText(contexto,listaVIP.getString("Primeiro nome","")+" \n"
                    +listaVIP.getString("Sobrenome","")+" \n"
                    +listaVIP.getString("Curso","")+" \n"
                    +listaVIP.getString("Telefone","")+" \n",Toast.LENGTH_SHORT).show();
        }


    public void limpe(){
        nome.setText("");
        sobrenome.setText("");
        curso.setText("");
        telefone.setText("");
        editor.clear();
        editor.commit();

    }

    private void adicionarPreferencias( Pessoa pessoa){
        editor.putString("Primeiro nome", pessoa.getNome());
        editor.putString("Sobrenome", pessoa.getSobrenome());
        editor.putString("Curso", pessoa.getCurso().getNomeCurso());
        editor.putString("Telefone", pessoa.getTelefone());
        editor.commit();



    }

    public boolean error(Pessoa pessoa){
        String nomeTeste = nome.getText().toString().trim();
        String sobrenomeTeste = sobrenome.getText().toString().trim();
        String cursoTeste = curso.getText().toString().trim();
        String telefoneTeste = telefone.getText().toString().trim();

        boolean vazio = false;
        if ( nomeTeste.isEmpty()){
            vazio=true;
            nome.setError("Campo obrigatório");
        } else if (sobrenomeTeste.isEmpty()) {
            vazio=true;
            sobrenome.setError("Campo obrigatório");
        } else if (cursoTeste.isEmpty()) {
            vazio=true;
            curso.setError("Campo obrigatório");
        } else if (telefoneTeste.isEmpty()) {
            vazio=true;
            telefone.setError("Campo obrigatório");
        }
        return vazio;
        //salva
    }


}
