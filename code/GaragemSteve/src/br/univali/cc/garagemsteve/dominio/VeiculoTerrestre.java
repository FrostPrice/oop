package br.univali.cc.garagemsteve.dominio;

public abstract class VeiculoTerrestre {
    protected String modelo;
    protected String placa;
    protected String motorista;

    public VeiculoTerrestre(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

    public void setMotorista(String nome) {
        this.motorista = nome;
    }

    public String getPlaca() {
        return placa;
    }

    public String detalhar() {
        return "modelo: " + this.modelo + ", placa: " + this.placa + ", motorista: " + this.motorista;
    }
}
