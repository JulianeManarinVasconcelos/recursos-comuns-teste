package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

import java.util.ArrayList;
import java.util.List;

public enum Indice {

	VAZIO("null", "");

	private String value;
	private String desc;

	Indice(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Indice fromDesc(String desc) {
		for (Indice servico : Indice.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Indice fromValue(String value) {
		for (Indice servico : Indice.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

	public static List<Indice> fromListDesc(List<String> listaRecebida) {
		List<Indice> lista = new ArrayList<Indice>();

		for (String elemento : listaRecebida) {
			lista.add(fromDesc(elemento));
		}
		return lista;
	}

}
