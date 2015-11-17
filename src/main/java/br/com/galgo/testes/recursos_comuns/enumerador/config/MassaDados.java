package br.com.galgo.testes.recursos_comuns.enumerador.config;

import br.com.galgo.testes.recursos_comuns.utils.ConstantesTestes;

public enum MassaDados {

	FUNDOS_CARTEIRAS_PRODUCAO(
			ConstantesTestes.CAMINHO_MASSA_DADOS_FUNDOS_PRODUCAO,//
			Ambiente.PRODUCAO,//
			ConstantesTestes.DESC_MASSA_DADOS_FUNDOS), //
	FUNDOS_CARTEIRAS_HOMOLOGACAO(
			ConstantesTestes.CAMINHO_MASSA_DADOS_FUNDOS_HOMOLOGACAO,//
			Ambiente.HOMOLOGACAO,//
			ConstantesTestes.DESC_MASSA_DADOS_FUNDOS), //
	TRANSF_PRODUCAO(ConstantesTestes.CAMINHO_MASSA_DADOS_TRANSF_PRODUCAO,//
			Ambiente.PRODUCAO,//
			ConstantesTestes.DESC_MASSA_DADOS_TRANSF), //
	TRANSF_HOMOLOGACAO(ConstantesTestes.CAMINHO_MASSA_DADOS_TRANSF_HOMOLOGACAO,//
			Ambiente.HOMOLOGACAO,//
			ConstantesTestes.DESC_MASSA_DADOS_TRANSF);

	private String path;
	private Ambiente ambiente;
	private String desc;

	MassaDados(String path, Ambiente ambiente, String desc) {
		this.path = path;
		this.ambiente = ambiente;
		this.desc = desc;
	}

	public String getPath() {
		return path;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public String getDesc() {
		return desc;
	}

	public static MassaDados fromAmbiente(Ambiente ambiente, String desc) {
		for (MassaDados massa : MassaDados.values()) {
			if (massa.getAmbiente() == ambiente) {
				if (massa.getDesc().equalsIgnoreCase(desc)) {
					return massa;
				}
			}
		}
		return null;
	}

}
