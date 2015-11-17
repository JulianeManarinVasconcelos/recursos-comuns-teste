package br.com.galgo.testes.recursos_comuns.file.entidades;

import br.com.galgo.testes.recursos_comuns.enumerador.carteira.TipoCota;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.CategoriaAnbid;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PublicoAlvo;

public class PerfilCarteira {

	private TipoCota calculoCotas;
	private String horarioCompPlCota;
	private String horarioCompPosiaco;
	private CategoriaAnbid categoriaAnbid;
	private PublicoAlvo tipoIvestidor;

	public PerfilCarteira(TipoCota calculoCotas, String horarioCompPlCota,
			String horarioCompPosiaco, CategoriaAnbid categoriaAnbid,
			PublicoAlvo tipoIvestidor) {
		super();
		this.calculoCotas = calculoCotas;
		this.horarioCompPlCota = horarioCompPlCota;
		this.horarioCompPosiaco = horarioCompPosiaco;
		this.categoriaAnbid = categoriaAnbid;
		this.tipoIvestidor = tipoIvestidor;
	}

	public TipoCota getCalculoCotas() {
		return calculoCotas;
	}

	public void setCalculoCotas(TipoCota calculoCotas) {
		this.calculoCotas = calculoCotas;
	}

	public String getHorarioCompPlCota() {
		return horarioCompPlCota;
	}

	public void setHorarioCompPlCota(String horarioCompPlCota) {
		this.horarioCompPlCota = horarioCompPlCota;
	}

	public String getHorarioCompPosiaco() {
		return horarioCompPosiaco;
	}

	public void setHorarioCompPosiaco(String horarioCompPosiaco) {
		this.horarioCompPosiaco = horarioCompPosiaco;
	}

	public CategoriaAnbid getCategoriaAnbid() {
		return categoriaAnbid;
	}

	public void setCategoriaAnbid(CategoriaAnbid categoriaAnbid) {
		this.categoriaAnbid = categoriaAnbid;
	}

	public PublicoAlvo getTipoIvestidor() {
		return tipoIvestidor;
	}

	public void setTipoIvestidor(PublicoAlvo tipoIvestidor) {
		this.tipoIvestidor = tipoIvestidor;
	}

}
