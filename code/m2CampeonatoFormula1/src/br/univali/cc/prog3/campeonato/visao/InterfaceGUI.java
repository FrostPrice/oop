package br.univali.cc.prog3.campeonato.visao;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import br.univali.cc.prog3.campeonato.dominio.Autodromo;
import br.univali.cc.prog3.campeonato.dominio.Campeonato;
import br.univali.cc.prog3.campeonato.dominio.Carro;
import br.univali.cc.prog3.campeonato.dominio.Corrida;
import br.univali.cc.prog3.campeonato.dominio.Equipe;
import br.univali.cc.prog3.campeonato.dominio.Mecanico;
import br.univali.cc.prog3.campeonato.dominio.Organizador;
import br.univali.cc.prog3.campeonato.dominio.Piloto;

public class InterfaceGUI {
    private Organizador organizador;

    public InterfaceGUI(String nome) {
        this.organizador = new Organizador(nome);
    };

    private String lerValor(String rotulo) {
        return JOptionPane.showInputDialog(null, rotulo);
    }

    private String lerValor(String rotulo, String[] opcoes) {
        return (String) JOptionPane.showInputDialog(null, null, rotulo, 0, null,
                opcoes, null);
    }

    private void escreverValor(String texto, String titulo) {
        JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private Date solicitaData(String rotuloAno, String rotuloMes, String rotuloDia) {
        int ano = Integer.parseInt(lerValor(rotuloAno));
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
        int mes = Integer.parseInt(this.lerValor(rotuloMes, opcoesMes));
        int dia;
        do {
            dia = Integer.parseInt(lerValor(rotuloDia));
        } while (dia < 0 || dia > 31);
        LocalDate localData = LocalDate.of(ano, mes + 1, dia);
        Date data = Date.from(localData.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return data;
    }

    private String[] toOpcoesStrings(Object[] objects) {
        List<String> listaObjects = new ArrayList<String>();
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null) {
                listaObjects.add(i + " - " + objects[i].toString());
            }
        }
        String[] opcoes = new String[listaObjects.size()];
        opcoes = listaObjects.toArray(opcoes);
        return opcoes;
    }

    public void menu() {
        int opcaoSelecionada;
        do {
            String[] opcoes = {
                    "1 - Criar Campeonato",
                    "2 - Adicionar Corrida",
                    "3 - Inscrever Equipe",
                    "4 - Listar Campeonatos",
                    "5 - Listar Corridas de um Campeonato",
                    "6 - Listas Equipes Inscritas em um Campeonato",
                    "7 - Listas Informações de uma Corrida de um Campeonato",
                    "8 - Listas Informações de uma Equipe em um Campeonato",
                    "9 - Sair",
            };

            opcaoSelecionada = Integer.parseInt(lerValor("dsadas", opcoes).split("-")[0].trim());

            switch (opcaoSelecionada) {
                case 1:
                    criarCampeonato();
                    break;
                case 2:
                    adicionarCorrida();
                    break;
                case 3:
                    inscreverEquipe();
                    break;
                case 4:
                    listarCampeonatos();
                    break;
                case 5:
                    listarCorridas();
                    break;
                case 6:
                    listarEquipes();
                    break;
                case 8:
                    listarEquipe();
                    break;
            }
        } while (opcaoSelecionada != 9);
    }

    private void criarCampeonato() {
        int ano = Integer.parseInt(lerValor("Informe o Ano do Campeonato (Somente numeros)"));
        String nome = lerValor("Informe o nome do Campeonato");

        int campeonatoId = this.organizador.criarCampeonato(ano, nome);

        if (campeonatoId > -1) {
            escreverValor("Campeonato adicionado com sucesso", "Adicionado Campeonato");
        } else {
            escreverValor("Error: Limite alcancado!", "Adicionado Campeonato");
        }
    }

    private void adicionarCorrida() {
        Campeonato[] campeonatos = organizador.getCampeonato();
        // Verifica se existe um campeonato
        if (campeonatos[0] == null) {
            escreverValor("Nao existe nenhum Campeonato cadastrado!", "Adicionando Corrida");
            return;
        }

        String[] opcoesCampeonatos = toOpcoesStrings(campeonatos);
        int campeonato = Integer.parseInt(lerValor("Selecione o Campeonato", opcoesCampeonatos));

        // Verifica se ainda pode adicionar uma corrida
        if (campeonatos[campeonato].corridas[campeonatos[campeonato].corridas.length - 1] != null) {
            escreverValor("Error: Limite alcancado!", "Adicionando Corrida");
            return;
        }

        String nome = lerValor("Informe o nome do Autodromo");
        Autodromo autodromo = new Autodromo(nome);

        String rotuloAno = "Informe o Ano da Corrida (Somente numeros)";
        String rotuloMes = "Escolha o mes";
        String rotuloDia = "Informe o Dia da Corrida (Somente numeros) [1-31]";

        Date data = solicitaData(rotuloAno, rotuloMes, rotuloDia);

        this.organizador.adicionarCorrida(autodromo, data, campeonato);
    }

    private void inscreverEquipe() {
        Campeonato[] campeonatos = organizador.getCampeonato();
        // Verifica se existe um campeonato
        if (campeonatos[0] == null) {
            escreverValor("Nao existe nenhum Campeonato cadastrado!", "Adicionando Corrida");
            return;
        }

        String[] opcoesCampeonatos = toOpcoesStrings(campeonatos);
        int campeonato = Integer.parseInt(lerValor("Selecione o Campeonato", opcoesCampeonatos));

        if (campeonatos[campeonato].equipes[campeonatos[campeonato].corridas.length - 1] != null) {
            escreverValor("Campeonato com numero maximo de equipes!", "Inscrevendo Equipe");
        }

        String nomeEquipe = lerValor("Informe o nome da Equipe");
        Equipe equipe = new Equipe(nomeEquipe);

        // Criar N numero de mecanicos
        String nomeMecanico;
        do {
            // Verifica se ainda pode adicionar mais mecanicos
            if (campeonatos[campeonato].corridas[campeonatos[campeonato].corridas.length - 1] != null) {
                escreverValor("Error: Limite alcancado!", "Adicionado Equipe");
                return;
            }

            nomeMecanico = lerValor("Digite o nome do mecanico");
            Mecanico mecanico = new Mecanico(nomeMecanico);
            equipe.adicionarMecanico(mecanico);
        } while (nomeMecanico != null);

        // Criar 2 carros
        for (int i = 0; i < equipe.carros.length; i++) {
            int numero = Integer.parseInt(lerValor("Informe o numero do " + i + "° " +
                    "Carro (Somente numeros)"));

            Carro carro = new Carro(numero);
            equipe.carros[i] = carro;
        }

        String[] opcoesCarros = toOpcoesStrings(equipe.carros);

        // Definir 2 pilotos
        for (int i = 0; i < equipe.carros.length; i++) {
            String nomePiloto = lerValor("Informe o nome do " + i + "° " + "Piloto");
            int licenca = Integer
                    .parseInt(lerValor("Informe o numero da licenca do " + i + "° " + "Piloto (Somente numeros)"));
            int carro = Integer.parseInt(lerValor("Selecione o Carro", opcoesCarros));

            Piloto piloto = new Piloto(nomePiloto, licenca);
            piloto.setCarro(equipe.carros[carro]);
            equipe.carros[carro].setPiloto(piloto);

            // Remove o carro selecionado das opcoes
            String[] updateOpcoesCarro = new String[opcoesCarros.length - 2];
            int contador = 0;
            for (int j = 0; j < opcoesCarros.length; j++) {
                if (carro != j) {
                    updateOpcoesCarro[contador++] = opcoesCarros[j];
                }
            }
        }

        if (this.organizador.inscrever(equipe, campeonato)) {
            escreverValor("Equipe inscrita com sucesso nesse campeonato!", "Inscrevendo Equipe");
        }
    }

    private void listarCampeonatos() {
        String campeonatos = "";

        for (int i = 0; i < this.organizador.getCampeonato().length; i++) {
            if (this.organizador.getCampeonato()[i] != null)
                campeonatos += (i + 1) + " (" + this.organizador.getCampeonato()[i].getAno() + ") " + ": " +
                        this.organizador.getCampeonato()[i].getNome() + "\n";
        }

        if (campeonatos.equals(""))
            campeonatos = "Nenhuma Campeonato Cadastrado";

        escreverValor(campeonatos, "Lista dos Campeonatos");
    }

    private void listarCorridas() {
        Campeonato[] campeonatos = organizador.getCampeonato();
        if (campeonatos[0] == null) { // Guard Clause
            escreverValor("Nao existe nenhum Campeonato cadastrado!", "Listagem de Corridas");
            return;
        }

        String[] opcoesCampeonatos = toOpcoesStrings(campeonatos);
        int campeonato = Integer.parseInt(lerValor("Selecione o Campeonato", opcoesCampeonatos));

        String corridasString = "";
        Corrida[] corridas = this.organizador.getCampeonato()[campeonato].corridas;
        for (int i = 0; i < corridas.length; i++) {
            if (corridas[i] != null) {
                Date dataCorrida = corridas[i].getData();

                corridasString += i + ": Local " + corridas[i].getAutodromo().getLocal() + ", data "
                        + dataCorrida
                        + "\n";
            }
        }

        if (corridasString.equals(""))
            corridasString = "Nenhuma Corrida Cadastrado";

        escreverValor(corridasString, "Lista de Corridas do Campeonato " + campeonato);
    }

    private void listarEquipes() {
        Campeonato[] campeonatos = organizador.getCampeonato();
        if (campeonatos[0] == null) { // Guard Clause
            escreverValor("Nao existe nenhum Campeonato cadastrado!", "Listagem de Equipes");
            return;
        }

        String[] opcoesCampeonatos = toOpcoesStrings(campeonatos);
        int campeonato = Integer.parseInt(lerValor("Selecione o Campeonato", opcoesCampeonatos));

        String equipesString = "";
        Equipe[] equipes = this.organizador.getCampeonato()[campeonato].equipes;
        for (int i = 0; i < equipes.length; i++) {
            if (equipes[i] != null)
                equipesString += i + ": Nome " + equipes[i].getNome() + "\n";

        }

        if (equipesString.equals(""))
            equipesString = "Nenhuma Equipe Cadastrada";

        escreverValor(equipesString, "Lista de equipes do Campeonato " + campeonato);
    }

    private void listarEquipe() {
        Campeonato[] campeonatos = organizador.getCampeonato();
        if (campeonatos[0] == null) { // Guard Clause
            escreverValor("Nao existe nenhum Campeonato cadastrado!", "Informacoes da Equipe");
            return;
        }

        String[] opcoesCampeonatos = toOpcoesStrings(campeonatos);
        int campeonato = Integer.parseInt(lerValor("Selecione o Campeonato", opcoesCampeonatos));

        Equipe[] equipes = this.organizador.getCampeonato()[campeonato].equipes;
        if (equipes[0] == null) { // Guard Clause
            escreverValor("Nao existe nenhuma equipe cadastrada!", "Informacoes da Equipe");
            return;
        }
        String[] opcoesEquipes = toOpcoesStrings(campeonatos);
        int equipe = Integer.parseInt(lerValor("Selecione a equipe", opcoesEquipes));

        String mecanicosEquipe = "";
        Mecanico[] mecanicos = equipes[equipe].getMecanicos();
        for (int i = 0; i < mecanicos.length; i++) {
            if (mecanicos[i] != null) {
                mecanicosEquipe += i + ": " + mecanicos[i].getNome() + "\n";
            }

        }
        escreverValor(mecanicosEquipe, "Informações da equipe " + equipes[equipe].getNome());

        String pilotosCarros = "";
        Carro[] carros = equipes[equipe].getCarros();
        for (int i = 0; i < carros.length; i++) {
            if (carros[i] != null) {
                pilotosCarros += "Carro: " + carros[i].getNumero() + ", Piloto:" + carros[i].getPiloto().getNome()
                        + "\n";
            }

        }
        escreverValor(pilotosCarros, "Informações da equipe " + equipes[equipe].getNome());
    }
}
