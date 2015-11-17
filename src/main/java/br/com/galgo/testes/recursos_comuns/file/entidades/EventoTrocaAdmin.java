package br.com.galgo.testes.recursos_comuns.file.entidades;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Administrador;

public class EventoTrocaAdmin {

	private String cnpj;
	private Administrador administrador;
	private String dataEvento;

	public EventoTrocaAdmin(String cnpj, Administrador administrador,
			String dataEvento) {
		super();
		this.cnpj = cnpj;
		this.administrador = administrador;
		this.dataEvento = dataEvento;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

}
