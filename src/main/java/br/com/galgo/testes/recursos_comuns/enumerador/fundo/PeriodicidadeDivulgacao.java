package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum PeriodicidadeDivulgacao {

	VAZIO("null", ""), //
	DIARIA("143", "DIÁRIA");

	private String value;
	private String desc;

	PeriodicidadeDivulgacao(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static PeriodicidadeDivulgacao fromDesc(String desc) {
		for (PeriodicidadeDivulgacao servico : PeriodicidadeDivulgacao.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static PeriodicidadeDivulgacao fromValue(String value) {
		for (PeriodicidadeDivulgacao servico : PeriodicidadeDivulgacao.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
