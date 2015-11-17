package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Status {

	ENCERRADO("ENCERRADO", "Encerrado Mercado")//
	;

	private String value;
	private String desc;

	Status(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Status fromDesc(String desc) {
		for (Status servico : Status.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Status fromValue(String value) {
		for (Status servico : Status.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
