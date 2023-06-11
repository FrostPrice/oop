package br.univali.cc.prog3.banco;

public class Movimentacao {
    private String descricao;
    private char tipo;
    private double valor;

    // Constructors
    public Movimentacao(String descricao, char tipo, double valor) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    // Getters
    public String getMovimentacao() {
        return tipo + "\t" + descricao + "\tR$ " + valor + "\n";
    }
}
