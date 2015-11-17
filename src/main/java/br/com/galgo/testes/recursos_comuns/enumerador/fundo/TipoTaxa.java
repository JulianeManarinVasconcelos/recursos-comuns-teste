package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum TipoTaxa {

	VAZIO("null", ""), //
	NAO_SE_APLICA("3", "NÃO SE APLICA");

	private String value;
	private String desc;

	TipoTaxa(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static TipoTaxa fromDesc(String desc) {
		for (TipoTaxa servico : TipoTaxa.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static TipoTaxa fromValue(String value) {
		for (TipoTaxa servico : TipoTaxa.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
