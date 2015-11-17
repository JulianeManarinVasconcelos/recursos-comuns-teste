package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum ClassificacaoCVM {

	VAZIO("null", ""), //
	ACOES("1", "AÇÕES"), //
	CAMBIAL("2", "CAMBIAL"), //
	CURTO_PRAZO("3", "CURTO PRAZO"), //
	DIVIDA_EXTERNA("4", "DÍVIDA EXTERNA"), //
	APOSENTADORIA_PROGRAMADA_INDIVIDUAL("8",
			"FUNDO DE APOSENTADORIA PROGRAMADA INDIVIDUAL"), //
	CONVERSÃO_CAPITAL_ESTRANGEIRO("9", "FUNDO DE CONVERSÃO CAPITAL ESTRANGEIRO"), //
	FINANCIAMENTO_DA_INDUSTRIA_CINEMATOGRÁFICA_NACIONAL("10",
			"FUNDO DE FINANCIAMENTO DA INDÚSTRIA CINEMATOGRÁFICA NACIONAL"), //
	INVESTIMENTO_EM_DIREITOS_CREDITÓRIOS("12",
			"FUNDO DE INVESTIMENTO EM DIREITOS CREDITÓRIOS"), //
	DIREITOS_CREDITÓRIOS_NÃO_PADRONIZADO("14",
			"FUNDO DE INVESTIMENTO EM DIREITOS CREDITÓRIOS NÃO PADRONIZADO"), //
	DIREITOS_CREDITÓRIOS("13",
			"FUNDO DE INVESTIMENTO EM DIREITOS CREDITÓRIOS - PROJ DE INTERESSE SOCIAL"), //
	INDICE_DE_MERCADO("15", "FUNDO DE INVESTIMENTO EM ÍNDICE DE MERCADO"), //
	IMOBILIARIO("17", "FUNDO DE INVESTIMENTO IMOBILIÁRIO"), //
	CULTURAIS_E_ARTISTICOS("11",
			"FUNDO DE INVESTIMENTOS CULTURAIS E ARTÍSTICOS"), //
	PARTICIPACOES("16", "FUNDO EM PARTICIPAÇÕES"), //
	MUTUO_DE_AÇÕES_INCENTIVADAS("18", "FUNDO MÚTUO DE AÇÕES INCENTIVADAS"), //
	MUTUO_DE_INVESTIMENTO_EM_EMPRESAS_EMERGENTES("19",
			"FUNDO MÚTUO DE INVESTIMENTO EM EMPRESAS EMERGENTES"), //
	MUTUO_DE_PRIVATIZAÇÃO_FGTS("20", "FUNDO MÚTUO DE PRIVATIZAÇÃO FGTS"), //
	MUTUO_DE_PRIVATIZAÇÃO_FGTS_CARTEIRA_LIVRE("21",
			"FUNDO MÚTUO DE PRIVATIZAÇÃO FGTS - CARTEIRA LIVRE"), //
	MULTIMERCADO("5", "MULTIMERCADO"), //
	NAO_SE_APLICA("22", "NÃO SE APLICA"), //
	REFERENCIADO("6", "REFERENCIADO"), //
	RENDA_FIXA("7", "RENDA FIXA");//

	private String value;
	private String desc;

	ClassificacaoCVM(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static ClassificacaoCVM fromDesc(String desc) {
		for (ClassificacaoCVM servico : ClassificacaoCVM.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static ClassificacaoCVM fromValue(String value) {
		for (ClassificacaoCVM servico : ClassificacaoCVM.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
