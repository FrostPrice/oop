package br.univali.cc.prog3.gastos.visao;

import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import br.univali.cc.prog3.gastos.dominio.Aplicacao;
import br.univali.cc.prog3.gastos.dominio.FormaPagamento;
import br.univali.cc.prog3.gastos.dominio.TipoGasto;

public class AplicacaoGUI {
    Aplicacao applicacao;

    public AplicacaoGUI() {
        this.applicacao = new Aplicacao();
    }

    private String lerValor(String rotulo) {
        return JOptionPane.showInputDialog(null, rotulo);
    }

    private String lerValor(String rotulo, String[] opcoes) {
        return (String) JOptionPane.showInputDialog(null, null, rotulo, 0, null, opcoes, null);
    }

    private int lerOpcoes(String rotulo, String[] opcoes) {
        return JOptionPane.showOptionDialog(null, null, "Escolha uma opcao",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, null);
    }

    private void escreverValor(String texto, String titulo) {
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public void menu() {
        char opcao;
        do {
            String[] opcoes = {
                    "1 - Listar Gastos",
                    "2 - Adicionar Gasto",
                    "3 - Obter Formas de Pagamento",
                    "4 - Obter Tipos de Gasto",
                    "5 - sair",
            };

            String opcaoSelecionada = this.lerValor("Digite uma opcao [1-5]", opcoes);
            if (opcaoSelecionada == null) {
                opcao = '5';
            } else {
                opcao = opcaoSelecionada.charAt(0);
            }
            switch (opcao) {
                case '1':
                    listarGastos();
                    break;
                case '2':
                    novoGasto();
                    break;
                case '3':
                    obterFormasPagamento();
                    break;
                case '4':
                    obterTipoGasto();
                    break;
            }
        } while (opcao != '5');
    }

    private void listarGastos() {
        String[] opcoesMes = {
                "1 - Janeiro",
                "2 - Fevereiro",
                "3 - Marco",
                "4 - Abril",
                "5 - Maio",
                "6 - Junho",
                "7 - Julho",
                "8 - Agosto",
                "9 - Setembro",
                "10 - Outubro",
                "11 - Novembro",
                "12 - Desembro",
        };

        int mes = this.lerOpcoes("Escolha o mes", opcoesMes);
        int ano = Integer.parseInt(lerValor("Infome o ano (Somente numeros)"));

        String gastos = this.applicacao.listarGastos(mes + 1, ano);
        if (gastos.equals(""))
            escreverValor("Nenhum Gasto nesse periodo", "Lista de Gastos");
        else
            escreverValor(gastos, "Lista de Gastos");
    }

    private void novoGasto() {
        double valor;
        int dia, mes, ano;
        String descricao;
        String[] opcoesMes = {
                "1 - Janeiro",
                "2 - Fevereiro",
                "3 - Marco",
                "4 - Abril",
                "5 - Maio",
                "6 - Junho",
                "7 - Julho",
                "8 - Agosto",
                "9 - Setembro",
                "10 - Outubro",
                "11 - Novembro",
                "12 - Desembro",
        };

        // Solicita valor
        do {
            valor = Double.parseDouble(lerValor("Informe o valor do Gasto"));
        } while (valor < 1);
        // Seleciona Data
        do {
            dia = Integer.parseInt(lerValor("Informe o Dia do Gasto"));
        } while (dia < 1 || dia > 31);

        mes = this.lerOpcoes("Escolha o mes", opcoesMes);
        ano = Integer.parseInt(lerValor("Informe o Ano do Gasto (Somente numeros)"));

        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);

        Date data = calendar.getTime();

        // Dria Tipo de Gasto
        descricao = lerValor("Informe uma descricao para o Tipo de Gasto");
        TipoGasto tipo = new TipoGasto(descricao);

        // Cria Forma de Pagamento
        descricao = lerValor("Informe uma descricao para a Forma de Pagamento");
        FormaPagamento forma = new FormaPagamento(descricao);

        // Cria Novo gasto
        this.applicacao.novoGasto(data, valor, tipo, forma);
    }

    private void obterFormasPagamento() {
        String formas = "";

        for (int i = 0; i < this.applicacao.obterFormasPagamento().length; i++) {
            if (this.applicacao.obterFormasPagamento()[i] != null)
                formas += (i + 1) + ": " + this.applicacao.obterFormasPagamento()[i].getDescricao() + "\n";
        }

        if (formas.equals(""))
            formas = "Nenhuma Forma de Pagamento Cadastrada";

        escreverValor(formas, "Lista das Formas de Pagamento");
    }

    private void obterTipoGasto() {
        String tipos = "";

        for (int i = 0; i < this.applicacao.obterTiposGastos().length; i++) {
            if (this.applicacao.obterTiposGastos()[i] != null)
                tipos += (i + 1) + ": " + this.applicacao.obterTiposGastos()[i].getDescricao() + "\n";
        }

        if (tipos.equals(""))
            tipos = "Nenhum Tipo de Gasto Cadastrado";

        escreverValor(tipos, "Lista dos Tipos de Gasto");

    }

}
