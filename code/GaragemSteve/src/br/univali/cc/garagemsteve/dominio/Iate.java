package br.univali.cc.garagemsteve.dominio;

public class Iate implements Veiculo {
    private String nome;
    private String capitao;

    public Iate(String nome) {
        this.nome = nome;
    }

    public void setCapitao(String capitao) {
        this.capitao = capitao;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String obterDescricaoVeiculo() {
        return "Iate -> nome: " + this.nome + ", capitao: " + this.capitao;
    }
}
