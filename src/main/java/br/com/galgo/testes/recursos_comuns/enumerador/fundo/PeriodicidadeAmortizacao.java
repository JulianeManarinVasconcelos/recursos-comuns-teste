package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum PeriodicidadeAmortizacao {

	VAZIO("null", "");

	private String value;
	private String desc;

	PeriodicidadeAmortizacao(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static PeriodicidadeAmortizacao fromDesc(String desc) {
		for (PeriodicidadeAmortizacao servico : PeriodicidadeAmortizacao.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static PeriodicidadeAmortizacao fromValue(String value) {
		for (PeriodicidadeAmortizacao servico : PeriodicidadeAmortizacao.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
