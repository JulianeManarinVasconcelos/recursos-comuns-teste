package br.com.galgo.testes.recursos_comuns.enumerador.carteira;

public enum TipoCota {

	ABERTURA("Abertura"), //
	FECHAMENTO("Fechamento");

	private String desc;

	TipoCota(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public static TipoCota fromDesc(String desc) {
		for (TipoCota servico : TipoCota.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

}
