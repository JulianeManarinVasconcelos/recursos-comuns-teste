package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum CategoriaAnbid {

	VAZIO("null", ""), //
	ACOES("91", "AÇÕES"), //
	CAMBIAL("92", "CAMBIAL"), //
	CURTO_PRAZO("93", "CURTO PRAZO"), //
	DIREITOS_CREDITORIOS("99", "DIREITOS CREDITÓRIOS"), //
	EXCLUSIVOS_FECHADOS("142", "EXCLUSIVOS FECHADOS"), //
	FUNDOS_DE_INDICE("98", "FUNDOS DE ÍNDICE"), //
	FUNDOS_DE_PARTICIPACOES("101", "FUNDOS DE PARTICIPAÇÕES"), //
	INVESTIMENTO_IMOBILIARIO("100", "INVESTIMENTO IMOBILIÁRIO"), //
	INVESTIMENTO_NO_EXTERIOR("94", "INVESTIMENTO NO EXTERIOR"), //
	MULTIMERCADO("95", "MULTIMERCADO"), //
	OFF_SHORE("102", "OFF SHORE"), //
	REFERENCIADO("96", "REFERENCIADO"), //
	RENDA_FIXA("97", "RENDA FIXA");

	private String value;
	private String desc;

	CategoriaAnbid(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static CategoriaAnbid fromDesc(String desc) {
		for (CategoriaAnbid servico : CategoriaAnbid.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static CategoriaAnbid fromValue(String value) {
		for (CategoriaAnbid servico : CategoriaAnbid.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
