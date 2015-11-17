package br.com.galgo.testes.recursos_comuns.pageObject;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.menu.Menu;
import br.com.galgo.testes.recursos_comuns.enumerador.menu.PermissaoMenu;
import br.com.galgo.testes.recursos_comuns.enumerador.menu.SubMenu;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.Papel;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.UsuarioConfig;
import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.permissionamento.PapelXCategoria;

public class TelaHome extends TelaPrincipal {

	public TelaHome(Usuario usuarioLogado) {
		final UsuarioConfig usuarioConfig = usuarioLogado.getUsuarioConfig();
		if (usuarioConfig != null) {
			validaTelaHome(usuarioConfig.getNome());
			validaPermissaoMenus(usuarioConfig);
		}
	}

	public Tela acessarSubMenu(SubMenu subMenu) {
		abrirSubMenu(subMenu.getMenuPai().getLink(), subMenu.getLinkSubMenu());
		return subMenu.getTelaDoSubMenu();
	}

	private void validaPermissaoMenus(UsuarioConfig usuarioConfig) {
		PermissaoMenu permissaoMenu = usuarioConfig.getPermissaoMenu();
		for (Menu menu : permissaoMenu.getMenus()) {
			for (SubMenu subMenu : Menu.getSubMenus(menu)) {
				if (temPermissaoParaSubMenu(usuarioConfig, subMenu)) {
					String link = menu.getLink();
					try {
						String nomeUsuario = usuarioConfig.getNome();
						verificaCampoVisivelPorLink(link, nomeUsuario);
					} catch (ErroAplicacao e) {
						Assert.fail(e.getMessage());
					}
				}

			}
		}
	}

	private boolean temPermissaoParaSubMenu(UsuarioConfig usuarioConfig,
			SubMenu subMenu) {
		Categoria categoriaUsuario = usuarioConfig.getCategoria();
		Papel papelUsuario = usuarioConfig.getPapel();
		PapelXCategoria papelXCategoria = subMenu.getPapelXCategoria();

		if (papelXCategoria.getCategorias().contains(categoriaUsuario)
				&& papelXCategoria.getPapeis().contains(papelUsuario)) {
			return true;
		}
		return false;
	}

	private void validaTelaHome(String nomeUsuarioLogado) {
		garanteTextoNaTela(nomeUsuarioLogado);
	}

}
