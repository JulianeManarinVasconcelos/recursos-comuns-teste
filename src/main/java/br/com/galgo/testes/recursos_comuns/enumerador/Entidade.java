package br.com.galgo.testes.recursos_comuns.enumerador;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.Papel;

public enum Entidade {

	AUTORREG_PROD("ANBIMA", Ambiente.PRODUCAO, Papel.AUTO_REGULADOR), //
	AUTORREG_HOMOL("ANBIMA", Ambiente.HOMOLOGACAO, Papel.AUTO_REGULADOR), //
	;

	private String descricao;
	private Ambiente ambiente;
	private Papel papel;

	private Entidade(String descricao, Ambiente ambiente, Papel papel) {
		this.descricao = descricao;
		this.ambiente = ambiente;
		this.papel = papel;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Papel getPapel() {
		return papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public static Entidade fromPapel(Ambiente ambiente, Papel papel) {
		for (Entidade entidade : Entidade.values()) {
			if (entidade.getAmbiente() == ambiente
					&& entidade.getPapel() == papel) {
				return entidade;
			}
		}
		return null;
	}

}
