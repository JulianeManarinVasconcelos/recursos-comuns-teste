package br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroPLCota;

public enum CampoFiltroExtrato {

	BUSCA_COTISTA(FiltroPLCota.FUNDO_OU_CARTEIRA,//
			"buscarCotista", //
			TipoAtributo.ID, //
			""), //
	BUSCA_FUNDO_OU_CARTEIRA(FiltroPLCota.FUNDO_OU_CARTEIRA,//
			"buscarRegistroInvestimento", //
			TipoAtributo.ID,//
			""), //

	INPUT_DATA_INICIAL_INFO(FiltroPLCota.DATA_INICIAL_INFO,//
			"dataBaseInicial",//
			TipoAtributo.ID,//
			""), //
	INPUT_DATA_FINAL_INFO(
			FiltroPLCota.DATA_FINAL_INFO,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div/div[4]/table/tbody/tr[1]/td/table/tbody/tr[5]/td[2]/input",//
			TipoAtributo.ID,//
			"");

	private FiltroPLCota filtro;
	private String campo;
	private TipoAtributo tipoAtributo;
	private String descricao;

	CampoFiltroExtrato(FiltroPLCota filtro, String campo,
			TipoAtributo tipoAtributo, String descricao) {
		this.filtro = filtro;
		this.campo = campo;
		this.tipoAtributo = tipoAtributo;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public FiltroPLCota getFiltro() {
		return filtro;
	}

	public String getCampo() {
		return campo;
	}

	public TipoAtributo getTipoAtributo() {
		return tipoAtributo;
	}

}
