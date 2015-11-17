package br.com.galgo.testes.recursos_comuns.file.entidades;


public class EventoIncorporacao {

	private String cnpjOrigem;
	private String cnpjDestino;
	private String dataEvento;

	public EventoIncorporacao(String cnpjOrigem, String cnpjDestino,
			String dataEvento) {
		super();
		this.cnpjOrigem = cnpjOrigem;
		this.cnpjDestino = cnpjDestino;
		this.dataEvento = dataEvento;
	}

	public String getCnpjOrigem() {
		return cnpjOrigem;
	}

	public void setCnpjOrigem(String cnpjOrigem) {
		this.cnpjOrigem = cnpjOrigem;
	}

	public String getCnpjDestino() {
		return cnpjDestino;
	}

	public void setCnpjDestino(String cnpjDestino) {
		this.cnpjDestino = cnpjDestino;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

}
