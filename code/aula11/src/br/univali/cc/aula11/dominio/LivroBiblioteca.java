package br.univali.cc.aula11.dominio;

public class LivroBiblioteca extends Livro {
    private String localizacao;
    private int numeroExemplares;

    public LivroBiblioteca(String isbn, String nome, Autor autor, String localizacao, int numeroExemplares) {
        super(isbn, nome, autor);
        this.localizacao = localizacao;
        this.numeroExemplares = numeroExemplares;
    }

    // @Override
    // public String toString() {
    // return super.toString() + " " + this.localizacao + " " +
    // this.numeroExemplares;
    // }

    @Override
    public String getDescricao() {
        return null;
    }
}
