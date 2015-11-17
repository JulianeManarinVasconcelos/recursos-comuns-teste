package br.com.galgo.testes.recursos_comuns.file.entidades;

import java.util.List;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Indice;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PerfilTaxaAdministracao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PerioCobranca;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PeriodoCorrecao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PlBaseCalculoTaxaPerfor;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.TipoTaxa;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.UnidadeTaxa;

public class TaxasFundos {

	private String dataInicioVigTaxaAdmin;
	private PerfilTaxaAdministracao perfilTaxaAdminstracao;
	private UnidadeTaxa unidadeTaxaAdministracao;
	private String valorTaxaAdminstracao;
	private String plBaseCalculoTaxa;
	private String valorPiso;
	private Indice indiceCorrecao;
	private PeriodoCorrecao periodoCorrecao;
	private boolean aplicaOutrosFundos;
	private String taxaMaxima;
	private List<FaixasTaxas> faixasTaxas;
	private PerioCobranca perioCobrancaTaxaAdmin;
	private String infoAdicionaisTaxaNaoPadronizada;
	private String dataInicioVigTaxaPerformance;
	private boolean cobraTaxaPerformance;
	private List<TaxaPerformance> taxaPerformance;
	private String cupomTaxaPerformance;
	private PerioCobranca perioCobrancaTaxaPerfor;
	private PlBaseCalculoTaxaPerfor plBaseCalculoTaxaPerfor;
	private String diaUtilCalculoTaxaPerfor;
	private boolean linhaDagua;
	private boolean zeramentoPerformance;
	private String baseCalculoTaxaPerfor;
	private boolean ajustePerforCotista;
	private String infoAdicionaisTaxaPerfor;
	private String dataInicioVigTaxaEntrada;
	private TipoTaxa tipoTaxaEntrada;
	private String valorTaxaEntrada;
	private String infoAdicionaisTaxaEntrada;
	private String dataInicioVigTaxaSaida;
	private TipoTaxa tipoTaxaSaida;
	private String valorTaxaSaida;
	private String infoAdicionalTaxaSaida;

	public TaxasFundos(PerfilTaxaAdministracao perfilTaxaAdminstracao,
			UnidadeTaxa unidadeTaxaAdministracao, String valorTaxaAdminstracao,
			String plBaseCalculoTaxa, String valorPiso, Indice indiceCorrecao,
			PeriodoCorrecao periodoCorrecao, boolean aplicaOutrosFundos,
			String taxaMaxima, List<FaixasTaxas> faixasTaxas,
			PerioCobranca perioCobrancaTaxaAdmin,
			String infoAdicionaisTaxaNaoPadronizada,
			boolean cobraTaxaPerformance,
			List<TaxaPerformance> taxaPerformance, String cupomTaxaPerformance,
			PerioCobranca perioCobrancaTaxaPerfor,
			PlBaseCalculoTaxaPerfor plBaseCalculoTaxaPerfor,
			String diaUtilCalculoTaxaPerfor, boolean linhaDagua,
			boolean zeramentoPerformance, String baseCalculoTaxaPerfor,
			boolean ajustePerforCotista, String infoAdicionaisTaxaPerfor,
			TipoTaxa tipoTaxaEntrada, String valorTaxaEntrada,
			String infoAdicionaisTaxaEntrada, TipoTaxa tipoTaxaSaida,
			String valorTaxaSaida, String infoAdicionalTaxaSaida) {
		super();
		this.perfilTaxaAdminstracao = perfilTaxaAdminstracao;
		this.unidadeTaxaAdministracao = unidadeTaxaAdministracao;
		this.valorTaxaAdminstracao = valorTaxaAdminstracao;
		this.plBaseCalculoTaxa = plBaseCalculoTaxa;
		this.valorPiso = valorPiso;
		this.indiceCorrecao = indiceCorrecao;
		this.periodoCorrecao = periodoCorrecao;
		this.aplicaOutrosFundos = aplicaOutrosFundos;
		this.taxaMaxima = taxaMaxima;
		this.faixasTaxas = faixasTaxas;
		this.perioCobrancaTaxaAdmin = perioCobrancaTaxaAdmin;
		this.infoAdicionaisTaxaNaoPadronizada = infoAdicionaisTaxaNaoPadronizada;
		this.cobraTaxaPerformance = cobraTaxaPerformance;
		this.taxaPerformance = taxaPerformance;
		this.cupomTaxaPerformance = cupomTaxaPerformance;
		this.perioCobrancaTaxaPerfor = perioCobrancaTaxaPerfor;
		this.plBaseCalculoTaxaPerfor = plBaseCalculoTaxaPerfor;
		this.diaUtilCalculoTaxaPerfor = diaUtilCalculoTaxaPerfor;
		this.linhaDagua = linhaDagua;
		this.zeramentoPerformance = zeramentoPerformance;
		this.baseCalculoTaxaPerfor = baseCalculoTaxaPerfor;
		this.ajustePerforCotista = ajustePerforCotista;
		this.infoAdicionaisTaxaPerfor = infoAdicionaisTaxaPerfor;
		this.tipoTaxaEntrada = tipoTaxaEntrada;
		this.valorTaxaEntrada = valorTaxaEntrada;
		this.infoAdicionaisTaxaEntrada = infoAdicionaisTaxaEntrada;
		this.tipoTaxaSaida = tipoTaxaSaida;
		this.valorTaxaSaida = valorTaxaSaida;
		this.infoAdicionalTaxaSaida = infoAdicionalTaxaSaida;
	}

	public TaxasFundos(String dataInicioVigTaxaAdmin,
			PerfilTaxaAdministracao perfilTaxaAdminstracao,
			UnidadeTaxa unidadeTaxaAdministracao, String valorTaxaAdminstracao,
			String plBaseCalculoTaxa, String valorPiso, Indice indiceCorrecao,
			PeriodoCorrecao periodoCorrecao, boolean aplicaOutrosFundos,
			String taxaMaxima, List<FaixasTaxas> faixasTaxas,
			PerioCobranca perioCobrancaTaxaAdmin,
			String infoAdicionaisTaxaNaoPadronizada,
			String dataInicioVigTaxaPerformance, boolean cobraTaxaPerformance,
			List<TaxaPerformance> taxaPerformance, String cupomTaxaPerformance,
			PerioCobranca perioCobrancaTaxaPerfor,
			PlBaseCalculoTaxaPerfor plBaseCalculoTaxaPerfor,
			String diaUtilCalculoTaxaPerfor, boolean linhaDagua,
			boolean zeramentoPerformance, String baseCalculoTaxaPerfor,
			boolean ajustePerforCotista, String infoAdicionaisTaxaPerfor,
			String dataInicioVigTaxaEntrada, TipoTaxa tipoTaxaEntrada,
			String valorTaxaEntrada, String infoAdicionaisTaxaEntrada,
			String dataInicioVigTaxaSaida, TipoTaxa tipoTaxaSaida,
			String valorTaxaSaida, String infoAdicionalTaxaSaida) {
		super();
		this.dataInicioVigTaxaAdmin = dataInicioVigTaxaAdmin;
		this.perfilTaxaAdminstracao = perfilTaxaAdminstracao;
		this.unidadeTaxaAdministracao = unidadeTaxaAdministracao;
		this.valorTaxaAdminstracao = valorTaxaAdminstracao;
		this.plBaseCalculoTaxa = plBaseCalculoTaxa;
		this.valorPiso = valorPiso;
		this.indiceCorrecao = indiceCorrecao;
		this.periodoCorrecao = periodoCorrecao;
		this.aplicaOutrosFundos = aplicaOutrosFundos;
		this.taxaMaxima = taxaMaxima;
		this.faixasTaxas = faixasTaxas;
		this.perioCobrancaTaxaAdmin = perioCobrancaTaxaAdmin;
		this.infoAdicionaisTaxaNaoPadronizada = infoAdicionaisTaxaNaoPadronizada;
		this.dataInicioVigTaxaPerformance = dataInicioVigTaxaPerformance;
		this.cobraTaxaPerformance = cobraTaxaPerformance;
		this.taxaPerformance = taxaPerformance;
		this.cupomTaxaPerformance = cupomTaxaPerformance;
		this.perioCobrancaTaxaPerfor = perioCobrancaTaxaPerfor;
		this.plBaseCalculoTaxaPerfor = plBaseCalculoTaxaPerfor;
		this.diaUtilCalculoTaxaPerfor = diaUtilCalculoTaxaPerfor;
		this.linhaDagua = linhaDagua;
		this.zeramentoPerformance = zeramentoPerformance;
		this.baseCalculoTaxaPerfor = baseCalculoTaxaPerfor;
		this.ajustePerforCotista = ajustePerforCotista;
		this.infoAdicionaisTaxaPerfor = infoAdicionaisTaxaPerfor;
		this.dataInicioVigTaxaEntrada = dataInicioVigTaxaEntrada;
		this.tipoTaxaEntrada = tipoTaxaEntrada;
		this.valorTaxaEntrada = valorTaxaEntrada;
		this.infoAdicionaisTaxaEntrada = infoAdicionaisTaxaEntrada;
		this.dataInicioVigTaxaSaida = dataInicioVigTaxaSaida;
		this.tipoTaxaSaida = tipoTaxaSaida;
		this.valorTaxaSaida = valorTaxaSaida;
		this.infoAdicionalTaxaSaida = infoAdicionalTaxaSaida;
	}

	public PerfilTaxaAdministracao getPerfilTaxaAdminstracao() {
		return perfilTaxaAdminstracao;
	}

	public void setPerfilTaxaAdminstracao(
			PerfilTaxaAdministracao perfilTaxaAdminstracao) {
		this.perfilTaxaAdminstracao = perfilTaxaAdminstracao;
	}

	public UnidadeTaxa getUnidadeTaxaAdministracao() {
		return unidadeTaxaAdministracao;
	}

	public void setUnidadeTaxaAdministracao(UnidadeTaxa unidadeTaxaAdministracao) {
		this.unidadeTaxaAdministracao = unidadeTaxaAdministracao;
	}

	public String getValorTaxaAdminstracao() {
		return valorTaxaAdminstracao;
	}

	public void setValorTaxaAdminstracao(String valorTaxaAdminstracao) {
		this.valorTaxaAdminstracao = valorTaxaAdminstracao;
	}

	public String getPlBaseCalculoTaxa() {
		return plBaseCalculoTaxa;
	}

	public void setPlBaseCalculoTaxa(String plBaseCalculoTaxa) {
		this.plBaseCalculoTaxa = plBaseCalculoTaxa;
	}

	public String getValorPiso() {
		return valorPiso;
	}

	public void setValorPiso(String valorPiso) {
		this.valorPiso = valorPiso;
	}

	public Indice getIndiceCorrecao() {
		return indiceCorrecao;
	}

	public void setIndiceCorrecao(Indice indiceCorrecao) {
		this.indiceCorrecao = indiceCorrecao;
	}

	public PeriodoCorrecao getPeriodoCorrecao() {
		return periodoCorrecao;
	}

	public void setPeriodoCorrecao(PeriodoCorrecao periodoCorrecao) {
		this.periodoCorrecao = periodoCorrecao;
	}

	public boolean isAplicaOutrosFundos() {
		return aplicaOutrosFundos;
	}

	public void setAplicaOutrosFundos(boolean aplicaOutrosFundos) {
		this.aplicaOutrosFundos = aplicaOutrosFundos;
	}

	public String getTaxaMaxima() {
		return taxaMaxima;
	}

	public void setTaxaMaxima(String taxaMaxima) {
		this.taxaMaxima = taxaMaxima;
	}

	public List<FaixasTaxas> getFaixasTaxas() {
		return faixasTaxas;
	}

	public void setFaixasTaxas(List<FaixasTaxas> faixasTaxas) {
		this.faixasTaxas = faixasTaxas;
	}

	public PerioCobranca getPerioCobrancaTaxaAdmin() {
		return perioCobrancaTaxaAdmin;
	}

	public void setPerioCobrancaTaxaAdmin(PerioCobranca perioCobrancaTaxaAdmin) {
		this.perioCobrancaTaxaAdmin = perioCobrancaTaxaAdmin;
	}

	public String getInfoAdicionaisTaxaNaoPadronizada() {
		return infoAdicionaisTaxaNaoPadronizada;
	}

	public void setInfoAdicionaisTaxaNaoPadronizada(
			String infoAdicionaisTaxaNaoPadronizada) {
		this.infoAdicionaisTaxaNaoPadronizada = infoAdicionaisTaxaNaoPadronizada;
	}

	public boolean isCobraTaxaPerformance() {
		return cobraTaxaPerformance;
	}

	public void setCobraTaxaPerformance(boolean cobraTaxaPerformance) {
		this.cobraTaxaPerformance = cobraTaxaPerformance;
	}

	public List<TaxaPerformance> getTaxaPerformance() {
		return taxaPerformance;
	}

	public void setTaxaPerformance(List<TaxaPerformance> taxaPerformance) {
		this.taxaPerformance = taxaPerformance;
	}

	public String getCupomTaxaPerformance() {
		return cupomTaxaPerformance;
	}

	public void setCupomTaxaPerformance(String cupomTaxaPerformance) {
		this.cupomTaxaPerformance = cupomTaxaPerformance;
	}

	public PerioCobranca getPerioCobrancaTaxaPerfor() {
		return perioCobrancaTaxaPerfor;
	}

	public void setPerioCobrancaTaxaPerfor(PerioCobranca perioCobrancaTaxaPerfor) {
		this.perioCobrancaTaxaPerfor = perioCobrancaTaxaPerfor;
	}

	public PlBaseCalculoTaxaPerfor getPlBaseCalculoTaxaPerfor() {
		return plBaseCalculoTaxaPerfor;
	}

	public void setPlBaseCalculoTaxaPerfor(
			PlBaseCalculoTaxaPerfor plBaseCalculoTaxaPerfor) {
		this.plBaseCalculoTaxaPerfor = plBaseCalculoTaxaPerfor;
	}

	public String getDiaUtilCalculoTaxaPerfor() {
		return diaUtilCalculoTaxaPerfor;
	}

	public void setDiaUtilCalculoTaxaPerfor(String diaUtilCalculoTaxaPerfor) {
		this.diaUtilCalculoTaxaPerfor = diaUtilCalculoTaxaPerfor;
	}

	public boolean isLinhaDagua() {
		return linhaDagua;
	}

	public void setLinhaDagua(boolean linhaDagua) {
		this.linhaDagua = linhaDagua;
	}

	public boolean isZeramentoPerformance() {
		return zeramentoPerformance;
	}

	public void setZeramentoPerformance(boolean zeramentoPerformance) {
		this.zeramentoPerformance = zeramentoPerformance;
	}

	public String getBaseCalculoTaxaPerfor() {
		return baseCalculoTaxaPerfor;
	}

	public void setBaseCalculoTaxaPerfor(String baseCalculoTaxaPerfor) {
		this.baseCalculoTaxaPerfor = baseCalculoTaxaPerfor;
	}

	public boolean isAjustePerforCotista() {
		return ajustePerforCotista;
	}

	public void setAjustePerforCotista(boolean ajustePerforCotista) {
		this.ajustePerforCotista = ajustePerforCotista;
	}

	public String getInfoAdicionaisTaxaPerfor() {
		return infoAdicionaisTaxaPerfor;
	}

	public void setInfoAdicionaisTaxaPerfor(String infoAdicionaisTaxaPerfor) {
		this.infoAdicionaisTaxaPerfor = infoAdicionaisTaxaPerfor;
	}

	public TipoTaxa getTipoTaxaEntrada() {
		return tipoTaxaEntrada;
	}

	public void setTipoTaxaEntrada(TipoTaxa tipoTaxaEntrada) {
		this.tipoTaxaEntrada = tipoTaxaEntrada;
	}

	public String getValorTaxaEntrada() {
		return valorTaxaEntrada;
	}

	public void setValorTaxaEntrada(String valorTaxaEntrada) {
		this.valorTaxaEntrada = valorTaxaEntrada;
	}

	public String getInfoAdicionaisTaxaEntrada() {
		return infoAdicionaisTaxaEntrada;
	}

	public void setInfoAdicionaisTaxaEntrada(String infoAdicionaisTaxaEntrada) {
		this.infoAdicionaisTaxaEntrada = infoAdicionaisTaxaEntrada;
	}

	public TipoTaxa getTipoTaxaSaida() {
		return tipoTaxaSaida;
	}

	public void setTipoTaxaSaida(TipoTaxa tipoTaxaSaida) {
		this.tipoTaxaSaida = tipoTaxaSaida;
	}

	public String getValorTaxaSaida() {
		return valorTaxaSaida;
	}

	public void setValorTaxaSaida(String valorTaxaSaida) {
		this.valorTaxaSaida = valorTaxaSaida;
	}

	public String getInfoAdicionalTaxaSaida() {
		return infoAdicionalTaxaSaida;
	}

	public void setInfoAdicionalTaxaSaida(String infoAdicionalTaxaSaida) {
		this.infoAdicionalTaxaSaida = infoAdicionalTaxaSaida;
	}

	public String getDataInicioVigTaxaAdmin() {
		return dataInicioVigTaxaAdmin;
	}

	public void setDataInicioVigTaxaAdmin(String dataInicioVigTaxaAdmin) {
		this.dataInicioVigTaxaAdmin = dataInicioVigTaxaAdmin;
	}

	public String getDataInicioVigTaxaPerformance() {
		return dataInicioVigTaxaPerformance;
	}

	public void setDataInicioVigTaxaPerformance(
			String dataInicioVigTaxaPerformance) {
		this.dataInicioVigTaxaPerformance = dataInicioVigTaxaPerformance;
	}

	public String getDataInicioVigTaxaEntrada() {
		return dataInicioVigTaxaEntrada;
	}

	public void setDataInicioVigTaxaEntrada(String dataInicioVigTaxaEntrada) {
		this.dataInicioVigTaxaEntrada = dataInicioVigTaxaEntrada;
	}

	public String getDataInicioVigTaxaSaida() {
		return dataInicioVigTaxaSaida;
	}

	public void setDataInicioVigTaxaSaida(String dataInicioVigTaxaSaida) {
		this.dataInicioVigTaxaSaida = dataInicioVigTaxaSaida;
	}

}
