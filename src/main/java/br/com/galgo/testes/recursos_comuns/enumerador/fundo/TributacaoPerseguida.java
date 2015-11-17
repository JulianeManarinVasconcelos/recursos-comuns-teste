package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum TributacaoPerseguida {

	VAZIO("null", ""), //
	CURTO_PRAZO("1", "CURTO PRAZO"), //
	INDEFINIDO("3", "INDEFINIDO"), //
	LONGO_PRAZO("2", "LONGO PRAZO"), //
	NAO_APLICAVEL("4", "NÃO APLICÁVEL"), //
	RENDA_VARIAVEL("5", "RENDA VARIÁVEL");

	private String value;
	private String desc;

	TributacaoPerseguida(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static TributacaoPerseguida fromDesc(String desc) {
		for (TributacaoPerseguida servico : TributacaoPerseguida.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static TributacaoPerseguida fromValue(String value) {
		for (TributacaoPerseguida servico : TributacaoPerseguida.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
