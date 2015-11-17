package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Controlador {

	VAZIO("null", ""), //
	GALGO04("15", "GALGO - 04 - CA E CP"), //
	CLOUD_GTEC_PROVEDOR("3765", "CLOUD - GTEC - PROVEDOR"), //
	CLOUD_GTEC_CONSUMIDOR("3768", "CLOUD - GTEC CONSUMIDOR");

	private String value;
	private String desc;

	Controlador(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Controlador fromDesc(String desc) {
		for (Controlador servico : Controlador.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Controlador fromValue(String value) {
		for (Controlador servico : Controlador.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
