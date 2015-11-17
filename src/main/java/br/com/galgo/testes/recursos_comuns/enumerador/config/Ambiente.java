package br.com.galgo.testes.recursos_comuns.enumerador.config;

import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesWS;

public enum Ambiente {

	PRODUCAO(
			ConstantesTestes.URL_PROD,//
			ConstantesTestes.CAMINHO_EVIDENCIA_PROD,//
			ConstantesTestes.CAMINHO_USUARIOS_PROD,//
			ConstantesTestes.DESCRICAO_PROD,
			ConstantesWS.PATH_PROJETO_WS_PRODUCAO), //

	HOMOLOGACAO(
			ConstantesTestes.URL_HOMOL,//
			ConstantesTestes.CAMINHO_EVIDENCIA_HOMOL,
			ConstantesTestes.CAMINHO_USUARIOS_HOMOL,//
			ConstantesTestes.DESCRICAO_HOMOL,
			ConstantesWS.PATH_PROJETO_WS_HOMOLOGACAO);

	private String url;
	private String caminhoEvidencia;
	private String caminhoArqAutenticacao;
	private String desc;
	private String pathProjetoWs;

	Ambiente(String url, String caminhoEvidencia,
			String caminhoArqAutenticacao, String desc, String pathProjetoWs) {
		this.url = url;
		this.caminhoEvidencia = caminhoEvidencia;
		this.caminhoArqAutenticacao = caminhoArqAutenticacao;
		this.desc = desc;
		this.pathProjetoWs = pathProjetoWs;
	}

	public String getUrl() {
		return url;
	}

	public String getDesc() {
		return desc;
	}

	public String getCaminhoEvidencia() {
		return caminhoEvidencia;
	}

	public String getCaminhoArqAutenticacao() {
		return caminhoArqAutenticacao;
	}

	public void setCaminhoArqAutenticacao(String caminhoArqAutenticacao) {
		this.caminhoArqAutenticacao = caminhoArqAutenticacao;
	}

	public String getPathProjetoWs() {
		return pathProjetoWs;
	}

}
