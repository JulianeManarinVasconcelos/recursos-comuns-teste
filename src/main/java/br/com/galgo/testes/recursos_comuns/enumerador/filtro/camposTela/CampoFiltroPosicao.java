package br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroPLCota;

public enum CampoFiltroPosicao {

	BUSCA_FUNDO_OU_CARTEIRA(
			FiltroPLCota.FUNDO_OU_CARTEIRA,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[1]/fieldset/ol/li[1]/fieldset/ol/li[1]/img[2]", //
			TipoAtributo.XPATH,//
			""), //

	INPUT_DATA_POSICAO(
			FiltroPLCota.DATA_INICIAL_INFO,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[1]/fieldset/ol/li[1]/fieldset/ol/li[2]/input",//
			TipoAtributo.XPATH,//
			"");

	private FiltroPLCota filtro;
	private String campo;
	private TipoAtributo tipoAtributo;
	private String descricao;

	CampoFiltroPosicao(FiltroPLCota filtro, String campo,
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
