package br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroFundos;

public enum CampoFiltroFundos {

	BUSCA_FUNDO_SERIE_COTA(FiltroFundos.FUNDO_SERIE_COTA,// 
			"input[type='image']",// 
			TipoAtributo.CSS,// 
			""), //
	HISTORICO_SIM(FiltroFundos.HISTORICO,// 
			"historicoSIM",// 
			TipoAtributo.ID,//
			""), //
	HISTORICO_NAO(FiltroFundos.HISTORICO,// 
			"historicoNAO",// 
			TipoAtributo.ID,//
			"");

	private FiltroFundos filtro;
	private String campo;
	private TipoAtributo tipoAtributo;
	private String descricao;

	CampoFiltroFundos(FiltroFundos filtro, String campo,
			TipoAtributo tipoAtributo, String descricao) {
		this.filtro = filtro;
		this.campo = campo;
		this.tipoAtributo = tipoAtributo;
		this.descricao = descricao;
	}

	public TipoAtributo getTipoAtributo() {
		return tipoAtributo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public FiltroFundos getFiltro() {
		return filtro;
	}

	public String getCampo() {
		return campo;
	}

}
