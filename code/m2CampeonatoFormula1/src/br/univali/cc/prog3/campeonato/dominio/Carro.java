package br.univali.cc.prog3.campeonato.dominio;

public class Carro {
    private int numero;
    private Piloto piloto;

    // Contructors
    public Carro(int numero) {
        this.numero = numero;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    // Setters
    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }
}
