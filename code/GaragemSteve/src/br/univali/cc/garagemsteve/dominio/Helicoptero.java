package br.univali.cc.garagemsteve.dominio;

public class Helicoptero implements Veiculo {
    private String modelo;
    private String sigla;
    private String piloto;

    public Helicoptero(String modelo, String sigla) {
        this.modelo = modelo;
        this.sigla = sigla;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

    public String detalhar() {
        return "modelo: " + this.modelo + ", sigla: " + this.sigla + ", piloto: " + this.piloto;
    }

    @Override
    public String obterDescricaoVeiculo() {
        return "Helicoptero -> " + this.detalhar();
    }
}
