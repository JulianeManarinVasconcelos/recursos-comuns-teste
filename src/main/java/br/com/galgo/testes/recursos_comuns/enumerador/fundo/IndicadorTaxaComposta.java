package br.com.galgo.testes.recursos_comuns.enumerador.fundo;

import java.util.ArrayList;
import java.util.List;

public enum IndicadorTaxaComposta {

	VAZIO("null", ""), //
	E("1", "E"), //
	OU("2", "OU");

	private String value;
	private String desc;

	IndicadorTaxaComposta(String value, String desc) {
		this.value = value;
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getValue() {
		return value;
	}

	public static IndicadorTaxaComposta fromDesc(String desc) {
		for (IndicadorTaxaComposta servico : IndicadorTaxaComposta.values()) {
			if (servico.getDesc().equalsIgnoreCase(desc)) {
				return servico;
			}
		}
		return null;
	}

	public static IndicadorTaxaComposta fromValue(String value) {
		for (IndicadorTaxaComposta servico : IndicadorTaxaComposta.values()) {
			if (servico.getValue().equalsIgnoreCase(value)) {
				return servico;
			}
		}
		return null;
	}

	public static List<IndicadorTaxaComposta> fromListDesc(
			List<String> listaRecebida) {
		List<IndicadorTaxaComposta> lista = new ArrayList<IndicadorTaxaComposta>();

		for (String elemento : listaRecebida) {
			lista.add(fromDesc(elemento));
		}
		return lista;
	}

}
