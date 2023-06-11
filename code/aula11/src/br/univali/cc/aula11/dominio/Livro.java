package br.univali.cc.aula11.dominio;

public abstract class Livro {
    protected String isbn;
    protected String nome;
    protected Autor autor;

    public Livro(String isbn, String nome, Autor autor) {
        this.isbn = isbn;
        this.nome = nome;
        this.autor = autor;
    }

    @Override
    public String toString() {
        return isbn + " " + nome + " " + autor;
    }

    public abstract String getDescricao();
}
