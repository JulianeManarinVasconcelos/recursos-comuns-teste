package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum EmpresaAvaliacaoRisco {

	VAZIO("null", "");

	private String value;
	private String desc;

	EmpresaAvaliacaoRisco(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static EmpresaAvaliacaoRisco fromDesc(String desc) {
		for (EmpresaAvaliacaoRisco servico : EmpresaAvaliacaoRisco.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static EmpresaAvaliacaoRisco fromValue(String value) {
		for (EmpresaAvaliacaoRisco servico : EmpresaAvaliacaoRisco.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
