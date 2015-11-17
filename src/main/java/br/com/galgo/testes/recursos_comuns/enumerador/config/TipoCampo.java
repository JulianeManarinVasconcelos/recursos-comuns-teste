package br.com.galgo.testes.recursos_comuns.enumerador.config;

public enum TipoCampo {

	RADIO("radio"), //
	SELECT("select"), //
	INPUT("input"),
	BUSCA("busca"),
	BOTAO("button");

	private String descricao;

	TipoCampo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
