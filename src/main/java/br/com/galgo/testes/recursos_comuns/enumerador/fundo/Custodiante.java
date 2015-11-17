package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Custodiante {

	VAZIO("null", ""), //
	GALGO07("24", "GALGO - 07 - CUST E ESCRITURADOR"), //
	CLOUD_GTEC_PROVEDOR("3765", "CLOUD - GTEC - PROVEDOR"), //
	CLOUD_GTEC_CONSUMIDOR("3768", "CLOUD - GTEC CONSUMIDOR");

	private String value;
	private String desc;

	Custodiante(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Custodiante fromDesc(String desc) {
		for (Custodiante servico : Custodiante.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Custodiante fromValue(String value) {
		for (Custodiante servico : Custodiante.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
