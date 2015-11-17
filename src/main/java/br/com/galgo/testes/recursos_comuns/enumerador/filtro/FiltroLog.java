package br.com.galgo.testes.recursos_comuns.enumerador.filtro;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;


public enum FiltroLog{

	TIPO(TipoCampo.SELECT), //
	DATA_INICIAL(TipoCampo.INPUT), //
	HORA_INICIAL(TipoCampo.INPUT), //
	DATA_FINAL(TipoCampo.INPUT), //
	HORA_FINAL(TipoCampo.INPUT), //
	ENTIDADE(TipoCampo.BUSCA), //
	USUARIO(TipoCampo.BUSCA), //
	GRUPO_DE_OPERACAO(TipoCampo.SELECT), //
	OPERACAO(TipoCampo.SELECT);

	private TipoCampo tipoCampo;

	FiltroLog(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

}
