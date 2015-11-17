package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

import java.util.ArrayList;
import java.util.List;

public enum PublicoAlvo {

	VAZIO("null", ""), //
	CAPITALIZACAO("75", "CAPITALIZAÇÃO"), //
	CORPORATE("76", "CORPORATE");

	private String value;
	private String desc;

	PublicoAlvo(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static PublicoAlvo fromDesc(String desc) {
		for (PublicoAlvo servico : PublicoAlvo.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static PublicoAlvo fromValue(String value) {
		for (PublicoAlvo servico : PublicoAlvo.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

	public static List<PublicoAlvo> fromListDesc(List<String> listaRecebida) {
		List<PublicoAlvo> lista = new ArrayList<PublicoAlvo>();

		for (String elemento : listaRecebida) {
			lista.add(fromDesc(elemento));
		}
		return lista;
	}
}
