package br.com.galgo.testes.recursos_comuns.enumerador.menu;

import java.util.ArrayList;
import java.util.List;

public enum PermissaoMenu {

	MENUS_USUARIO_FINAL_STI(
			"Menus visíveis para usuários final com papel MASTER_STI com todos os permissionamentos.",//
			Menu.INICIO, //
			Menu.ENTIDADES, //
			Menu.CADASTROS_BASICOS_PARAMETROS, //
			Menu.COMPROMISSOS, //
			Menu.COMUNICADOS, //
			Menu.CARTEIRAS_ADMINISTRADAS, //
			Menu.FUNDOS, //
			Menu.PL_COTA, //
			Menu.SEGURANCA,//
			Menu.TARIFAS), //
	MENUS_AUTO_REGULADOR(
			"Menus visíveis para usuários finais com papel Auto-Reguladores com todos os permissionamentos.",//
			Menu.INICIO, //
			Menu.COMPROMISSOS, //
			Menu.COMUNICADOS, //
			Menu.CARTEIRAS_ADMINISTRADAS, //
			Menu.FUNDOS, //
			Menu.PL_COTA, //
			Menu.SEGURANCA), //
	MENUS_ADM_SISTEMA(
			"Menus visíveis para usuários finais com papel Administrador do sistema com todos os permissionamentos.",//
			Menu.INICIO, //
			Menu.ENTIDADES, //
			Menu.COMPROMISSOS, //
			Menu.COMUNICADOS, //
			Menu.CARTEIRAS_ADMINISTRADAS, //
			Menu.FUNDOS, //
			Menu.EXTRATO,//
			Menu.POSICAO_ATIVOS,//
			Menu.RECIBOS,//
			Menu.SEGURANCA,//
			Menu.TARIFAS), //
	MENUS_MASTER_STI_HOMO(
			"Menus visíveis para master STI do sistema com todos os permissionamentos.",//
			Menu.INICIO, //
			Menu.ENTIDADES, //
			Menu.COMPROMISSOS, //
			Menu.COMUNICADOS, //
			Menu.FUNDOS, //
			Menu.SEGURANCA,//
			Menu.TARIFAS);

	private String descricao;
	private List<Menu> menus;

	PermissaoMenu(String descricao, Menu... menus) {
		this.descricao = descricao;
		this.menus = new ArrayList<Menu>();
		for (Menu menu : menus) {
			this.menus.add(menu);
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Menu> getMenus() {
		return menus;
	}

}
