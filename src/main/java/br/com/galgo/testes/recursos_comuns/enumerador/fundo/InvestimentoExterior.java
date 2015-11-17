package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum InvestimentoExterior {

	VAZIO("null", ""), //
	NAO("2", "NÃO"), //
	NAO_SE_APLICA("3", "NÃO SE APLICA"), //
	SIM("1", "SIM");

	private String value;
	private String desc;

	InvestimentoExterior(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static InvestimentoExterior fromDesc(String desc) {
		for (InvestimentoExterior servico : InvestimentoExterior.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static InvestimentoExterior fromValue(String value) {
		for (InvestimentoExterior servico : InvestimentoExterior.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
