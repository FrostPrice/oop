package br.univali.cc.aula8.dominio;


public class Aluno {
    String nome;
    int matricula;
    Professor orientador;

    /**
     * Cria um aluno
     * @param nome = corresponde ao nome do aluno
     */
    public Aluno(String nome) {
        this.nome = nome;
    }
   
    public Aluno() {
        this.nome = "John Doe";
        this.matricula = 0;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void orientadoPor() {}
}
