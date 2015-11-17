package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum CreditoPrivado {

	VAZIO("null", ""), //
	NAO("2", "NÃO"), //
	NAO_SE_APLICA("3", "NÃO SE APLICA"), //
	SIM("1", "SIM");

	private String value;
	private String desc;

	CreditoPrivado(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static CreditoPrivado fromDesc(String desc) {
		for (CreditoPrivado servico : CreditoPrivado.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static CreditoPrivado fromValue(String value) {
		for (CreditoPrivado servico : CreditoPrivado.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
