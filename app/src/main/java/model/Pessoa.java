package model;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private Curso curso;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, Curso curso, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.curso = curso;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return
                "Primeiro nome: " + nome + '\'' +
                        ", Sobrenome: " + sobrenome + '\'' +
                        ", Curso: " + curso.getNomeCurso() + '\'' +
                        ", Telefone: " + telefone + '\'' +
                        '}';
    }
}
