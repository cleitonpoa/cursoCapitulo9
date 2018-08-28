package entities;

import entities.enuns.TipoProduto;

public class Produto {

	protected String nome;
	protected Double preco;
	protected TipoProduto tipoProduto;

	public Produto(String nome, Double preco, TipoProduto tipoProduto) {
		this.nome = nome;
		this.preco = preco;
		this.tipoProduto = tipoProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String etiqueta() {
		return nome + " R$" + String.format("%.2f", preco);
	}
}
