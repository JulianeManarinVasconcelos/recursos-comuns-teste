package br.com.galgo.testes.recursos_comuns.file.entidades;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Idioma;

public class DoctosAnexadosFundos {

	private boolean alteracaoImpactaBDAnbid;
	private String ataAssembleia;
	private Idioma idiomaAtaAssembleia;
	private boolean versaoAntAtaValida;
	private String cartaIsencao;
	private Idioma idiomaCartaIsencao;
	private boolean versaoAntCartaValida;
	private String prospecto;
	private Idioma idiomaProspecto;
	private boolean versaoAntProspectoValida;
	private String regulamento;
	private Idioma idiomaRegulamento;
	private boolean versaoAntRegulamentoValida;
	private String outrosDoctos;
	private Idioma idiomaOutrosDoctos;
	private boolean versaoAntOutrosDoctosValida;

	public DoctosAnexadosFundos(String ataAssembleia,
			Idioma idiomaAtaAssembleia, String cartaIsencao,
			Idioma idiomaCartaIsencao, String prospecto,
			Idioma idiomaProspecto, String regulamento,
			Idioma idiomaRegulamento, String outrosDoctos,
			Idioma idiomaOutrosDoctos) {
		super();
		this.ataAssembleia = ataAssembleia;
		this.idiomaAtaAssembleia = idiomaAtaAssembleia;
		this.cartaIsencao = cartaIsencao;
		this.idiomaCartaIsencao = idiomaCartaIsencao;
		this.prospecto = prospecto;
		this.idiomaProspecto = idiomaProspecto;
		this.regulamento = regulamento;
		this.idiomaRegulamento = idiomaRegulamento;
		this.outrosDoctos = outrosDoctos;
		this.idiomaOutrosDoctos = idiomaOutrosDoctos;
	}

	public DoctosAnexadosFundos(boolean alteracaoImpactaBDAnbid,
			String ataAssembleia, Idioma idiomaAtaAssembleia,
			boolean versaoAntAtaValida, String cartaIsencao,
			Idioma idiomaCartaIsencao, boolean versaoAntCartaValida,
			String prospecto, Idioma idiomaProspecto,
			boolean versaoAntProspectoValida, String regulamento,
			Idioma idiomaRegulamento, boolean versaoAntRegulamentoValida,
			String outrosDoctos, Idioma idiomaOutrosDoctos,
			boolean versaoAntOutrosDoctosValida) {
		super();
		this.alteracaoImpactaBDAnbid = alteracaoImpactaBDAnbid;
		this.ataAssembleia = ataAssembleia;
		this.idiomaAtaAssembleia = idiomaAtaAssembleia;
		this.versaoAntAtaValida = versaoAntAtaValida;
		this.cartaIsencao = cartaIsencao;
		this.idiomaCartaIsencao = idiomaCartaIsencao;
		this.versaoAntCartaValida = versaoAntCartaValida;
		this.prospecto = prospecto;
		this.idiomaProspecto = idiomaProspecto;
		this.versaoAntProspectoValida = versaoAntProspectoValida;
		this.regulamento = regulamento;
		this.idiomaRegulamento = idiomaRegulamento;
		this.versaoAntRegulamentoValida = versaoAntRegulamentoValida;
		this.outrosDoctos = outrosDoctos;
		this.idiomaOutrosDoctos = idiomaOutrosDoctos;
		this.versaoAntOutrosDoctosValida = versaoAntOutrosDoctosValida;
	}

	public Idioma getIdiomaAtaAssembleia() {
		return idiomaAtaAssembleia;
	}

	public void setIdiomaAtaAssembleia(Idioma idiomaAtaAssembleia) {
		this.idiomaAtaAssembleia = idiomaAtaAssembleia;
	}

	public Idioma getIdiomaCartaIsencao() {
		return idiomaCartaIsencao;
	}

	public void setIdiomaCartaIsencao(Idioma idiomaCartaIsencao) {
		this.idiomaCartaIsencao = idiomaCartaIsencao;
	}

	public Idioma getIdiomaProspecto() {
		return idiomaProspecto;
	}

	public void setIdiomaProspecto(Idioma idiomaProspecto) {
		this.idiomaProspecto = idiomaProspecto;
	}

	public Idioma getIdiomaRegulamento() {
		return idiomaRegulamento;
	}

	public void setIdiomaRegulamento(Idioma idiomaRegulamento) {
		this.idiomaRegulamento = idiomaRegulamento;
	}

	public Idioma getIdiomaOutrosDoctos() {
		return idiomaOutrosDoctos;
	}

	public void setIdiomaOutrosDoctos(Idioma idiomaOutrosDoctos) {
		this.idiomaOutrosDoctos = idiomaOutrosDoctos;
	}

	public String getAtaAssembleia() {
		return ataAssembleia;
	}

	public void setAtaAssembleia(String ataAssembleia) {
		this.ataAssembleia = ataAssembleia;
	}

	public String getCartaIsencao() {
		return cartaIsencao;
	}

	public void setCartaIsencao(String cartaIsencao) {
		this.cartaIsencao = cartaIsencao;
	}

	public String getProspecto() {
		return prospecto;
	}

	public void setProspecto(String prospecto) {
		this.prospecto = prospecto;
	}

	public String getRegulamento() {
		return regulamento;
	}

	public void setRegulamento(String regulamento) {
		this.regulamento = regulamento;
	}

	public String getOutrosDoctos() {
		return outrosDoctos;
	}

	public void setOutrosDoctos(String outrosDoctos) {
		this.outrosDoctos = outrosDoctos;
	}

	public boolean isAlteracaoImpactaBDAnbid() {
		return alteracaoImpactaBDAnbid;
	}

	public void setAlteracaoImpactaBDAnbid(boolean alteracaoImpactaBDAnbid) {
		this.alteracaoImpactaBDAnbid = alteracaoImpactaBDAnbid;
	}

	public boolean isVersaoAntAtaValida() {
		return versaoAntAtaValida;
	}

	public void setVersaoAntAtaValida(boolean versaoAntAtaValida) {
		this.versaoAntAtaValida = versaoAntAtaValida;
	}

	public boolean isVersaoAntCartaValida() {
		return versaoAntCartaValida;
	}

	public void setVersaoAntCartaValida(boolean versaoAntCartaValida) {
		this.versaoAntCartaValida = versaoAntCartaValida;
	}

	public boolean isVersaoAntProspectoValida() {
		return versaoAntProspectoValida;
	}

	public void setVersaoAntProspectoValida(boolean versaoAntProspectoValida) {
		this.versaoAntProspectoValida = versaoAntProspectoValida;
	}

	public boolean isVersaoAntRegulamentoValida() {
		return versaoAntRegulamentoValida;
	}

	public void setVersaoAntRegulamentoValida(boolean versaoAntRegulamentoValida) {
		this.versaoAntRegulamentoValida = versaoAntRegulamentoValida;
	}

	public boolean isVersaoAntOutrosDoctosValida() {
		return versaoAntOutrosDoctosValida;
	}

	public void setVersaoAntOutrosDoctosValida(
			boolean versaoAntOutrosDoctosValida) {
		this.versaoAntOutrosDoctosValida = versaoAntOutrosDoctosValida;
	}

}
