package br.com.galgo.testes.recursos_comuns.file.entidades;

import java.util.ArrayList;
import java.util.List;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.IndicadorTaxaComposta;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Indice;

public class TaxaPerformance {

	private IndicadorTaxaComposta indicadorTaxaComposta;
	private String percentual;
	private String porcentagemIndiceReferencia;
	private Indice indiceReferencia;

	public TaxaPerformance(IndicadorTaxaComposta indicadorTaxaComposta,
			String percentual, String porcentagemIndiceReferencia,
			Indice indiceReferencia) {
		super();
		this.indicadorTaxaComposta = indicadorTaxaComposta;
		this.percentual = percentual;
		this.porcentagemIndiceReferencia = porcentagemIndiceReferencia;
		this.indiceReferencia = indiceReferencia;
	}

	public IndicadorTaxaComposta getIndicadorTaxaComposta() {
		return indicadorTaxaComposta;
	}

	public void setIndicadorTaxaComposta(
			IndicadorTaxaComposta indicadorTaxaComposta) {
		this.indicadorTaxaComposta = indicadorTaxaComposta;
	}

	public String getPercentual() {
		return percentual;
	}

	public void setPercentual(String percentual) {
		this.percentual = percentual;
	}

	public String getPorcentagemIndiceReferencia() {
		return porcentagemIndiceReferencia;
	}

	public void setPorcentagemIndiceReferencia(
			String porcentagemIndiceReferencia) {
		this.porcentagemIndiceReferencia = porcentagemIndiceReferencia;
	}

	public Indice getIndiceReferencia() {
		return indiceReferencia;
	}

	public void setIndiceReferencia(Indice indiceReferencia) {
		this.indiceReferencia = indiceReferencia;
	}

	public static List<TaxaPerformance> fromList(
			List<IndicadorTaxaComposta> indicadorTaxaComposta,
			List<String> percentual, List<String> porcentagemIndiceReferencia,
			List<Indice> indiceReferencia) {

		List<TaxaPerformance> lista = new ArrayList<TaxaPerformance>();

		for (int i = 0; i < indicadorTaxaComposta.size(); i++) {
			TaxaPerformance elemento = new TaxaPerformance(
					indicadorTaxaComposta.get(i), percentual.get(i),
					porcentagemIndiceReferencia.get(i), indiceReferencia.get(i));
			lista.add(elemento);
		}

		return lista;
	}

}
