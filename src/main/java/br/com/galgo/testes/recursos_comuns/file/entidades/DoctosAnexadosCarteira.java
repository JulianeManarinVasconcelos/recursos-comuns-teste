package br.com.galgo.testes.recursos_comuns.file.entidades;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Idioma;

public class DoctosAnexadosCarteira {

	public String contratoAdministracao;
	public Idioma idiomaContratoAdministracao;
	public String outrosDoctos;
	public Idioma idiomaOutrosDoctos;

	public DoctosAnexadosCarteira(String contratoAdministracao,
			Idioma idiomaContratoAdministracao, String outrosDoctos,
			Idioma idiomaOutrosDoctos) {
		super();
		this.contratoAdministracao = contratoAdministracao;
		this.idiomaContratoAdministracao = idiomaContratoAdministracao;
		this.outrosDoctos = outrosDoctos;
		this.idiomaOutrosDoctos = idiomaOutrosDoctos;
	}

	public String getContratoAdministracao() {
		return contratoAdministracao;
	}

	public void setContratoAdministracao(String contratoAdministracao) {
		this.contratoAdministracao = contratoAdministracao;
	}

	public Idioma getIdiomaContratoAdministracao() {
		return idiomaContratoAdministracao;
	}

	public void setIdiomaContratoAdministracao(
			Idioma idiomaContratoAdministracao) {
		this.idiomaContratoAdministracao = idiomaContratoAdministracao;
	}

	public String getOutrosDoctos() {
		return outrosDoctos;
	}

	public void setOutrosDoctos(String outrosDoctos) {
		this.outrosDoctos = outrosDoctos;
	}

	public Idioma getIdiomaOutrosDoctos() {
		return idiomaOutrosDoctos;
	}

	public void setIdiomaOutrosDoctos(Idioma idiomaOutrosDoctos) {
		this.idiomaOutrosDoctos = idiomaOutrosDoctos;
	}

}
