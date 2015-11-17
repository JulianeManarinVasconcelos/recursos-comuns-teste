package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

import java.util.ArrayList;
import java.util.List;

public enum UnidadeTaxa {

	VAZIO("null", ""), //
	PORCENTAGEM("1", "%"), //
	MISTA("3", "MISTA"), //
	REAL("2", "R$");

	private String value;
	private String desc;

	UnidadeTaxa(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static UnidadeTaxa fromDesc(String desc) {
		for (UnidadeTaxa servico : UnidadeTaxa.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static UnidadeTaxa fromValue(String value) {
		for (UnidadeTaxa servico : UnidadeTaxa.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

	public static List<UnidadeTaxa> fromListDesc(List<String> listaRecebida) {
		List<UnidadeTaxa> lista = new ArrayList<UnidadeTaxa>();

		for (String elemento : listaRecebida) {
			lista.add(fromDesc(elemento));
		}
		return lista;
	}

}
