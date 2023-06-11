package br.univali.cc.prog3.campeonato.dominio;

public class Equipe {
    private String nome;
    public Mecanico[] mecanicos = new Mecanico[9999];
    public Carro[] carros = new Carro[2];

    // Constructors
    public Equipe(String nome) {
        this.nome = nome;
    }

    // Getrers
    public String getNome() {
        return nome;
    }

    public Mecanico[] getMecanicos() {
        return mecanicos;
    }

    public Carro[] getCarros() {
        return carros;
    }

    // Methods
    public void adicionarCarro(Carro carro, Piloto piloto) {
        for (int i = 0; i < this.carros.length; i++) {
            if (this.carros[i] == null) {
                this.carros[i] = carro;
                this.carros[i].setPiloto(piloto);
                piloto.setCarro(carro);

                break;
            }
        }
    }

    public void adicionarMecanico(Mecanico mecanico) {
        for (int i = 0; i < this.mecanicos.length; i++) {
            if (this.mecanicos[i] == null) {
                this.mecanicos[i] = mecanico;
                break;
            }
        }
    }
}
