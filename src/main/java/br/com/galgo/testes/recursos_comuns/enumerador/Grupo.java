package br.com.galgo.testes.recursos_comuns.enumerador;

public enum Grupo {

	ANTES("ANTES"), //
	DEPOIS("DEPOIS");

	private String desc;

	Grupo(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}
	
	public static Grupo fromDesc(String desc) {
		for (Grupo grupo : Grupo.values()) {
			if (grupo.getDesc().equalsIgnoreCase(desc)) {
				return grupo;
			}
		}
		return null;
	}

}
