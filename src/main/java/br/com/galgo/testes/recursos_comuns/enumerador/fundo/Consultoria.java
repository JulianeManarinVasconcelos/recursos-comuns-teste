package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Consultoria {

	VAZIO("null", "");

	private String value;
	private String desc;

	Consultoria(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Consultoria fromDesc(String desc) {
		for (Consultoria servico : Consultoria.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Consultoria fromValue(String value) {
		for (Consultoria servico : Consultoria.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
