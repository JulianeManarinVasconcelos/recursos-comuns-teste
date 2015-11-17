package br.com.galgo.testes.recursos_comuns.enumerador.filtro;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;


public enum FiltroPLCota {

	ENTIDADE(TipoCampo.BUSCA), //
	FUNDO_OU_CARTEIRA(TipoCampo.BUSCA), //
	DATA_INICIAL_INFO(TipoCampo.INPUT), //
	DATA_FINAL_INFO(TipoCampo.INPUT), //
	DATA_INICIAL_ENVIO(TipoCampo.INPUT), //
	DATA_FINAL_ENVIO(TipoCampo.INPUT), //
	HORA_INICIAL_ENVIO(TipoCampo.INPUT), //
	MIN_INICIAL_ENVIO(TipoCampo.INPUT), //
	HORA_FINAL_ENVIO(TipoCampo.INPUT), //
	MIN_FINAL_ENVIO(TipoCampo.INPUT), //
	STATUS_INFO(TipoCampo.SELECT);

	private TipoCampo tipoCampo;

	FiltroPLCota(TipoCampo tipoCampo) {
		this.tipoCampo = tipoCampo;
	}

	public TipoCampo getTipoCampo() {
		return tipoCampo;
	}

}
