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

    Controller_pessoa controller;

    public static final String NOME_PREFERENCES = "pref_listavip";
    private Context contexto;
    private SharedPreferences listaVIP;
    private SharedPreferences.Editor editor;

    private Spinner cursos;
    private ArrayAdapter<String> adapter;
    private String[] cursosLista = { " ","Desenvolvimento de sistemas","Programação"};

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

    public Spinner getCursos() {
        return cursos;
    }

    public void setCursos(Spinner cursos) {
        this.cursos = cursos;
    }

    public ArrayAdapter<String> getAdapter() {
        return adapter;
    }

    public void setAdapter(ArrayAdapter<String> adapter) {
        this.adapter = adapter;
    }

    public String getCursosLista(int i) {
        return cursosLista[i];
    }

    public void setCursosLista(String[] cursosLista) {
        this.cursosLista = cursosLista;
    }


    public Controller_pessoa(EditText nome,EditText sobrenome, EditText telefone, Spinner cursos) {
        this.cursos = cursos;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.contexto = nome.getContext();

    }

    //testar inicio
    @SuppressLint({"SetTextI18n", "ResourceType"})
    public void iniciar(){
        listaVIP = contexto.getSharedPreferences(NOME_PREFERENCES,Context.MODE_PRIVATE);
        editor = listaVIP.edit();
        adapter = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item, cursosLista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cursos.setAdapter(adapter);

        if(listaVIP.contains("Primeiro nome")){
           nome.setText(listaVIP.getString("Primeiro nome",""));
        }
        if(listaVIP.contains("Sobrenome")){
          sobrenome.setText(listaVIP.getString("Sobrenome",""));
        }
        if(listaVIP.contains("CursoId")){
            cursos.setSelection(listaVIP.getInt("CursoId",0));
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
                    +cursosLista[listaVIP.getInt("CursoId",0)]+" \n"
                    +listaVIP.getString("Telefone","")+" \n",Toast.LENGTH_SHORT).show();
        }


    public void limpe(){
        nome.setText("");
        sobrenome.setText("");
        telefone.setText("");
        cursos.setSelection(1);
        editor.clear();
        editor.commit();

    }

    private void adicionarPreferencias( Pessoa pessoa){
        editor.putString("Primeiro nome", pessoa.getNome());
        editor.putString("Sobrenome", pessoa.getSobrenome());
        editor.putString("Telefone", pessoa.getTelefone());
        editor.putInt("CursoId", pessoa.getCurso().getIdCurso());
        editor.commit();



    }

    public boolean error(Pessoa pessoa){
        String nomeTeste = nome.getText().toString().trim();
        String sobrenomeTeste = sobrenome.getText().toString().trim();
        int cursoTeste = cursos.getSelectedItemPosition();
        String telefoneTeste = telefone.getText().toString().trim();

        boolean vazio = false;
        if ( nomeTeste.isEmpty()){
            vazio=true;
            nome.setError("Campo obrigatório");
        } else if (sobrenomeTeste.isEmpty()) {
            vazio=true;
            sobrenome.setError("Campo obrigatório");
       } else if (cursoTeste== 0) {
           vazio=true;
            Toast.makeText(contexto, "O campo cursos é obrigatório", Toast.LENGTH_SHORT).show();
        } else if (telefoneTeste.isEmpty()) {
            vazio=true;
            telefone.setError("Campo obrigatório");
        }
        return vazio;
        //salva
    }


}
