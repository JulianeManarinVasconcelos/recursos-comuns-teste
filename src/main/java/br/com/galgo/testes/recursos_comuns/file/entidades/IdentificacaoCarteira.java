package br.com.galgo.testes.recursos_comuns.file.entidades;

import br.com.galgo.testes.recursos_comuns.enumerador.carteira.TipoCarteira;

public class IdentificacaoCarteira {

	private TipoCarteira tipo;
	private String docto;
	private String nome;
	private String nomeFantasia;
	private String sigla;

	public IdentificacaoCarteira(TipoCarteira tipo, String docto, String nome,
			String nomeFantasia, String sigla) {
		super();
		this.tipo = tipo;
		this.docto = docto;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.sigla = sigla;
	}

	public TipoCarteira getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarteira tipo) {
		this.tipo = tipo;
	}

	public String getDocto() {
		return docto;
	}

	public void setDocto(String cnpj) {
		this.docto = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
