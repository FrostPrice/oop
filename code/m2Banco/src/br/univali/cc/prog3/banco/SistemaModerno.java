package br.univali.cc.prog3.banco;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class SistemaModerno {
    Banco banco;

    public SistemaModerno() {
        this.banco = new Banco("Banco do Brasil", 1);
    }

    public String lerValor(String rotulo) {
        return JOptionPane.showInputDialog(null, rotulo);
    }

    public String lerValor(String rotulo, String[] opcoes) {
        return (String) JOptionPane.showInputDialog(null, null, rotulo, 0, null, opcoes, null);
    }

    public void escreverValor(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public void caixaEletronico() {
        String titulo = "Bem-vindo ao " + this.banco.getNome() + " - " + this.banco.getNumero();

        int opcao;
        do {
            String[] opcoes = {
                    "1 - Criar Conta",
                    "2 - Sacar",
                    "3 - Depositar",
                    "4 - Transferir Entre Contas",
                    "5 - Emitir Extrato",
                    "6 - sair",
            };

            opcao = Integer.parseInt(this.lerValor("Digite uma opcao [1-6]", opcoes));
            switch (opcao) {
                case 1:
                    criarConta();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    depositar();
                    break;
                case 4:
                    transferir();
                    break;
                case 5:
                    emitirExtrato();
                    break;
            }
        } while (opcao != 6);
    }

    private void criarConta() {
        double saldoInicial = Double.parseDouble(lerValor("Informe o saldo inicial"));

        String isContaEspecial = lerValor("Essa eh uma conta especial? [S ou N]");
        if (isContaEspecial.equals("S")) {
            double limite = Double.parseDouble(lerValor("Informe o limite"));
            banco.criarConta(saldoInicial, limite);
        } else {
            banco.criarConta(saldoInicial);
        }
    }

    private void sacar() {
        int numeroConta = Integer.parseInt(lerValor("Informe o numero da Conta"));
        double valor = Double.parseDouble(lerValor("Informe o valor"));
        banco.sacar(numeroConta, valor);
    }

    private void depositar() {
        int numeroConta = Integer.parseInt(lerValor("Informe o numero da Conta"));
        int valor = Integer.parseInt(lerValor("Informe o valor"));
        banco.depositar(numeroConta, valor);
    }

    private void transferir() {
        int numeroContaOrigem = Integer.parseInt(lerValor("Informe o numero da Conta de Origem"));
        int numeroContaDestino = Integer.parseInt(lerValor("Informe o numero da Conta de Destino"));
        double valor = Double.parseDouble(lerValor("Informe o valor"));
        banco.transferir(numeroContaOrigem, numeroContaDestino, valor);
    }

    private void emitirExtrato() {
        int numeroConta = Integer.parseInt(lerValor("Informe o numero da Conta"));
        this.escreverValor(banco.emitirExtrato(numeroConta));
    }

}
