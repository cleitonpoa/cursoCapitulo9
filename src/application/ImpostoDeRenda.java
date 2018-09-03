package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

/*
Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais
podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um,
bem como o total de imposto arrecadado.
 */

public class ImpostoDeRenda {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Contribuinte> listaContribuintes = new ArrayList<>();

		System.out.print("Informe o numero de contribuintes: ");
		int numContribuintes = sc.nextInt();

		for (int i = 0; i < numContribuintes; i++) {
			System.out.println("# Dados do contribuinte " + (i + 1) + ":");

			System.out.print("Pessoa Fisica ou Juridica <F/J>: ");
			Character tipoContribuinte = sc.next().toLowerCase().charAt(0);

			System.out.print("Nome: ");
			String nome = sc.next();

			System.out.print("Renda anual: ");
			double rendaAnual = sc.nextDouble();

			if (tipoContribuinte == 'f') {
				System.out.print("Gastos com saude: ");
				double gastosSaude = sc.nextDouble();
				listaContribuintes.add(new PessoaFisica(nome, rendaAnual, gastosSaude));
			} else {
				System.out.print("Numero funcionarios: ");
				int numeroFuncionarios = sc.nextInt();
				listaContribuintes.add(new PessoaJuridica(nome, rendaAnual, numeroFuncionarios));
			}
		}
		double impostosTotais = 0.0;
		System.out.printf("%nIMPOSTOS PAGOS:%n");
		for (Contribuinte c : listaContribuintes) {
			System.out.println(c.getNome() + ": R$" + String.format("%.2f", c.calcularImposto()));
			impostosTotais += c.calcularImposto();
		}

		System.out.printf("%nIMPOSTOS TOTAIS: R$" + String.format("%.2f", impostosTotais));

		sc.close();
	}

}
