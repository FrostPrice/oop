package br.univali.cc.prog3.gastos.dominio;

public class FormaPagamento {
    private String descricao;

    public FormaPagamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
