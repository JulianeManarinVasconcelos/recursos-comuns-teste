package br.com.galgo.testes.recursos_comuns.enumerador.filtro;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;


public enum FiltroFundos {

	FUNDO_SERIE_COTA(TipoCampo.BUSCA), //
	HISTORICO(TipoCampo.RADIO);

	private TipoCampo tipoCampo;

	FiltroFundos(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

}
