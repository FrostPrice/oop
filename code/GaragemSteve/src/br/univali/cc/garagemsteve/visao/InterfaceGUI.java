package br.univali.cc.garagemsteve.visao;

import javax.swing.JOptionPane;

import br.univali.cc.garagemsteve.dominio.Caminhao;
import br.univali.cc.garagemsteve.dominio.Carro;
import br.univali.cc.garagemsteve.dominio.Galpao;
import br.univali.cc.garagemsteve.dominio.Helicoptero;
import br.univali.cc.garagemsteve.dominio.Iate;
import br.univali.cc.garagemsteve.dominio.Veiculo;
import br.univali.cc.garagemsteve.dominio.VeiculoTerrestre;

public class InterfaceGUI {
    Galpao galpao;

    public InterfaceGUI(Galpao galpao) {
        this.galpao = galpao;
    }

    public String lerValor(String rotulo) {
        return JOptionPane
                .showInputDialog(null, rotulo);
    }

    public Object lerValor(String rotulo, Object[] opcoes) {
        return JOptionPane
                .showInputDialog(
                        null,
                        null,
                        rotulo,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opcoes,
                        null);
    }

    public void escreverValor(String valor) {
        JOptionPane
                .showMessageDialog(
                        null,
                        valor);
    }

    public void menuPrincipal() {
        char opcao;
        boolean executando = true;
        do {
            String[] opcoes = {
                    "1 - Adicionar Veiculo",
                    "2 - Listar Veiculos",
                    "3 - Sair"
            };
            String valorSelecionado = (String) this.lerValor(
                    "Selecione uma opcao",
                    opcoes);
            if (valorSelecionado == null) {
                break;
            }

            opcao = valorSelecionado
                    .toUpperCase()
                    .charAt(0);

            switch (opcao) {
                case '1':
                    adicionarVeiculo();
                    break;
                case '2':
                    listaVeiculos();
                    break;
                case '3':
                    executando = false;
                    break;
            }
        } while (executando);
    }

    private void adicionarVeiculo() {
        String[] opcoes = {
                "1 - Adicionar Carro",
                "2 - Adicionar Caminhao",
                "3 - Adicionar Helicoptero",
                "4 - Adicionar Iate"
        };
        String valorSelecionado = (String) this.lerValor(
                "Selecione uma opcao",
                opcoes);
        if (valorSelecionado == null)
            return;

        char opcao;
        opcao = valorSelecionado
                .toUpperCase()
                .charAt(0);

        Veiculo veiculo = null;
        switch (opcao) {
            case '1':
                veiculo = this.adicionaCarro();
                break;
            case '2':
                veiculo = this.adicionaCaminhao();
                break;
            case '3':
                veiculo = this.adicionaHelicoptero();
                break;
            case '4':
                veiculo = this.adicionaIate();
                break;
        }

        galpao.adicionarVeiculo(veiculo);
    }

    private void listaVeiculos() {
        String textoVeiculos = this.galpao.imprimirRelacaoVeiculos();

        if (textoVeiculos.equals("")) {
            escreverValor("Nenhum veiculo cadastrado");
            return;
        }

        escreverValor(textoVeiculos);
    }

    private Veiculo adicionaCarro() {
        double potencia = Double.parseDouble(lerValor("Informa a potencia (Somente números)"));
        String modelo = lerValor("Informe o modelo");
        String placa = lerValor("Informe a placa");

        VeiculoTerrestre carro = new Carro(potencia, modelo, placa);

        String motorista = lerValor("Informe o motorista");
        carro.setMotorista(motorista);

        return (Veiculo) carro;
    }

    private Veiculo adicionaCaminhao() {
        double capacidade = Double.parseDouble(lerValor("Informe a capacidade (Somente números)"));
        String modelo = lerValor("Informe o modelo");
        String placa = lerValor("Informe a placa");

        VeiculoTerrestre caminhao = new Caminhao(capacidade, modelo, placa);

        String motorista = lerValor("Informe o motorista");
        caminhao.setMotorista(motorista);

        return (Veiculo) caminhao;
    }

    private Veiculo adicionaHelicoptero() {
        String modeloHelicoptero = lerValor("Informe o modelo");
        String siglaHelicoptero = lerValor("Informe a sigla");

        Helicoptero helicoptero = new Helicoptero(modeloHelicoptero, siglaHelicoptero);

        String piloto = lerValor("Informe o piloto");
        helicoptero.setPiloto(piloto);

        return helicoptero;
    }

    private Veiculo adicionaIate() {
        String nome = lerValor("Informe o nome");

        Iate iate = new Iate(nome);

        String capitao = lerValor("Informe o capitao");
        iate.setCapitao(capitao);

        return iate;
    }
}
