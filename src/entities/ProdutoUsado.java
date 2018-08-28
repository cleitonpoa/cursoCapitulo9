package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import entities.enuns.TipoProduto;

public class ProdutoUsado extends Produto {

	private Date dataFabricacao;

	public ProdutoUsado(String nome, Double preco, TipoProduto tipoProduto, Date dataFabricacao) {
		super(nome, preco, tipoProduto);
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	@Override
	public String etiqueta() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return nome + " (usado) R$" + String.format("%.2f", preco) + "(Data fabricacao: " + sdf.format(dataFabricacao)
				+ ")";
	}

}
