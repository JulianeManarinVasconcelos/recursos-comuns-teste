package br.com.galgo.testes.recursos_comuns.file.entidades;

public class Carteira {

	private IdentificacaoCarteira identificacaoCarteira;
	private PerfilCarteira perfilCarteira;
	private String dataInicioAtividade;
	private PrestadoresServicoCarteira prestadoresServicoCarteira;
	private String codSUSEP;
	private boolean divulgacaoAnbid;
	private DoctosAnexadosCarteira doctosAnexadosCarteira;
	private boolean validacaoInclusao;

	public Carteira(IdentificacaoCarteira identificacaoCarteira,
			PerfilCarteira perfilCarteira, String dataInicioAtividade,
			PrestadoresServicoCarteira prestadoresServicoCarteira,
			String codSUSEP, boolean divulgacaoAnbid,
			DoctosAnexadosCarteira doctosAnexadosCarteira,
			boolean validacaoInclusao) {
		super();
		this.identificacaoCarteira = identificacaoCarteira;
		this.perfilCarteira = perfilCarteira;
		this.dataInicioAtividade = dataInicioAtividade;
		this.prestadoresServicoCarteira = prestadoresServicoCarteira;
		this.codSUSEP = codSUSEP;
		this.divulgacaoAnbid = divulgacaoAnbid;
		this.doctosAnexadosCarteira = doctosAnexadosCarteira;
		this.validacaoInclusao = validacaoInclusao;
	}

	public IdentificacaoCarteira getIdentificacaoCarteira() {
		return identificacaoCarteira;
	}

	public void setIdentificacaoCarteira(
			IdentificacaoCarteira identificacaoCarteira) {
		this.identificacaoCarteira = identificacaoCarteira;
	}

	public PerfilCarteira getPerfilCarteira() {
		return perfilCarteira;
	}

	public void setPerfilCarteira(PerfilCarteira perfilCarteira) {
		this.perfilCarteira = perfilCarteira;
	}

	public String getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public void setDataInicioAtividade(String dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public PrestadoresServicoCarteira getPrestadoresServicoCarteira() {
		return prestadoresServicoCarteira;
	}

	public void setPrestadoresServicoCarteira(
			PrestadoresServicoCarteira prestadoresServicoCarteira) {
		this.prestadoresServicoCarteira = prestadoresServicoCarteira;
	}

	public String getCodSUSEP() {
		return codSUSEP;
	}

	public void setCodSUSEP(String codSUSEP) {
		this.codSUSEP = codSUSEP;
	}

	public boolean isDivulgacaoAnbid() {
		return divulgacaoAnbid;
	}

	public void setDivulgacaoAnbid(boolean divulgacaoAnbid) {
		this.divulgacaoAnbid = divulgacaoAnbid;
	}

	public DoctosAnexadosCarteira getDoctosAnexadosCarteira() {
		return doctosAnexadosCarteira;
	}

	public void setDoctosAnexadosCarteira(
			DoctosAnexadosCarteira doctosAnexadosCarteira) {
		this.doctosAnexadosCarteira = doctosAnexadosCarteira;
	}

	public boolean isValidacaoInclusao() {
		return validacaoInclusao;
	}

	public void setValidacaoInclusao(boolean validacaoInclusao) {
		this.validacaoInclusao = validacaoInclusao;
	}

}
