package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum DataBaseAmortizacao {

	VAZIO("null", "");

	private String value;
	private String desc;

	DataBaseAmortizacao(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static DataBaseAmortizacao fromDesc(String desc) {
		for (DataBaseAmortizacao servico : DataBaseAmortizacao.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static DataBaseAmortizacao fromValue(String value) {
		for (DataBaseAmortizacao servico : DataBaseAmortizacao.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
