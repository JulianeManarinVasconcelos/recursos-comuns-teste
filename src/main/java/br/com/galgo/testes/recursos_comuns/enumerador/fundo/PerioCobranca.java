package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum PerioCobranca {

	VAZIO("null", "");

	private String value;
	private String desc;

	PerioCobranca(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static PerioCobranca fromDesc(String desc) {
		for (PerioCobranca servico : PerioCobranca.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static PerioCobranca fromValue(String value) {
		for (PerioCobranca servico : PerioCobranca.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
