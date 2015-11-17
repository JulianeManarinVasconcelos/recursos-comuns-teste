package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum BancoContaCorrente {

	VAZIO("null", "");

	private String value;
	private String desc;

	BancoContaCorrente(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static BancoContaCorrente fromDesc(String desc) {
		for (BancoContaCorrente servico : BancoContaCorrente.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static BancoContaCorrente fromValue(String value) {
		for (BancoContaCorrente servico : BancoContaCorrente.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
