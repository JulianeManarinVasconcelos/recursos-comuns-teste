package br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroPLCota;

public enum CampoFiltroPLCota {

	BUSCA_ENTIDADE(FiltroPLCota.ENTIDADE,//
			"buscarEntidade", //
			TipoAtributo.ID, //
			""), //
	BUSCA_FUNDO_OU_CARTEIRA(FiltroPLCota.FUNDO_OU_CARTEIRA,//
			"buscarFundoCarteira", //
			TipoAtributo.ID,//
			""), //

	INPUT_DATA_INICIAL_INFO(FiltroPLCota.DATA_INICIAL_INFO,//
			"dataInicioInformacao",//
			TipoAtributo.ID, ""), //
	INPUT_DATA_FINAL_INFO(FiltroPLCota.DATA_FINAL_INFO,//
			"dataFinalInformacao",//
			TipoAtributo.ID,//
			""), //

	INPUT_DATA_INICIAL_ENVIO(
			FiltroPLCota.DATA_INICIAL_ENVIO,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div/fieldset/ol/li[4]/fieldset/ol/li[1]/input", //
			TipoAtributo.XPATH,//
			""), //
	INPUT_DATA_FINAL_ENVIO(FiltroPLCota.DATA_FINAL_ENVIO, //
			"dataFinalEnvio",//
			TipoAtributo.ID, //
			""), //
	INPUT_HORA_INICIAL_ENVIO(FiltroPLCota.HORA_INICIAL_ENVIO,//
			"horaInicioEnvio", //
			TipoAtributo.ID,//
			""), //
	INPUT_MIN_INICIAL_ENVIO(FiltroPLCota.MIN_INICIAL_ENVIO,//
			"minutoInicioEnvio",//
			TipoAtributo.ID, //
			""), //
	INPUT_HORA_FINAL_ENVIO(FiltroPLCota.HORA_FINAL_ENVIO, //
			"horaFinalEnvio",//
			TipoAtributo.ID,//
			""), //
	INPUT_MIN_FINAL_ENVIO(FiltroPLCota.MIN_FINAL_ENVIO, //
			"minutoFinalEnvio",//
			TipoAtributo.ID, //
			""), //

	SELECT_STATUS_ENVIADA(
			FiltroPLCota.STATUS_INFO, //
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div/fieldset/ol/li[5]/select",//
			TipoAtributo.XPATH,//
			"ENVIO"), //
	SELECT_STATUS_REENVIADA(
			FiltroPLCota.STATUS_INFO, //
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div/fieldset/ol/li[5]/select",//
			TipoAtributo.XPATH,//
			"REENVIO"), //
	SELECT_STATUS_CANCEL_AUTO(
			FiltroPLCota.STATUS_INFO, //
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div/fieldset/ol/li[5]/select",//
			TipoAtributo.XPATH,//
			"CANCELAMENTO_AUTOMATICO"), //
	SELECT_STATUS_CANCEL_MANUAL(
			FiltroPLCota.STATUS_INFO,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div/fieldset/ol/li[5]/select",//
			TipoAtributo.XPATH,//
			"CANCELAMENTO_MANUAL"), //
	SELECT_STATUS_REJEITADA(
			FiltroPLCota.STATUS_INFO, //
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div/fieldset/ol/li[5]/select",//
			TipoAtributo.XPATH,//
			"REJEICAO");

	private FiltroPLCota filtro;
	private String campo;
	private TipoAtributo tipoAtributo;
	private String descricao;

	CampoFiltroPLCota(FiltroPLCota filtro, String campo,
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
