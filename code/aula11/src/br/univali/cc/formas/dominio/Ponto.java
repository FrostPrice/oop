package br.univali.cc.formas.dominio;

public class Ponto extends FormaGeometrica {
    private final int posX;
    private final int posY;

    public Ponto(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double distanciaAte(Ponto outroPonto) {
        double x = posX - outroPonto.posX;
        double y = posY - outroPonto.posY;

        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

}
