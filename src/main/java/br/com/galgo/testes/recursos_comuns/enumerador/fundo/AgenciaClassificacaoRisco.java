package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum AgenciaClassificacaoRisco {

	VAZIO("null", "");

	private String value;
	private String desc;

	AgenciaClassificacaoRisco(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static AgenciaClassificacaoRisco fromDesc(String desc) {
		for (AgenciaClassificacaoRisco servico : AgenciaClassificacaoRisco
				.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static AgenciaClassificacaoRisco fromValue(String value) {
		for (AgenciaClassificacaoRisco servico : AgenciaClassificacaoRisco
				.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
