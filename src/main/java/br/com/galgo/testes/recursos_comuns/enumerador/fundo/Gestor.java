package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Gestor {

	VAZIO("null", ""), //
	GALGO06("21", "GALGO - 06 - GESTOR"), //
	CLOUD_GTEC_PROVEDOR("3765", "CLOUD - GTEC - PROVEDOR"), //
	CLOUD_GTEC_CONSUMIDOR("3768", "CLOUD - GTEC CONSUMIDOR");

	private String value;
	private String desc;

	Gestor(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Gestor fromDesc(String desc) {
		for (Gestor servico : Gestor.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Gestor fromValue(String value) {
		for (Gestor servico : Gestor.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
