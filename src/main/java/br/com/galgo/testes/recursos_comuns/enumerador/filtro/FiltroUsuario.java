package br.com.galgo.testes.recursos_comuns.enumerador.filtro;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;


public enum FiltroUsuario{

	TIPO_PESSOA(TipoCampo.RADIO), //
	LOGIN_USUARIO(TipoCampo.INPUT);

	private TipoCampo tipoCampo;

	FiltroUsuario(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

}
