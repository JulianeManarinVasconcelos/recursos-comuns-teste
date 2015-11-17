package br.com.galgo.testes.recursos_comuns.enumerador.config;

public enum TipoAtributo {

	ID("id"), //
	NAME("name"), //
	XPATH("xpath"),
	CSS("css");

	private String descricao;

	TipoAtributo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
