package br.univali.cc.prog3.banco;

import java.util.Scanner;

public class Sistema {
    Banco banco;

    public Sistema() {
        this.banco = new Banco("Banco do Brasil", 1);
    }

    public String lerValor(String rotulo) {
        System.out.print(rotulo + ": ");
        Scanner leitor = new Scanner(System.in);
        return leitor.nextLine();
    }

    public void caixaEletronico() {
        System.out.println("+----------------------------------------------------+");
        System.out.println("| Bem-vindo ao " + this.banco.getNome() + " - " + this.banco.getNumero());
        System.out.println("+----------------------------------------------------+");

        int opcao;
        do {
            System.out.println("+----------------------------------------------------+");
            System.out.println("| 1 - Criar Conta");
            System.out.println("| 2 - Sacar");
            System.out.println("| 3 - Depositar");
            System.out.println("| 4 - Transferir Entre Contas");
            System.out.println("| 5 - Emitir Extrato");
            System.out.println("| 6 - sair");
            System.out.println("+----------------------------------------------------+");

            opcao = Integer.parseInt(this.lerValor("Digite uma opcao [1-6]"));
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
        System.out.println(banco.emitirExtrato(numeroConta));
    }

}
