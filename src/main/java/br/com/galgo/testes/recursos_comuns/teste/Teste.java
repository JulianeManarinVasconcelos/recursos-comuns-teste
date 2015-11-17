package br.com.galgo.testes.recursos_comuns.teste;

public abstract class Teste {

	private String nomeTeste;

	public String getNomeTeste() {
		return nomeTeste;
	}

	public void setNomeTeste(String nomeTeste) {
		this.nomeTeste = nomeTeste;
		System.out.println("Executando o teste: "
				+ nomeTeste.replace(".png", ""));
	}

}
