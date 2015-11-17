package br.com.galgo.testes.recursos_comuns.file.entidades;

public class Fundo {

	private IdentificaoFundo identificaoFundo;
	private Evento evento;
	private PerfilFundo perfil;
	private DatasFundos datasFundos;
	private PrestadoresServicoFundo prestadoresServico;
	private TaxasFundos taxasFundos;
	private ParametrosMovimentacao parametrosMovimentacao;
	private Amortizacao amortizacao;
	private Contas contas;
	private DoctosAnexadosFundos doctosAnexados;

	public Fundo(IdentificaoFundo identificaoFundo, Evento evento,
			PerfilFundo perfil, DatasFundos datasFundos,
			PrestadoresServicoFundo prestadoresServico, TaxasFundos taxasFundos,
			ParametrosMovimentacao parametrosMovimentacao,
			Amortizacao amortizacao, Contas contas,
			DoctosAnexadosFundos doctosAnexados) {
		super();
		this.identificaoFundo = identificaoFundo;
		this.evento = evento;
		this.perfil = perfil;
		this.datasFundos = datasFundos;
		this.prestadoresServico = prestadoresServico;
		this.taxasFundos = taxasFundos;
		this.parametrosMovimentacao = parametrosMovimentacao;
		this.amortizacao = amortizacao;
		this.contas = contas;
		this.doctosAnexados = doctosAnexados;
	}

	public IdentificaoFundo getIdentificaoFundo() {
		return identificaoFundo;
	}

	public void setIdentificaoFundo(IdentificaoFundo identificaoFundo) {
		this.identificaoFundo = identificaoFundo;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public PerfilFundo getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilFundo perfil) {
		this.perfil = perfil;
	}

	public DatasFundos getDatasFundos() {
		return datasFundos;
	}

	public void setDatasFundos(DatasFundos datasFundos) {
		this.datasFundos = datasFundos;
	}

	public PrestadoresServicoFundo getPrestadoresServico() {
		return prestadoresServico;
	}

	public void setPrestadoresServico(PrestadoresServicoFundo prestadoresServico) {
		this.prestadoresServico = prestadoresServico;
	}

	public TaxasFundos getTaxasFundos() {
		return taxasFundos;
	}

	public void setTaxasFundos(TaxasFundos taxasFundos) {
		this.taxasFundos = taxasFundos;
	}

	public ParametrosMovimentacao getParametrosMovimentacao() {
		return parametrosMovimentacao;
	}

	public void setParametrosMovimentacao(
			ParametrosMovimentacao parametrosMovimentacao) {
		this.parametrosMovimentacao = parametrosMovimentacao;
	}

	public Amortizacao getAmortizacao() {
		return amortizacao;
	}

	public void setAmortizacao(Amortizacao amortizacao) {
		this.amortizacao = amortizacao;
	}

	public Contas getContas() {
		return contas;
	}

	public void setContas(Contas contas) {
		this.contas = contas;
	}

	public DoctosAnexadosFundos getDoctosAnexados() {
		return doctosAnexados;
	}

	public void setDoctosAnexados(DoctosAnexadosFundos doctosAnexados) {
		this.doctosAnexados = doctosAnexados;
	}

}
