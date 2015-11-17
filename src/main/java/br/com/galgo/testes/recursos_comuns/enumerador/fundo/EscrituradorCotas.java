package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum EscrituradorCotas {

	VAZIO("null", "");

	private String value;
	private String desc;

	EscrituradorCotas(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static EscrituradorCotas fromDesc(String desc) {
		for (EscrituradorCotas servico : EscrituradorCotas.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static EscrituradorCotas fromValue(String value) {
		for (EscrituradorCotas servico : EscrituradorCotas.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
