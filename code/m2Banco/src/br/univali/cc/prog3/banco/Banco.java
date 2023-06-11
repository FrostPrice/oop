package br.univali.cc.prog3.banco;

public class Banco {
    private String nome;
    private int numero;
    private ContaCorrente[] contas;

    // Constructors
    public Banco(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
        this.contas = new ContaCorrente[999];
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    // Methods
    private ContaCorrente localizarConta(int numeroConta) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] != null && contas[i].getNumero() == numeroConta) {
                return contas[i];
            }
        }
        return null;
    }

    public void criarConta(double saldoInicial) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null) {
                contas[i] = new ContaCorrente(i, saldoInicial);
                break;
            }
        }
    }

    public void criarConta(double saldoInicial, double limite) {
        for (int i = 0; i < contas.length; i++) {
            if (contas[i] == null) {
                contas[i] = new ContaCorrente(i, saldoInicial, limite);
                break;
            }
        }
    }

    public void depositar(int numero, double valor) {
        ContaCorrente conta = localizarConta(numero);
        if (conta != null) {
            if (conta.depositar(valor))
                System.out.println("Valor depositado");
            else
                System.out.println("Valor invalido!");
        } else {
            System.out.println("Conta nao encontrada!");
        }
    }

    public void sacar(int numero, double valor) {
        ContaCorrente conta = localizarConta(numero);
        if (conta != null) {
            if (conta.sacar(valor))
                System.out.println("Valor Sacado!");
            else
                System.out.println("Valor invalido!");
        } else {
            System.out.println("Conta nao encontrada!");
        }
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor) {
        ContaCorrente contaOrigem = localizarConta(numeroOrigem);
        ContaCorrente contaDestino = localizarConta(numeroDestino);
        if (contaOrigem != null && contaDestino != null) {
            if (contaOrigem.sacar(valor))
                contaDestino.depositar(valor);
            else
                System.out.println("Valor invalido!");
        } else {
            System.out.println("Conta nao encontrada!");
        }
    }

    public String emitirExtrato(int numero) {
        ContaCorrente conta = localizarConta(numero);
        if (conta == null)
            return "Conta nao encontrada!";

        String extrato = "+----------------------------------------------------+\n";
        extrato += "|\n";
        extrato += "| Extrato da Conta - " + numero + "\n";
        extrato += "| Tipo\tDescricao\tValor (R$)\n";
        extrato += "| " + conta.emitirExtrato();
        extrato += "|\n";
        extrato += "| Saldo Total: R$ " + conta.getSaldo() + "\n";
        extrato += "+----------------------------------------------------+";

        return extrato;
    }

}
