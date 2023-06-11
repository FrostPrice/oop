package br.univali.cc.prog3.campeonato.dominio;

public class Piloto {
    private String nome;
    private int licenca;
    private Carro carro;

    public Piloto(String nome, int licenca) {
        this.nome = nome;
        this.licenca = licenca;
    }

    public String getNome() {
        return nome;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }
}
