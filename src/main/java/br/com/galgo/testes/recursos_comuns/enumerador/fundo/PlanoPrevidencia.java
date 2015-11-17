package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum PlanoPrevidencia {

	VAZIO("null", ""), //
	NAO("192", "NÃO");

	private String value;
	private String desc;

	PlanoPrevidencia(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static PlanoPrevidencia fromDesc(String desc) {
		for (PlanoPrevidencia servico : PlanoPrevidencia.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static PlanoPrevidencia fromValue(String value) {
		for (PlanoPrevidencia servico : PlanoPrevidencia.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
