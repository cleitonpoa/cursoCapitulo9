package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;
import entities.enuns.TipoProduto;

/* Fazer um programa para ler os dados de N produtos (N fornecido pelo usu�rio). Ao final,
mostrar a etiqueta de pre�o de cada produto na mesma ordem em que foram digitados.
Todo produto possui nome e pre�o. Produtos importados possuem uma taxa de alf�ndega, e
produtos usados possuem data de fabrica��o.
Estes dados espec�ficos devem ser acrescentados na etiqueta de pre�o conforme
exemplo (pr�xima p�gina). Para produtos importados, a taxa e alf�ndega deve ser
acrescentada ao pre�o final do produto.
*/

public class CadastrarProdutos {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		List<Produto> listaProdutos = new ArrayList<>();

		System.out.print("Informe o numero de produtos: ");
		int totalProdutos = sc.nextInt();

		// Digitacao dados dos produtos
		for (int i = 0; i < totalProdutos; i++) {
			System.out.println("# Dados produto " + (i + 1) + ":");
			System.out.print("Numero do tipo do Produto (COMUM[1], IMPORTADO[2] ou USADO[3]): ");
			TipoProduto tipoProduto = TipoProduto.criarPorNumero(sc.nextInt());
			System.out.print("Nome: ");
			String nome = sc.next();
			System.out.print("Pre�o: ");
			double preco = sc.nextDouble();

			// Inclusao de produtos na lista conforme tipo
			if (tipoProduto.equals(TipoProduto.IMPORTADO)) {
				System.out.print("Valor taxa alfandega: ");
				double taxaAlfandega = sc.nextDouble();
				listaProdutos.add(new ProdutoImportado(nome, preco, tipoProduto, taxaAlfandega));
			} else if (tipoProduto.equals(TipoProduto.USADO)) {
				System.out.print("Data fabricacao (dd/mm/aaaa): ");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date dataFabricacao = sdf.parse(sc.next());
				listaProdutos.add(new ProdutoUsado(nome, preco, tipoProduto, dataFabricacao));
			} else {
				listaProdutos.add(new Produto(nome, preco, tipoProduto));
			}
		}

		// Impressao de dados de etiquetas do produto
		System.out.printf("%nINFORMACOES ETIQUETAS:%n");
		for (Produto p : listaProdutos) {
			System.out.println(p.etiqueta());
		}

		sc.close();
	}

}
