package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum AplicacaoAutomatica {

	VAZIO("null", ""), //
	NAO("198", "NÃO"), //
	NAO_SE_APLICA("199", "NÃO SE APLICA"), //
	SIM("197", "SIM");

	private String value;
	private String desc;

	AplicacaoAutomatica(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static AplicacaoAutomatica fromDesc(String desc) {
		for (AplicacaoAutomatica servico : AplicacaoAutomatica.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static AplicacaoAutomatica fromValue(String value) {
		for (AplicacaoAutomatica servico : AplicacaoAutomatica.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
