package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum FocoAtuacao {

	VAZIO("null", ""), //
	NAO("186", "NÃO");

	private String value;
	private String desc;

	FocoAtuacao(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static FocoAtuacao fromDesc(String desc) {
		for (FocoAtuacao servico : FocoAtuacao.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static FocoAtuacao fromValue(String value) {
		for (FocoAtuacao servico : FocoAtuacao.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
