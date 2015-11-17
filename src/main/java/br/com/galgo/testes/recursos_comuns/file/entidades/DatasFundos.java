package br.com.galgo.testes.recursos_comuns.file.entidades;

public class DatasFundos {

	private boolean fasePreOperacional;
	private String dataInicioAtividade;
	private String dataPublicInicioOferta;
	private String dataVinculacaoAnbid;
	private String dataDesvinculacaoAnbid;
	private String dataAssembleia;
	private String dataProtocoloCVM;
	private String dataInicioValidadeAlteracao;

	public DatasFundos(boolean fasePreOperacional, String dataInicioAtividade) {
		this.fasePreOperacional = fasePreOperacional;
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public DatasFundos(boolean fasePreOperacional, String dataInicioAtividade,
			String dataPublicInicioOferta, String dataVinculacaoAnbid,
			String dataDesvinculacaoAnbid, String dataAssembleia,
			String dataProtocoloCVM, String dataInicioValidadeAlteracao) {
		super();
		this.fasePreOperacional = fasePreOperacional;
		this.dataInicioAtividade = dataInicioAtividade;
		this.dataPublicInicioOferta = dataPublicInicioOferta;
		this.dataVinculacaoAnbid = dataVinculacaoAnbid;
		this.dataDesvinculacaoAnbid = dataDesvinculacaoAnbid;
		this.dataAssembleia = dataAssembleia;
		this.dataProtocoloCVM = dataProtocoloCVM;
		this.dataInicioValidadeAlteracao = dataInicioValidadeAlteracao;
	}

	public boolean isFasePreOperacional() {
		return fasePreOperacional;
	}

	public void setFasePreOperacional(boolean fasePreOperacional) {
		this.fasePreOperacional = fasePreOperacional;
	}

	public String getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public void setDataInicioAtividade(String dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public String getDataPublicInicioOferta() {
		return dataPublicInicioOferta;
	}

	public void setDataPublicInicioOferta(String dataPublicInicioOferta) {
		this.dataPublicInicioOferta = dataPublicInicioOferta;
	}

	public String getDataVinculacaoAnbid() {
		return dataVinculacaoAnbid;
	}

	public void setDataVinculacaoAnbid(String dataVinculacaoAnbid) {
		this.dataVinculacaoAnbid = dataVinculacaoAnbid;
	}

	public String getDataDesvinculacaoAnbid() {
		return dataDesvinculacaoAnbid;
	}

	public void setDataDesvinculacaoAnbid(String dataDesvinculacaoAnbid) {
		this.dataDesvinculacaoAnbid = dataDesvinculacaoAnbid;
	}

	public String getDataAssembleia() {
		return dataAssembleia;
	}

	public void setDataAssembleia(String dataAssembleia) {
		this.dataAssembleia = dataAssembleia;
	}

	public String getDataProtocoloCVM() {
		return dataProtocoloCVM;
	}

	public void setDataProtocoloCVM(String dataProtocoloCVM) {
		this.dataProtocoloCVM = dataProtocoloCVM;
	}

	public String getDataInicioValidadeAlteracao() {
		return dataInicioValidadeAlteracao;
	}

	public void setDataInicioValidadeAlteracao(
			String dataInicioValidadeAlteracao) {
		this.dataInicioValidadeAlteracao = dataInicioValidadeAlteracao;
	}

}
