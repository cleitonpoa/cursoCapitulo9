package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;
import entities.FuncionarioTerceirizado;

/* 
Uma empresa possui funcion�rios pr�prios e terceirizados.
Para cada funcion�rio, deseja-se registrar nome, horas
trabalhadas e valor por hora. Funcion�rios terceirizado
possuem ainda uma despesa adicional.
O pagamento dos funcion�rios corresponde ao valor da hora
multiplicado pelas horas trabalhadas, sendo que os
funcion�rios terceirizados ainda recebem um b�nus
correspondente a 110% de sua despesa adicional.
Fazer um programa para ler os dados de N funcion�rios (N
fornecido pelo usu�rio) e armazen�-los em uma lista. Depois
de ler todos os dados, mostrar nome e pagamento de cada
funcion�rio na mesma ordem em que foram digitados.
*/

public class PagamentoFuncionarios {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Informe o numero de funcionarios para o cadastro: ");
		int totalFuncionarios = sc.nextInt();
		List<Funcionario> listaFuncionarios = new ArrayList<>();

		for (int i = 0; i < totalFuncionarios; i++) {
			System.out.println("DADOS DO FUNCIONARIO " + (i + 1) + ":");
			System.out.print("Funcionario terceirizado[S/N]?");
			String terceirizado = sc.next().substring(0, 1);
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Horas trabalhadas: ");
			int horas = sc.nextInt();
			System.out.print("Valor hora: ");
			double valorHora = sc.nextDouble();

			if (terceirizado.equalsIgnoreCase("S")) {
				System.out.print("Valor despesas adicionais: ");
				double despesasAdicionais = sc.nextDouble();
				Funcionario funcionario = new FuncionarioTerceirizado(nome, horas, valorHora, despesasAdicionais);
				listaFuncionarios.add(funcionario);
			} else {
				Funcionario funcionario = new Funcionario(nome, horas, valorHora);
				listaFuncionarios.add(funcionario);
			}
		}

		System.out.printf("%nPAGAMENTOS:%n");
		for (Funcionario f : listaFuncionarios) {
			System.out.println(f.getNome() + " - R$" + String.format("%.2f", f.pagamento()));
			sc.close();
		}
	}
}
