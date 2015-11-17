package br.com.galgo.testes.recursos_comuns.enumerador.carteira;

public enum TipoCarteira {

	PF("Pessoa Física"), //
	PJ("Pessoa Jurídica"), //
	INR("INR");

	private String desc;

	TipoCarteira(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static TipoCarteira fromDesc(String desc) {
		for (TipoCarteira servico : TipoCarteira.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

}
