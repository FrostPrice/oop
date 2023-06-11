package br.univali.cc.formas.dominio;

import java.util.ArrayList;

public class Poligono extends FiguraPlana {
    public ArrayList<Ponto> vertices = new ArrayList<Ponto>(3);

    public Poligono(ArrayList<Ponto> vertices) {
        this.vertices = vertices;
    }

    @Override
    public double calcularArea() {
        return 0.0;
    }

}
