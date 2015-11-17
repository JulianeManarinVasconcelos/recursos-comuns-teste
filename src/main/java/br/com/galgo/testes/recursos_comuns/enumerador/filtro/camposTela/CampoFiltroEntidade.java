package br.com.galgo.testes.recursos_comuns.enumerador.filtro.camposTela;

import br.com.galgo.testes.recursos_comuns.enumerador.filtro.FiltroEntidade;

public enum CampoFiltroEntidade {

	RADIO_PF(FiltroEntidade.TIPO_ENTIDADE, "radio_pf", "Pessoa Física"), //
	RADIO_PJ(
			FiltroEntidade.TIPO_ENTIDADE,
			"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[1]/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/input",
			"Pessoa Jurídica"), //
	STATUS_ATIVO(FiltroEntidade.STATUS, "status", "ATIVO"), //
	STATUS_BLOQUEADO(FiltroEntidade.STATUS, "status", "BLOQUEADO"), //
	STATUS_INATIVO(FiltroEntidade.STATUS, "status", "INATIVO"), //
	PAIS_ORIGEM_DEFAULT(FiltroEntidade.PAIS_ORIGEM, "paisOrigem", "BRASIL"), //
	INPUT_RAZAO_SOCIAL(FiltroEntidade.RAZAO_SOCIAL, "input_razao_social", ""), //
	INPUT_NOME_FANTASIA(FiltroEntidade.NOME_FANTASIA, "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[1]/tbody/tr[5]/td/table/tbody/tr[2]/td[2]/input", ""), //
	INPUT_CNPJ(FiltroEntidade.CNPJ, "input_cnpj", ""), //
	INPUT_EMPRESA_ESTRANGEIRA(FiltroEntidade.EMP_ESTRANGEIRA,
			"input_empresa_estrangeira", ""), //
	EMPRESA_PRINCIPAL(FiltroEntidade.TIPO_VINCULO, "tipoVinculo",
			"EMPRESA PRINCIPAL"), //
	EMPRESA_VINCULADA(FiltroEntidade.TIPO_VINCULO, "tipoVinculo",
			"EMPRESA VINCULADA"), //
	NAO_SE_APLICA(FiltroEntidade.TIPO_VINCULO, "tipoVinculo", "NãO SE APLICA"), //
	INSTITUICAO_FINANCEIRA(FiltroEntidade.CATEGORIA, "tipoVinculo",
			"INSTITUIÇÂO FINANCEIRA"), //
	INSTITUICAO_NAO_FINANCEIRA(FiltroEntidade.CATEGORIA, "categoria",
			"INSTITUIÇÃO NÃO FINANCEIRA"), //
	ORGANIZACAO(FiltroEntidade.CATEGORIA, "categoria", "ORGANIZAÇÃO"), //
	ASSOCIACAO(FiltroEntidade.CATEGORIA, "categoria", "ASSOCIAÇÃO"), //
	;

	private FiltroEntidade filtro;
	private String campo;
	private String descricao;

	CampoFiltroEntidade(FiltroEntidade filtro, String campo, String descricao) {
		this.filtro = filtro;
		this.campo = campo;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public FiltroEntidade getFiltro() {
		return filtro;
	}

	public String getCampo() {
		return campo;
	}

}
