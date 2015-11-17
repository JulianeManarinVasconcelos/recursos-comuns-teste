package br.com.galgo.testes.recursos_comuns.enumerador;

public enum TipoExtrato {

	CONSOLIDADO("SETT", "Saldo Consolidado"), //
	CERTIFICADO("SCRI", "Saldo por Certificado"), //
	MOV_PERIODO("MOSE", "Movimentação no Período");

	private String value;
	private String desc;

	TipoExtrato(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

}
