package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum Auditoria {

	VAZIO("null", ""), //
	GALGO08("27", "GALGO - 08 - CONSULTORIA"), //
	CLOUD_GTEC_PROVEDOR("3765", "CLOUD - GTEC - PROVEDOR"), //
	CLOUD_GTEC_CONSUMIDOR("3768", "CLOUD - GTEC CONSUMIDOR"), ;

	private String value;
	private String desc;

	Auditoria(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Auditoria fromDesc(String desc) {
		for (Auditoria servico : Auditoria.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Auditoria fromValue(String value) {
		for (Auditoria servico : Auditoria.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
