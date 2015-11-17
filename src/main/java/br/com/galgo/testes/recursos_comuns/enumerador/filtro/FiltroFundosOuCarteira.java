package br.com.galgo.testes.recursos_comuns.enumerador.filtro;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;

public enum FiltroFundosOuCarteira {

	TIPO_REGISTRO(TipoCampo.RADIO), //
	STATUS_MERCADO(TipoCampo.SELECT), //
	RAZAO_SOCIAL(TipoCampo.INPUT), //
	COD_STI(TipoCampo.INPUT), //
	CNPJ(TipoCampo.INPUT),//
	SIGLA(TipoCampo.INPUT)//
	;

	private TipoCampo tipoCampo;

	FiltroFundosOuCarteira(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

}
