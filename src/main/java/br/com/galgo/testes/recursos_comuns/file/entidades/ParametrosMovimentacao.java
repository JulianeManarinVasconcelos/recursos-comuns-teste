package br.com.galgo.testes.recursos_comuns.file.entidades;

public class ParametrosMovimentacao {

	private String indicadorPrazoConversaoCotas;
	private String prazoConversaoCotasAplicacao;
	private String dataInicioVigPrazoConvCotasAplic;
	private boolean estabeleceValoresMinimosMovimentacao;
	private String aplicacaoInicial;
	private String aplicacaoAdicional;
	private String indicadorPrazoConversaoResgate;
	private String prazoConversaoResgate;
	private String dataInicioVigPrazoConvResg;
	private String indicadorPrazoPagtoResgate;
	private String prazoPrazoPagtoResgate;
	private String dataInicioVigPrazoPagtoResg;
	private boolean possuiPagtoResgate;
	private String dataInicioVigPossuiPagtoResg;
	private String regraPagtoResgate;
	private String dataInicioVigRegraPagtoResg;
	private String carenciaInicial;
	private String carenciaCiclica;
	private String resgate;
	private String saldoMinimo;
	private boolean abertoCaptacao;
	private String dataAberturaCaptacao;
	private String dataFechamentoCaptacao;

	public ParametrosMovimentacao(String indicadorPrazoConversaoCotas,
			String prazoConversaoCotasAplicacao,
			boolean estabeleceValoresMinimosMovimentacao,
			String aplicacaoInicial, String aplicacaoAdicional,
			String indicadorPrazoConversaoResgate,
			String prazoConversaoResgate, String indicadorPrazoPagtoResgate,
			String prazoPrazoPagtoResgate, boolean possuiPagtoResgate,
			String regraPagtoResgate, String carenciaInicial,
			String carenciaCiclica, String resgate, String saldoMinimo,
			boolean abertoCaptacao, String dataAberturaCaptacao) {
		super();
		this.indicadorPrazoConversaoCotas = indicadorPrazoConversaoCotas;
		this.prazoConversaoCotasAplicacao = prazoConversaoCotasAplicacao;
		this.estabeleceValoresMinimosMovimentacao = estabeleceValoresMinimosMovimentacao;
		this.aplicacaoInicial = aplicacaoInicial;
		this.aplicacaoAdicional = aplicacaoAdicional;
		this.indicadorPrazoConversaoResgate = indicadorPrazoConversaoResgate;
		this.prazoConversaoResgate = prazoConversaoResgate;
		this.indicadorPrazoPagtoResgate = indicadorPrazoPagtoResgate;
		this.prazoPrazoPagtoResgate = prazoPrazoPagtoResgate;
		this.possuiPagtoResgate = possuiPagtoResgate;
		this.regraPagtoResgate = regraPagtoResgate;
		this.carenciaInicial = carenciaInicial;
		this.carenciaCiclica = carenciaCiclica;
		this.resgate = resgate;
		this.saldoMinimo = saldoMinimo;
		this.abertoCaptacao = abertoCaptacao;
		this.dataAberturaCaptacao = dataAberturaCaptacao;
	}

	public ParametrosMovimentacao(String indicadorPrazoConversaoCotas,
			String prazoConversaoCotasAplicacao,
			String dataInicioVigPrazoConvCotasAplic,
			boolean estabeleceValoresMinimosMovimentacao,
			String aplicacaoInicial, String aplicacaoAdicional,
			String indicadorPrazoConversaoResgate,
			String prazoConversaoResgate, String dataInicioVigPrazoConvResg,
			String indicadorPrazoPagtoResgate, String prazoPrazoPagtoResgate,
			String dataInicioVigPrazoPagtoResg, boolean possuiPagtoResgate,
			String dataInicioVigPossuiPagtoResg, String regraPagtoResgate,
			String dataInicioVigRegraPagtoResg, String carenciaInicial,
			String carenciaCiclica, String resgate, String saldoMinimo,
			boolean abertoCaptacao, String dataAberturaCaptacao,
			String dataFechamentoCaptacao) {
		super();
		this.indicadorPrazoConversaoCotas = indicadorPrazoConversaoCotas;
		this.prazoConversaoCotasAplicacao = prazoConversaoCotasAplicacao;
		this.dataInicioVigPrazoConvCotasAplic = dataInicioVigPrazoConvCotasAplic;
		this.estabeleceValoresMinimosMovimentacao = estabeleceValoresMinimosMovimentacao;
		this.aplicacaoInicial = aplicacaoInicial;
		this.aplicacaoAdicional = aplicacaoAdicional;
		this.indicadorPrazoConversaoResgate = indicadorPrazoConversaoResgate;
		this.prazoConversaoResgate = prazoConversaoResgate;
		this.dataInicioVigPrazoConvResg = dataInicioVigPrazoConvResg;
		this.indicadorPrazoPagtoResgate = indicadorPrazoPagtoResgate;
		this.prazoPrazoPagtoResgate = prazoPrazoPagtoResgate;
		this.dataInicioVigPrazoPagtoResg = dataInicioVigPrazoPagtoResg;
		this.possuiPagtoResgate = possuiPagtoResgate;
		this.dataInicioVigPossuiPagtoResg = dataInicioVigPossuiPagtoResg;
		this.regraPagtoResgate = regraPagtoResgate;
		this.dataInicioVigRegraPagtoResg = dataInicioVigRegraPagtoResg;
		this.carenciaInicial = carenciaInicial;
		this.carenciaCiclica = carenciaCiclica;
		this.resgate = resgate;
		this.saldoMinimo = saldoMinimo;
		this.abertoCaptacao = abertoCaptacao;
		this.dataAberturaCaptacao = dataAberturaCaptacao;
		this.dataFechamentoCaptacao = dataFechamentoCaptacao;
	}

	public String getIndicadorPrazoConversaoCotas() {
		return indicadorPrazoConversaoCotas;
	}

	public void setIndicadorPrazoConversaoCotas(
			String indicadorPrazoConversaoCotas) {
		this.indicadorPrazoConversaoCotas = indicadorPrazoConversaoCotas;
	}

	public String getPrazoConversaoCotasAplicacao() {
		return prazoConversaoCotasAplicacao;
	}

	public void setPrazoConversaoCotasAplicacao(
			String prazoConversaoCotasAplicacao) {
		this.prazoConversaoCotasAplicacao = prazoConversaoCotasAplicacao;
	}

	public boolean isEstabeleceValoresMinimosMovimentacao() {
		return estabeleceValoresMinimosMovimentacao;
	}

	public void setEstabeleceValoresMinimosMovimentacao(
			boolean estabeleceValoresMinimosMovimentacao) {
		this.estabeleceValoresMinimosMovimentacao = estabeleceValoresMinimosMovimentacao;
	}

	public String getAplicacaoInicial() {
		return aplicacaoInicial;
	}

	public void setAplicacaoInicial(String aplicacaoInicial) {
		this.aplicacaoInicial = aplicacaoInicial;
	}

	public String getAplicacaoAdicional() {
		return aplicacaoAdicional;
	}

	public void setAplicacaoAdicional(String aplicacaoAdicional) {
		this.aplicacaoAdicional = aplicacaoAdicional;
	}

	public String getIndicadorPrazoConversaoResgate() {
		return indicadorPrazoConversaoResgate;
	}

	public void setIndicadorPrazoConversaoResgate(
			String indicadorPrazoConversaoResgate) {
		this.indicadorPrazoConversaoResgate = indicadorPrazoConversaoResgate;
	}

	public String getPrazoConversaoResgate() {
		return prazoConversaoResgate;
	}

	public void setPrazoConversaoResgate(String prazoConversaoResgate) {
		this.prazoConversaoResgate = prazoConversaoResgate;
	}

	public String getIndicadorPrazoPagtoResgate() {
		return indicadorPrazoPagtoResgate;
	}

	public void setIndicadorPrazoPagtoResgate(String indicadorPrazoPagtoResgate) {
		this.indicadorPrazoPagtoResgate = indicadorPrazoPagtoResgate;
	}

	public String getPrazoPrazoPagtoResgate() {
		return prazoPrazoPagtoResgate;
	}

	public void setPrazoPrazoPagtoResgate(String prazoPrazoPagtoResgate) {
		this.prazoPrazoPagtoResgate = prazoPrazoPagtoResgate;
	}

	public boolean isPossuiPagtoResgate() {
		return possuiPagtoResgate;
	}

	public void setPossuiPagtoResgate(boolean possuiPagtoResgate) {
		this.possuiPagtoResgate = possuiPagtoResgate;
	}

	public String getRegraPagtoResgate() {
		return regraPagtoResgate;
	}

	public void setRegraPagtoResgate(String regraPagtoResgate) {
		this.regraPagtoResgate = regraPagtoResgate;
	}

	public String getCarenciaInicial() {
		return carenciaInicial;
	}

	public void setCarenciaInicial(String carenciaInicial) {
		this.carenciaInicial = carenciaInicial;
	}

	public String getCarenciaCiclica() {
		return carenciaCiclica;
	}

	public void setCarenciaCiclica(String carenciaCiclica) {
		this.carenciaCiclica = carenciaCiclica;
	}

	public String getResgate() {
		return resgate;
	}

	public void setResgate(String resgate) {
		this.resgate = resgate;
	}

	public String getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(String saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	public boolean isAbertoCaptacao() {
		return abertoCaptacao;
	}

	public void setAbertoCaptacao(boolean abertoCaptacao) {
		this.abertoCaptacao = abertoCaptacao;
	}

	public String getDataAberturaCaptacao() {
		return dataAberturaCaptacao;
	}

	public void setDataAberturaCaptacao(String dataAberturaCaptacao) {
		this.dataAberturaCaptacao = dataAberturaCaptacao;
	}

	public String getDataInicioVigPrazoConvCotasAplic() {
		return dataInicioVigPrazoConvCotasAplic;
	}

	public void setDataInicioVigPrazoConvCotasAplic(
			String dataInicioVigPrazoConvCotasAplic) {
		this.dataInicioVigPrazoConvCotasAplic = dataInicioVigPrazoConvCotasAplic;
	}

	public String getDataInicioVigPrazoConvResg() {
		return dataInicioVigPrazoConvResg;
	}

	public void setDataInicioVigPrazoConvResg(String dataInicioVigPrazoConvResg) {
		this.dataInicioVigPrazoConvResg = dataInicioVigPrazoConvResg;
	}

	public String getDataInicioVigPrazoPagtoResg() {
		return dataInicioVigPrazoPagtoResg;
	}

	public void setDataInicioVigPrazoPagtoResg(
			String dataInicioVigPrazoPagtoResg) {
		this.dataInicioVigPrazoPagtoResg = dataInicioVigPrazoPagtoResg;
	}

	public String getDataInicioVigPossuiPagtoResg() {
		return dataInicioVigPossuiPagtoResg;
	}

	public void setDataInicioVigPossuiPagtoResg(
			String dataInicioVigPossuiPagtoResg) {
		this.dataInicioVigPossuiPagtoResg = dataInicioVigPossuiPagtoResg;
	}

	public String getDataInicioVigRegraPagtoResg() {
		return dataInicioVigRegraPagtoResg;
	}

	public void setDataInicioVigRegraPagtoResg(
			String dataInicioVigRegraPagtoResg) {
		this.dataInicioVigRegraPagtoResg = dataInicioVigRegraPagtoResg;
	}

	public String getDataFechamentoCaptacao() {
		return dataFechamentoCaptacao;
	}

	public void setDataFechamentoCaptacao(String dataFechamentoCaptacao) {
		this.dataFechamentoCaptacao = dataFechamentoCaptacao;
	}

}
