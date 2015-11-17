package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Contabilidade {

	VAZIO("null", "");

	private String value;
	private String desc;

	Contabilidade(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Contabilidade fromDesc(String desc) {
		for (Contabilidade servico : Contabilidade.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Contabilidade fromValue(String value) {
		for (Contabilidade servico : Contabilidade.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
