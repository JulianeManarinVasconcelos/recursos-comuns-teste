package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Idioma {

	INGLES("1", "Inglês"), //
	PORTUGUES("2", "Português");

	private String value;
	private String desc;

	Idioma(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Idioma fromDesc(String desc) {
		for (Idioma servico : Idioma.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Idioma fromValue(String value) {
		for (Idioma servico : Idioma.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
