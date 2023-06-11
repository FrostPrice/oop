package br.univali.cc.prog3.campeonato.dominio;

import java.util.Date;

public class Campeonato {
    private int ano;
    private String nome;
    public Corrida[] corridas = new Corrida[20];
    public Equipe[] equipes = new Equipe[12];

    public Campeonato(int ano, String nome) {
        this.ano = ano;
        this.nome = nome;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getAno() {
        return ano;
    }

    public void adicionarEquipe(Equipe equipe) {
        for (int i = 0; i < this.equipes.length; i++) {
            if (this.equipes[i] == null) {
                this.equipes[i] = equipe;
                break;
            }
        }
    }

    public void definirCorrida(Autodromo autodromo, Date data) {
        for (int i = 0; i < this.corridas.length; i++) {
            if (this.corridas[i] == null) {
                this.corridas[i] = new Corrida(data, autodromo);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return this.nome + "," + this.ano;
    }
}
