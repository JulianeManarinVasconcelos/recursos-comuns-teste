package br.com.galgo.testes.recursos_comuns.enumerador.usuario;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;
import br.com.galgo.testes.recursos_comuns.enumerador.menu.PermissaoMenu;

public enum UsuarioConfig {
	// PRODUÇÃO
	MASTER_STI(PermissaoMenu.MENUS_USUARIO_FINAL_STI,//
			"JULIANEVASCONCELOS.SISTEMAGALGO",//
			"Juliane Manarin",//
			Categoria.USUARIO_FINAL,//
			Papel.ADM_SISTEMA,//
			Ambiente.PRODUCAO), //
	ANBIMA(PermissaoMenu.MENUS_AUTO_REGULADOR,//
			"PATRICIAMACHADO.ANBIMA",//
			"Patrícia Nishikawa",//
			Categoria.USUARIO_FINAL,//
			Papel.AUTO_REGULADOR,//
			Ambiente.PRODUCAO), //
	ADM_SISTEMA(PermissaoMenu.MENUS_ADM_SISTEMA,//
			"VALDEMARARANTES.SISTEMAGALGO",//
			"VALDEMAR ARANTES",//
			Categoria.USUARIO_FINAL,//
			Papel.ADMINISTRADOR,//
			Ambiente.PRODUCAO), //

	// HOMOLOGAÇÃO
	SG_0408_SG_04(PermissaoMenu.MENUS_ADM_SISTEMA,//
			"SG_0408.SG_04",//
			"Galgo - Usu Final - 0408",//
			Categoria.USUARIO_FINAL,//
			Papel.CONTROLADOR_ATIVO,//
			Ambiente.HOMOLOGACAO), //
	USUARIO_FINAL_STI_HOMOL(PermissaoMenu.MENUS_USUARIO_FINAL_STI,//
			"SG_0108.GALGO",//
			"Galgo - Usu Final ",//
			Categoria.USUARIO_FINAL,//
			Papel.ADM_SISTEMA,//
			Ambiente.HOMOLOGACAO), //
	AUTOREG_HOMOLOG(PermissaoMenu.MENUS_AUTO_REGULADOR,//
			"SG_0305.SG_03",//
			"Galgo - Usu Final - 0305",//
			Categoria.USUARIO_FINAL,//
			Papel.AUTO_REGULADOR,//
			Ambiente.HOMOLOGACAO), //
	ADM_SISTEMA_HOMOLOG(PermissaoMenu.MENUS_MASTER_STI_HOMO,//
			"SG_0907.SG_09",//
			"Galgo - Usu Final - 0907",//
			Categoria.USUARIO_FINAL,//
			Papel.ADMINISTRADOR,//
			Ambiente.HOMOLOGACAO) //
	;

	private PermissaoMenu permissaoMenu;
	private String login;
	private String nome;
	private Categoria categoria;
	private Papel papel;
	private Ambiente ambiente;

	UsuarioConfig(PermissaoMenu permissaoMenu, String login, String nome,
			Categoria categoria, Papel papel, Ambiente ambiente) {
		this.permissaoMenu = permissaoMenu;
		this.login = login;
		this.nome = nome;
		this.categoria = categoria;
		this.papel = papel;
		this.ambiente = ambiente;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Papel getPapel() {
		return papel;
	}

	public PermissaoMenu getPermissaoMenu() {
		return permissaoMenu;
	}

	public String getLogin() {
		return login;
	}

	public String getNome() {
		return nome;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public static UsuarioConfig fromCategoria(Ambiente ambiente,
			Categoria categoria, Papel papel) {
		for (UsuarioConfig usuarioConfig : UsuarioConfig.values()) {
			if (usuarioConfig.getAmbiente() == ambiente
					&& usuarioConfig.getCategoria() == categoria
					&& usuarioConfig.getPapel() == papel) {
				return usuarioConfig;
			}
		}
		return null;
	}

}
