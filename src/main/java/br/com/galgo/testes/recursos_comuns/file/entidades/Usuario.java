package br.com.galgo.testes.recursos_comuns.file.entidades;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.UsuarioConfig;
import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;

public class Usuario {

	private String login;
	private String senha;
	private Ambiente ambiente;
	private UsuarioConfig usuarioConfig;

	public Usuario(String login, String senha, Ambiente ambiente) {
		this.login = login;
		this.senha = senha;
		this.ambiente = ambiente;
	}

	public Usuario(UsuarioConfig usuarioConfig) {
		this.usuarioConfig = usuarioConfig;
		this.ambiente = usuarioConfig.getAmbiente();
		this.login = usuarioConfig.getLogin();
		try {
			this.senha = ArquivoUtils.getSenha(usuarioConfig);
		} catch (ErroAplicacao e) {
			Assert.fail("Erro ao pegar senha do usuario com login = "
					+ this.login + " - erro = " + e.getMessage());
		}
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public Ambiente getAmbiente() {
		if (this.usuarioConfig == null) {
			return ambiente;
		} else {
			return usuarioConfig.getAmbiente();
		}
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public UsuarioConfig getUsuarioConfig() {
		return usuarioConfig;
	}

	public void setUsuarioConfig(UsuarioConfig usuarioConfig) {
		this.usuarioConfig = usuarioConfig;
	}

}
