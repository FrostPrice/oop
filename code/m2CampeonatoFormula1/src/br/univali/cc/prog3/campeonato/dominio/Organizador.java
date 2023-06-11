package br.univali.cc.prog3.campeonato.dominio;

import java.util.Date;

public class Organizador {
    private String nome;
    private Campeonato[] campeonato = new Campeonato[9999];

    public Organizador(String nome) {
        this.nome = nome;
    }

    // Getters
    public Campeonato[] getCampeonato() {
        return campeonato;
    }

    public void adicionarCorrida(Autodromo autodromo, Date data, int campeonato) {
        Campeonato campeonatoSelecionado = this.campeonato[campeonato];
        if (campeonatoSelecionado != null)
            campeonatoSelecionado.definirCorrida(autodromo, data);
    }

    public int criarCampeonato(int ano, String nome) {
        for (int i = 0; i < this.campeonato.length; i++) {
            if (this.campeonato[i] == null) {
                Campeonato campeonato = new Campeonato(ano, nome);
                this.campeonato[i] = campeonato;

                return i;
            }
        }

        return -1; // Valor de erro, caso nao consiga inserir um campeonato
    }

    public boolean inscrever(Equipe equipe, int campeonato) {
        Campeonato campeonatoSelecionado = this.campeonato[campeonato];

        if (campeonatoSelecionado != null) {
            for (int i = 0; i < campeonatoSelecionado.equipes.length; i++) {
                if (campeonatoSelecionado.equipes[i] == null) {
                    campeonatoSelecionado.adicionarEquipe(equipe);
                    return true;
                }
            }
        }

        return false;
    }
}
