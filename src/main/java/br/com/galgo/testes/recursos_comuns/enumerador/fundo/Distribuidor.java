package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

import java.util.ArrayList;
import java.util.List;

public enum Distribuidor {

	VAZIO("null", ""), //
	GALGO05("18", "GALGO - 05 - ADMINISTRADOR E DISTRIB"), //
	GALGO14("278", "GALGO - 14"), //
	CLOUD_GTEC_PROVEDOR("3765", "CLOUD - GTEC - PROVEDOR"), //
	CLOUD_GTEC_CONSUMIDOR("3768", "CLOUD - GTEC CONSUMIDOR");

	private String value;
	private String desc;

	Distribuidor(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static Distribuidor fromDesc(String desc) {
		for (Distribuidor servico : Distribuidor.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static Distribuidor fromValue(String value) {
		for (Distribuidor servico : Distribuidor.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

	public static List<Distribuidor> fromListDesc(List<String> listaRecebida) {
		List<Distribuidor> lista = new ArrayList<Distribuidor>();

		for (String elemento : listaRecebida) {
			lista.add(fromDesc(elemento));
		}
		return lista;
	}

}
