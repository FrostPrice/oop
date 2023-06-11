package br.univali.cc.garagemsteve.dominio;

public class Galpao {
    private Veiculo[] veiculos = new Veiculo[999];

    public void adicionarVeiculo(Veiculo veiculo) {
        for (int i = 0; i < this.veiculos.length; i++) {
            if (this.veiculos[i] == null) {
                this.veiculos[i] = veiculo;
                return;
            }
        }
    }

    public String imprimirRelacaoVeiculos() {
        String textoRelacao = "";

        for (Veiculo veiculo : this.veiculos) {
            if (veiculo != null)
                textoRelacao += veiculo.obterDescricaoVeiculo() + "\n";
        }

        return textoRelacao;
    }
}
