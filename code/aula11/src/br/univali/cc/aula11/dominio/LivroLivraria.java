package br.univali.cc.aula11.dominio;

public class LivroLivraria extends Livro {
    private int estoque;
    private double valor;

    public LivroLivraria(String isbn, String nome, Autor autor, int estoque, double valor) {
        super(isbn, nome, autor); // Com Constructor

        this.estoque = estoque;
        this.valor = valor;

        // Se a classe pai nao tiver construct
        // this.autor = autor;
        // this.nome = nome;
        // this.isbn = nome;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.estoque + " " + this.valor;
    }

    @Override
    public String getDescricao() {
        return null;
    }
}
