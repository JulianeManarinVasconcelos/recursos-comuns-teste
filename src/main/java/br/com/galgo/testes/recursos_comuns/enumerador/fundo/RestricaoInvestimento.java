package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum RestricaoInvestimento {

	VAZIO("null", ""), //
	EXCLUSIVO("103", "EXCLUSIVO"), //
	NAO_HA_RESTRICAO("105", "NÃO HÁ RESTRIÇÃO"), //
	RESTRITO("104", "RESTRITO");

	private String value;
	private String desc;

	RestricaoInvestimento(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static RestricaoInvestimento fromDesc(String desc) {
		for (RestricaoInvestimento servico : RestricaoInvestimento.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static RestricaoInvestimento fromValue(String value) {
		for (RestricaoInvestimento servico : RestricaoInvestimento.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
