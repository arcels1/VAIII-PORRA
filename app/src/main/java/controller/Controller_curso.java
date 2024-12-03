package controller;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.Curso;

public class Controller_curso {

    private ArrayList<Curso> cursosLista ;

    public void setCursosLista() {
        cursosLista = new ArrayList<Curso>();
        cursosLista.add(new Curso(""));
        cursosLista.add(new Curso("Java"));
        cursosLista.add(new Curso("Python"));
        cursosLista.add(new Curso("C#"));
        cursosLista.add(new Curso("C"));
        cursosLista.add(new Curso("C++"));
        cursosLista.add(new Curso("Kotlin"));
    }

    public Controller_curso() {
    }

    public int getCursoId (String curso){
        int id = 0;
        for (int i=0; i< cursosLista.size();i++){
            if(curso.equals(cursosLista.get(i).getNomeCurso())){
                id = i;
                break;
            }
        }
        return id;
    }

    public String getCursobyId(int i){
       return cursosLista.get(i).getNomeCurso();

    }


    public ArrayList<String> getCursosLista() {
        ArrayList<String> cursoListaNovo = new ArrayList<String>();
        for (int i =0; i < cursosLista.size(); i++){
            cursoListaNovo.add(cursosLista.get(i).getNomeCurso());
        }
        return cursoListaNovo;
    }
}
