package br.com.galgo.testes.recursos_comuns.file.entidades;

import java.util.ArrayList;
import java.util.List;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.UnidadeTaxa;

public class FaixasTaxas {

	private String valorInicialPl;
	private String valorFinalPl;
	private UnidadeTaxa unidadeTaxa;
	private String taxa;

	public FaixasTaxas(String valorInicialPl, String valorFinalPl,
			UnidadeTaxa unidadeTaxa, String taxa) {
		super();
		this.valorInicialPl = valorInicialPl;
		this.valorFinalPl = valorFinalPl;
		this.unidadeTaxa = unidadeTaxa;
		this.taxa = taxa;
	}

	public String getValorInicialPl() {
		return valorInicialPl;
	}

	public void setValorInicialPl(String valorInicialPl) {
		this.valorInicialPl = valorInicialPl;
	}

	public String getValorFinalPl() {
		return valorFinalPl;
	}

	public void setValorFinalPl(String valorFinalPl) {
		this.valorFinalPl = valorFinalPl;
	}

	public UnidadeTaxa getUnidadeTaxa() {
		return unidadeTaxa;
	}

	public void setUnidadeTaxa(UnidadeTaxa unidadeTaxa) {
		this.unidadeTaxa = unidadeTaxa;
	}

	public String getTaxa() {
		return taxa;
	}

	public void setTaxa(String taxa) {
		this.taxa = taxa;
	}

	public static List<FaixasTaxas> fromList(List<String> valorInicialPl,
			List<String> valorFinalPl, List<UnidadeTaxa> unidadeTaxa,
			List<String> taxa) {

		List<FaixasTaxas> listaFaixas = new ArrayList<FaixasTaxas>();

		for (int i = 0; i < valorInicialPl.size(); i++) {
			FaixasTaxas faixasTaxas = new FaixasTaxas(valorInicialPl.get(i),
					valorFinalPl.get(i), unidadeTaxa.get(i), taxa.get(i));
			listaFaixas.add(faixasTaxas);
		}

		return listaFaixas;
	}

}
