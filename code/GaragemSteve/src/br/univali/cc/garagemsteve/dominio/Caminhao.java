package br.univali.cc.garagemsteve.dominio;

public class Caminhao extends VeiculoTerrestre implements Veiculo {
    private double capacidadeCarga;

    public Caminhao(double capacidade, String modelo, String placa) {
        super(modelo, placa);
        this.capacidadeCarga = capacidade;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    @Override
    public String obterDescricaoVeiculo() {
        return "Caminhao -> " + super.detalhar() + ", capacidade de carga: " + this.capacidadeCarga;
    }
}
