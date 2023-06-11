// Exercicio 2:
// Crie uma classe "Numero" que receba X numeros via linha de comando, mostre o mesnor, o maior e a media dos numeros informados

public class Numero
{
	public static void main(String[] args)
	{
		int qtd_de_numeros = args.length;

		if (qtd_de_numeros == 0) {
			System.out.println("Nenhum numero informado!");
			return;
		}

		int maior = Integer.parseInt(args[0]);
		int menor = Integer.parseInt(args[0]);
		double media;
		double soma = 0;

		int i = 0;		
		while(i < qtd_de_numeros) {
			int numero = Integer.parseInt(args[i]);
			if (numero < menor) {
                menor = numero;
            }
            if (numero > maior) {
                maior = numero;
            }

			soma += Integer.parseInt(args[i]);

			i++;
		}

		media = soma / qtd_de_numeros;

        System.out.println("Maior numero: " + maior);
		System.out.println("Menor numero: " + menor);
        System.out.println("Media: " + media);
	}
}