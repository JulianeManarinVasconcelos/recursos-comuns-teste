package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum PeriodoCorrecao {

	VAZIO("null", "");

	private String value;
	private String desc;

	PeriodoCorrecao(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static PeriodoCorrecao fromDesc(String desc) {
		for (PeriodoCorrecao servico : PeriodoCorrecao.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static PeriodoCorrecao fromValue(String value) {
		for (PeriodoCorrecao servico : PeriodoCorrecao.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
