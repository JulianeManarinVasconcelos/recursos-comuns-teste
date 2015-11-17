package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum BaseDuracaoFundo {

	VAZIO("null", "");

	private String value;
	private String desc;

	BaseDuracaoFundo(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static BaseDuracaoFundo fromDesc(String desc) {
		for (BaseDuracaoFundo servico : BaseDuracaoFundo.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static BaseDuracaoFundo fromValue(String value) {
		for (BaseDuracaoFundo servico : BaseDuracaoFundo.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
