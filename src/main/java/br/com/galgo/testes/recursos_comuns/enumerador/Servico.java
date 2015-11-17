package br.com.galgo.testes.recursos_comuns.enumerador;

public enum Servico {

	EXTRATO("1006", "EXTRATO"), //
	INFO_ANBIMA("1007", "INFORMAÇÕES ANBIMA"), //
	PL_COTA("1008", "PL/COTA"), //
	POSICAO_ATIVOS("1009", "POSIÇÃO");

	private String value;
	private String desc;

	Servico(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Servico fromDesc(String desc) {
		for (Servico servico : Servico.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Servico fromValue(String value) {
		for (Servico servico : Servico.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
