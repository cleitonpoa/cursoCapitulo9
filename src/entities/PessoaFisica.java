package entities;

public class PessoaFisica extends Contribuinte {

	public static final Double LIMITE_RENDA_ANUAL = 20000.0;
	public static final Double PERCENTUAL_IMPOSTO_MENOR = 0.15;
	public static final Double PERCENTUAL_IMPOSTO_MAIOR = 0.25;
	public static final Double PERCENTUAL_ABATIMENTO_GASTOS_SAUDE = 0.5;

	private Double gastosSaude;

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public Double calcularImposto() {
		Double imposto = 0.0;
		if (rendaAnual < LIMITE_RENDA_ANUAL) {
			imposto = rendaAnual * PERCENTUAL_IMPOSTO_MENOR;
		} else {
			imposto = rendaAnual * PERCENTUAL_IMPOSTO_MAIOR;
		}
		if (gastosSaude > 0.0) {
			imposto -= gastosSaude * PERCENTUAL_ABATIMENTO_GASTOS_SAUDE;
		}
		return imposto;
	}

}
