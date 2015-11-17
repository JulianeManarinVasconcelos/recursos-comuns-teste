package br.com.galgo.testes.recursos_comuns.enumerador;

public enum Canal {

	WS("WS"), //
	PORTAL("Portal"), //
	ARQUIVO("Arquivo");

	private String desc;

	Canal(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Canal fromDesc(String desc) {
		for (Canal canal : Canal.values()) {
			if (canal.getDesc().equalsIgnoreCase(desc)) {
				return canal;
			}
		}
		return null;
	}

}
