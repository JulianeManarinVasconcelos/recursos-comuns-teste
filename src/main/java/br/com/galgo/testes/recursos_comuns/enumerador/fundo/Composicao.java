package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Composicao {

	VAZIO("null", ""), //
	FC("2", "FC"), //
	FF("3", "FF"), //
	FI("1", "FI");

	private String value;
	private String desc;

	Composicao(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Composicao fromDesc(String desc) {
		for (Composicao servico : Composicao.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Composicao fromValue(String value) {
		for (Composicao servico : Composicao.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
