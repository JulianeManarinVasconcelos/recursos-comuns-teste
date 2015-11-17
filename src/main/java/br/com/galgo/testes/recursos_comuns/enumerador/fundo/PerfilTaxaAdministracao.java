package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

public enum PerfilTaxaAdministracao {

	VAZIO("null", ""), //
	ESCALONADA("2", "ESCALONADA/CASCATA"), //
	FIXA("1", "FIXA"), //
	NAO_PADRONIZADO("3", "NÃO PADRONIZADO");

	private String value;
	private String desc;

	PerfilTaxaAdministracao(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static PerfilTaxaAdministracao fromDesc(String desc) {
		for (PerfilTaxaAdministracao servico : PerfilTaxaAdministracao.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static PerfilTaxaAdministracao fromValue(String value) {
		for (PerfilTaxaAdministracao servico : PerfilTaxaAdministracao.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

}
