package br.univali.cc.garagemsteve.dominio;

public class Carro extends VeiculoTerrestre implements Veiculo {
    private double potencia;

    public Carro(double potencia, String modelo, String placa) {
        super(modelo, placa);
        this.potencia = potencia;
    }

    public double getPotencia() {
        return potencia;
    }

    @Override
    public String obterDescricaoVeiculo() {
        return "Carro -> " + super.detalhar() + ", potencia: " + this.potencia;
    }
}
