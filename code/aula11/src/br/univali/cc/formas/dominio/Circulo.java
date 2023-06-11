package br.univali.cc.formas.dominio;

public class Circulo extends FiguraPlana {
    private Ponto ponto;
    private double raio;

    public Circulo(Ponto ponto, double raio) {
        this.ponto = ponto;
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * (raio * raio);
    }

}
