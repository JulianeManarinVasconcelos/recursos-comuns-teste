package br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroUsuario;

public enum CampoFiltroUsuario {

	RADIO_PESSOA_FISICA(
			FiltroUsuario.TIPO_PESSOA,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[1]/tbody/tr[1]/td[2]/input",//
			TipoAtributo.XPATH,//
			"Pessoa Física"), //
	RADIO_SISTEMA_EXTERNO(
			FiltroUsuario.TIPO_PESSOA,
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[1]/tbody/tr[1]/td[4]/input",//
			TipoAtributo.XPATH,//
			"Sistema Externo"), //
	INPUT_LOGIN_USUARIO(
			FiltroUsuario.LOGIN_USUARIO,//
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[1]/tbody/tr[5]/td[2]/input", //
			TipoAtributo.XPATH,//
			"");

	private FiltroUsuario filtro;
	private String campo;
	private TipoAtributo tipoAtributo;
	private String descricao;

	CampoFiltroUsuario(FiltroUsuario filtro, String campo,
			TipoAtributo tipoAtributo, String descricao) {
		this.filtro = filtro;
		this.campo = campo;
		this.tipoAtributo = tipoAtributo;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public TipoAtributo getTipoAtributo() {
		return tipoAtributo;
	}

	public FiltroUsuario getFiltro() {
		return filtro;
	}

	public String getCampo() {
		return campo;
	}

}
