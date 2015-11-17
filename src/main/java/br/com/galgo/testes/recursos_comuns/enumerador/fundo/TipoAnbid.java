package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum TipoAnbid {

	VAZIO("null", ""), //
	ACOES_LIVRE("30", "AÇÕES LIVRE");

	private String value;
	private String desc;

	TipoAnbid(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static TipoAnbid fromDesc(String desc) {
		for (TipoAnbid servico : TipoAnbid.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static TipoAnbid fromValue(String value) {
		for (TipoAnbid servico : TipoAnbid.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
