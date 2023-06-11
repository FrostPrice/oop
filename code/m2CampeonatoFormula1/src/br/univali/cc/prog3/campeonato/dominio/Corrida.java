package br.univali.cc.prog3.campeonato.dominio;

import java.util.Date;

public class Corrida {
    private Date data;
    public Autodromo autodromo;

    // Constructors
    public Corrida(Date data, Autodromo autodromo) {
        this.data = data;
        this.autodromo = autodromo;
    }

    // Getters
    public Autodromo getAutodromo() {
        return autodromo;
    }

    public Date getData() {
        return data;
    }

}
