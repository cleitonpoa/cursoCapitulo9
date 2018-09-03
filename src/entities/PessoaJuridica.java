package entities;

public class PessoaJuridica extends Contribuinte {

	public static final Double PERCENTUAL_IMPOSTO_MENOR = 0.14;
	public static final Double PERCENTUAL_IMPOSTO_MAIOR = 0.16;

	private Integer numeroFuncionaros;

	public PessoaJuridica(String nome, Double rendaAnual, Integer numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionaros = numeroFuncionarios;
	}

	public Integer getNumeroFuncionaros() {
		return numeroFuncionaros;
	}

	public void setNumeroFuncionaros(Integer numeroFuncionaros) {
		this.numeroFuncionaros = numeroFuncionaros;
	}

	@Override
	public Double calcularImposto() {
		Double imposto = rendaAnual * PERCENTUAL_IMPOSTO_MAIOR;
		if (numeroFuncionaros > 10) {
			imposto = rendaAnual * PERCENTUAL_IMPOSTO_MENOR;
		}
		return imposto;
	}

}
