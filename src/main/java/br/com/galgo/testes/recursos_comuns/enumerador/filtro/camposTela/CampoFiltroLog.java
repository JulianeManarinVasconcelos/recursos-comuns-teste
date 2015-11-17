package br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela;

import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoAtributo;
import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroLog;

public enum CampoFiltroLog {

	TIPO_TODOS(FiltroLog.TIPO, "tiposLog", TipoAtributo.ID, "TODOS"), //
	TIPO_ERRO(FiltroLog.TIPO, "tiposLog", TipoAtributo.ID, "ERRO"), //
	TIPO_INFORMATIVO(FiltroLog.TIPO, "tiposLog", TipoAtributo.ID, "INFORMATIVO"), //
	INPUT_DATA_INICIAL(
			FiltroLog.DATA_INICIAL,
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[1]/table/tbody/tr[2]/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/input",
			TipoAtributo.XPATH, ""), //
	INPUT_HORA_INICIAL(FiltroLog.HORA_INICIAL, "horaInicial", TipoAtributo.ID,
			""), //
	INPUT_DATA_FINAL(FiltroLog.DATA_FINAL, "dataFinal", TipoAtributo.ID, ""), //
	INPUT_HORA_FINAL(FiltroLog.HORA_FINAL, "horaFinal", TipoAtributo.ID, ""), //
	BUSCA_ENTIDADE(FiltroLog.ENTIDADE, "(//input[@name=''])[1]",
			TipoAtributo.XPATH, ""), //
	BUSCA_USUARIO(
			FiltroLog.USUARIO,
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[1]/table/tbody/tr[5]/td[2]/table/tbody/tr/td[2]/input",
			TipoAtributo.XPATH, ""), //
	AJUDA_ON_LINE(FiltroLog.GRUPO_DE_OPERACAO, "servicos", TipoAtributo.ID,
			"AJUDA ON-LINE"), //
	CADASTROS_BASICOS_E_PARAMETROS(FiltroLog.GRUPO_DE_OPERACAO, "servicos",
			TipoAtributo.ID, "CADASTROS BASICOS E PARAMETROS"), //
	COMPROMISSOS(FiltroLog.GRUPO_DE_OPERACAO, "servicos", TipoAtributo.ID,
			"COMPROMISSOS"), //
	ENTIDADES(FiltroLog.GRUPO_DE_OPERACAO, "servicos", TipoAtributo.ID,
			"ENTIDADES"), //
	EXTRATO_CONCILIACAO_COTAS(FiltroLog.GRUPO_DE_OPERACAO, "servicos",
			TipoAtributo.ID, "EXTRATO DE CONCILIACAO DE COTAS"), //
	INFORMACOES_ANBIMA(FiltroLog.GRUPO_DE_OPERACAO, "servicos",
			TipoAtributo.ID, "INFORMACOES ANBIMA"), //
	PL_COTA(FiltroLog.GRUPO_DE_OPERACAO, "servicos", TipoAtributo.ID, "PL/COTA"), //
	POSICAO_ATIVOS_CARTEIRA(FiltroLog.GRUPO_DE_OPERACAO, "servicos",
			TipoAtributo.ID, "POSICAO DE ATIVOS DA CARTEIRA"), //
	REGISTRO_CARTEIRAS_ADMINISTRADAS(FiltroLog.GRUPO_DE_OPERACAO, "servicos",
			TipoAtributo.ID, "REGISTRO DE CARTEIRAS ADMINISTRADAS"), //
	REGISTRO_FUNDOS_INVESTIMENTO(FiltroLog.GRUPO_DE_OPERACAO, "servicos",
			TipoAtributo.ID, "REGISTRO DE FUNDOS DE INVESTIMENTO"), //
	REGISTRO_FUNDOS_CARTEIRAS_ADMINISTRADAS(FiltroLog.GRUPO_DE_OPERACAO,
			"servicos", TipoAtributo.ID,
			"REGISTRO DE FUNDOS E CARTEIRAS ADMINISTRADAS"), //
	SEGURANCA(FiltroLog.GRUPO_DE_OPERACAO, "servicos", TipoAtributo.ID,
			"SEGURANCA"), //
	TARIFAS(FiltroLog.GRUPO_DE_OPERACAO, "servicos", TipoAtributo.ID, "TARIFAS"), //
	;

	private FiltroLog filtro;
	private String campo;
	private TipoAtributo tipoAtributo;
	private String descricao;

	CampoFiltroLog(FiltroLog filtro, String campo, TipoAtributo tipoAtributo,
			String descricao) {
		this.filtro = filtro;
		this.campo = campo;
		this.tipoAtributo = tipoAtributo;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public FiltroLog getFiltro() {
		return filtro;
	}

	public String getCampo() {
		return campo;
	}

	public TipoAtributo getTipoAtributo() {
		return tipoAtributo;
	}

}
