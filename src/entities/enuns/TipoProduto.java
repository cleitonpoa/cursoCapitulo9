package entities.enuns;

public enum TipoProduto {

	COMUM(1), IMPORTADO(2), USADO(3);

	private int tipo;

	TipoProduto(int tipo) {
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

	public static TipoProduto criarPorNumero(int numeroTipo) {
		for (TipoProduto tp : TipoProduto.values()) {
			if (tp.tipo == numeroTipo) {
				return tp;
			}
		}
		throw new IllegalArgumentException("codigo tipo produto invalido");
	}

}
