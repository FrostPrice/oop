package br.univali.cc.formas.dominio;

public class Linha extends FormaGeometrica {
    public Ponto[] pontos = new Ponto[2];

    public Linha(Ponto ponto1, Ponto ponto2) {
        this.pontos[0] = ponto1;
        this.pontos[1] = ponto2;
    }

    public double tamanhoLinha() {
        return this.pontos[0].distanciaAte(this.pontos[1]);
    }
}
