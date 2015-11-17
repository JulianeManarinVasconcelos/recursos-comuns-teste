package br.com.galgo.testes.recursos_comuns.enumerador.carteira;

public enum AvaliadorRisco {

	VAZIO("null", ""), //
	GALGO15("295", "GALGO - 15");

	private String value;
	private String desc;

	AvaliadorRisco(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static AvaliadorRisco fromDesc(String desc) {
		for (AvaliadorRisco servico : AvaliadorRisco.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static AvaliadorRisco fromValue(String value) {
		for (AvaliadorRisco servico : AvaliadorRisco.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
