package controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import model.Pessoa;

public class Controller_pessoa {


    EditText nome;
    EditText sobrenome;

    EditText telefone;
    Spinner cursos;
    Controller_curso controller_curso = new Controller_curso();




    public static final String NOME_PREFERENCES = "pref_listavip";
    private Context contexto;
    private SharedPreferences listaVIP;
    private SharedPreferences.Editor editor;



    //gettes e setters
    public Context getContexto() {
        return contexto;
    }

    public void setContexto(Context contexto) {
        this.contexto = contexto;
    }

    public SharedPreferences getListaVIP() {
        return listaVIP;
    }

    public void setListaVIP(SharedPreferences listaVIP) {
        this.listaVIP = listaVIP;
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public void setEditor(SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    public Controller_pessoa() {
    }

    public Controller_pessoa(EditText nome, EditText sobrenome, EditText telefone, Spinner cursos) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.contexto = nome.getContext();
        this.cursos = cursos;

    }

    //testar inicio
    @SuppressLint({"SetTextI18n", "ResourceType"})
    public void iniciar(){
        listaVIP = contexto.getSharedPreferences(NOME_PREFERENCES,Context.MODE_PRIVATE);
        editor = listaVIP.edit();
        controller_curso.setCursosLista();

        if(listaVIP.contains("Primeiro nome")){
           nome.setText(listaVIP.getString("Primeiro nome",""));
        }
        if(listaVIP.contains("Sobrenome")){
          sobrenome.setText(listaVIP.getString("Sobrenome",""));
        }
        if(listaVIP.contains("Curso")){
            cursos.setSelection(controller_curso.getCursoId(listaVIP.getString("Curso","")));
       }
        if(listaVIP.contains("Telefone")){
          telefone.setText(listaVIP.getString("Telefone",""));
        }
        Log.d("MVC CONTROLLER","Controller iniciado com sucesso");
    }

    public void salve(Pessoa pessoa) {
            adicionarPreferencias(pessoa);
            Log.i("MVC CONTROLLER", "Pessoa Salva " + pessoa.toString());
            Toast.makeText(contexto, "Salvo com sucesso", Toast.LENGTH_SHORT).show();
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
        telefone.setText("");
        cursos.setSelection(0);
        editor.clear();
        editor.commit();

    }

    private void adicionarPreferencias( Pessoa pessoa){
        editor.putString("Primeiro nome", pessoa.getNome());
        editor.putString("Sobrenome", pessoa.getSobrenome());
        editor.putString("Telefone", pessoa.getTelefone());
        editor.putString("Curso", pessoa.getCurso().getNomeCurso());
        editor.commit();



    }



}
