package br.com.galgo.testes.recursos_comuns.file.entidades;


public class DadosExpurgo {

	private String nome;
	private int qtdRegistro;

	public DadosExpurgo(String nome, int qtdRegistro) {
		super();
		this.nome = nome;
		this.qtdRegistro = qtdRegistro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdRegistro() {
		return qtdRegistro;
	}

	public void setQtdRegistro(int qtdRegistro) {
		this.qtdRegistro = qtdRegistro;
	}

}
