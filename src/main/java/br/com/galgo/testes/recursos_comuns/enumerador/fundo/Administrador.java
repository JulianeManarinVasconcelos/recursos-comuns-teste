package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Administrador {

	VAZIO("null", ""), //
	GALGO13("42", "GALGO - 13"), //
	CLOUD_GTEC_PROVEDOR("3765", "CLOUD - GTEC - PROVEDOR"), //
	CLOUD_GTEC_CONSUMIDOR("3768", "CLOUD - GTEC CONSUMIDOR"), ;

	private String value;
	private String desc;

	Administrador(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Administrador fromDesc(String desc) {
		for (Administrador servico : Administrador.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Administrador fromValue(String value) {
		for (Administrador servico : Administrador.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
