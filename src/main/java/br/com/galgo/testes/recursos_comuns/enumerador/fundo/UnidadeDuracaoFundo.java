package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum UnidadeDuracaoFundo {

	VAZIO("null", ""), //
	ANOS("3", "ANOS"), //
	DIAS("1", "DIAS"), //
	MESES("2", "MESES");

	private String value;
	private String desc;

	UnidadeDuracaoFundo(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static UnidadeDuracaoFundo fromDesc(String desc) {
		for (UnidadeDuracaoFundo servico : UnidadeDuracaoFundo.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static UnidadeDuracaoFundo fromValue(String value) {
		for (UnidadeDuracaoFundo servico : UnidadeDuracaoFundo.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
