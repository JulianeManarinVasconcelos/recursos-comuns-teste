package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum PlBaseCalculoTaxaPerfor {

	VAZIO("null", "");

	private String value;
	private String desc;

	PlBaseCalculoTaxaPerfor(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static PlBaseCalculoTaxaPerfor fromDesc(String desc) {
		for (PlBaseCalculoTaxaPerfor servico : PlBaseCalculoTaxaPerfor.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static PlBaseCalculoTaxaPerfor fromValue(String value) {
		for (PlBaseCalculoTaxaPerfor servico : PlBaseCalculoTaxaPerfor.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
