package entities;

import entities.enuns.TipoProduto;

public class ProdutoImportado extends Produto {

	private Double taxaAlfandega;

	public ProdutoImportado(String nome, Double preco, TipoProduto tipoProduto, Double taxaAlfandega) {
		super(nome, preco, tipoProduto);
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double getTaxaAlfandega() {
		return taxaAlfandega;
	}

	public void setTaxaAlfandega(Double taxaAlfandega) {
		this.taxaAlfandega = taxaAlfandega;
	}

	public Double precoTotal() {
		return preco + taxaAlfandega;
	}

	@Override
	public String etiqueta() {
		return nome + " R$" + String.format("%.2f", precoTotal()) + " (Taxa alfandega: R$"
				+ String.format("%.2f", taxaAlfandega) + ")";
	}

}
