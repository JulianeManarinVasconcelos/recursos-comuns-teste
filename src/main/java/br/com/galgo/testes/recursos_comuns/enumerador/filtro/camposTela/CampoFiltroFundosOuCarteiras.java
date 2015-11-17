package br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroFundosOuCarteira;

public enum CampoFiltroFundosOuCarteiras {

	REGISTRO_FUNDO(FiltroFundosOuCarteira.TIPO_REGISTRO,//
			"icBuscaFundo",//
			TipoAtributo.ID,//
			"Fundo de Investimento"), //
	REGISTRO_CARTEIRA(FiltroFundosOuCarteira.TIPO_REGISTRO,//
			"icBuscaCarteira",//
			TipoAtributo.ID,//
			"Carteira Administrada"), //
	STATUS_ATIVO_MERCADO(
			FiltroFundosOuCarteira.STATUS_MERCADO,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[6]/td[2]/select",//
			TipoAtributo.XPATH,//
			"6"), //
	STATUS_ATIVO_ANBIMA(FiltroFundosOuCarteira.STATUS_MERCADO,//
			"listaIdStatusANBID",//
			TipoAtributo.NAME,//
			"5"), //
	RAZAO_SOCIAL(
			FiltroFundosOuCarteira.RAZAO_SOCIAL,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[10]/td[2]/input",//
			TipoAtributo.XPATH,//
			"Razão Social"), //
	CNPJ(
			FiltroFundosOuCarteira.CNPJ,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[14]/td[2]/table/tbody/tr/td[1]/input",//
			TipoAtributo.XPATH,//
			"CNPJ"), //
	SIGLA(
			FiltroFundosOuCarteira.SIGLA,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[20]/td[2]/input",//
			TipoAtributo.XPATH,//
			"Sigla"), //
	COD_STI(
			FiltroFundosOuCarteira.COD_STI,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/div[2]/table/tbody/tr[5]/td[2]/table/tbody/tr/td[1]/input",//
			TipoAtributo.XPATH,//
			"Codigo STI");

	private FiltroFundosOuCarteira filtro;
	private String campo;
	private TipoAtributo tipoAtributo;
	private String descricao;

	CampoFiltroFundosOuCarteiras(FiltroFundosOuCarteira filtro, String campo,
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

	public FiltroFundosOuCarteira getFiltro() {
		return filtro;
	}

	public String getCampo() {
		return campo;
	}

}
