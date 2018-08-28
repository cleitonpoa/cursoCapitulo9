package entities;

public class FuncionarioTerceirizado extends Funcionario {

	private Double despesaAdicional;

	public FuncionarioTerceirizado() {
	}

	public FuncionarioTerceirizado(String nome, Integer horasTrabalhadas, Double valorHora, Double despesaAdicional) {
		super(nome, horasTrabalhadas, valorHora);
		this.despesaAdicional = despesaAdicional;
	}

	public Double getDespesaAdicional() {
		return despesaAdicional;
	}

	public void setDespesaAdicional(Double despesaAdicional) {
		this.despesaAdicional = despesaAdicional;
	}

	// Funcionarios terceirizados recebem bonus de 110% de suas despesas.
	@Override
	public Double pagamento() {
		Double pagamentoFinal = super.pagamento();
		pagamentoFinal += despesaAdicional * 1.1;
		return pagamentoFinal;
	}

}
