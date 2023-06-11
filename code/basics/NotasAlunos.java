// Execicio 3
// Escreva uma classe que receba, via linha de comando, 10 notas (em valor inteiro) e, ao final, mostre um grafico conforme exemplo abaixo. Ao final, apresente a media dos alunos (media = soma das notas / total de alunos)

public class NotasAlunos {
    public static void main(String[] args)
	{
		int qtd_de_notas = args.length;
		if (qtd_de_notas != 10) {
			System.out.println("Por favor, informe 10 notas!");
			return;
		}

        double media;
		double soma = 0;

        System.out.println("Grafico das Notas: ");        
		int i = 0;	
		while(i < qtd_de_notas) {
            int nota = Integer.parseInt(args[i]);

            System.out.print("Aluno " + (i + 1) + ": ");        
            int j = 0;
            while(j < nota) {
                System.out.print("*");        
                j++;    
            }

            System.out.print("\n"); // Quebra linha

            soma += nota;
			i++;
		}
        
        media = soma / qtd_de_notas;
        System.out.print("\n"); // Quebra linha
        System.out.println("Media da turma: " + media);
	}
}
