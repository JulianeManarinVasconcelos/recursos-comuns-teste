package br.com.galgo.testes.recursos_comuns.file.entidades;

public class IdentificaoFundo {

	private String cnpj;
	private String razaoSocial;
	private String dataInicioVigRazaoSocial;
	private String nomeFantasia;
	private String dataInicioVigNomeFantasia;
	private String nomeFantasioImprensa;
	private String sigla;
	private String mnemonicoCETIP;
	private String ISIN;
	private String CUSIP;
	private boolean divulgacaoAnbid;
	private boolean alteracaoImplicaAnalise;

	public IdentificaoFundo(String cnpj, String razaoSocial,
			String nomeFantasia, String nomeFantasioImprensa, String sigla,
			String mnemonicoCETIP, String ISIN, String CUSIP,
			boolean divulgacaoAnbid) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.nomeFantasioImprensa = nomeFantasioImprensa;
		this.sigla = sigla;
		this.mnemonicoCETIP = mnemonicoCETIP;
		this.ISIN = ISIN;
		this.CUSIP = CUSIP;
		this.divulgacaoAnbid = divulgacaoAnbid;
	}

	public IdentificaoFundo(String cnpj, String razaoSocial,
			String dataInicioVigRazaoSocial, String nomeFantasia,
			String dataInicioVigNomeFantasia, String nomeFantasioImprensa,
			String sigla, String mnemonicoCETIP, String ISIN, String CUSIP,
			boolean divulgacaoAnbid, boolean alteracaoImplicaAnalise) {
		super();
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.dataInicioVigRazaoSocial = dataInicioVigRazaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.dataInicioVigNomeFantasia = dataInicioVigNomeFantasia;
		this.nomeFantasioImprensa = nomeFantasioImprensa;
		this.sigla = sigla;
		this.mnemonicoCETIP = mnemonicoCETIP;
		this.ISIN = ISIN;
		this.CUSIP = CUSIP;
		this.divulgacaoAnbid = divulgacaoAnbid;
		this.alteracaoImplicaAnalise = alteracaoImplicaAnalise;
	}

	public boolean isDivulgacaoAnbid() {
		return divulgacaoAnbid;
	}

	public void setDivulgacaoAnbid(boolean divulgacaoAnbid) {
		this.divulgacaoAnbid = divulgacaoAnbid;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getNomeFantasioImprensa() {
		return nomeFantasioImprensa;
	}

	public void setNomeFantasioImprensa(String nomeFantasioImprensa) {
		this.nomeFantasioImprensa = nomeFantasioImprensa;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getMnemonicoCETIP() {
		return mnemonicoCETIP;
	}

	public void setMnemonicoCETIP(String mnemonicoCETIP) {
		this.mnemonicoCETIP = mnemonicoCETIP;
	}

	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String iSIN) {
		ISIN = iSIN;
	}

	public String getCUSIP() {
		return CUSIP;
	}

	public void setCUSIP(String cUSIP) {
		CUSIP = cUSIP;
	}

	public String getDataInicioVigRazaoSocial() {
		return dataInicioVigRazaoSocial;
	}

	public void setDataInicioVigRazaoSocial(String dataInicioVigRazaoSocial) {
		this.dataInicioVigRazaoSocial = dataInicioVigRazaoSocial;
	}

	public String getDataInicioVigNomeFantasia() {
		return dataInicioVigNomeFantasia;
	}

	public void setDataInicioVigNomeFantasia(String dataInicioVigNomeFantasia) {
		this.dataInicioVigNomeFantasia = dataInicioVigNomeFantasia;
	}

	public boolean isAlteracaoImplicaAnalise() {
		return alteracaoImplicaAnalise;
	}

	public void setAlteracaoImplicaAnalise(boolean alteracaoImplicaAnalise) {
		this.alteracaoImplicaAnalise = alteracaoImplicaAnalise;
	}

}
