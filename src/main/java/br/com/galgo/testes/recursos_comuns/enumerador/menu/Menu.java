package br.com.galgo.testes.recursos_comuns.enumerador.menu;

import java.util.ArrayList;
import java.util.List;

public enum Menu {

	INICIO(1, "Início"), //
	AJUDA_ON_LINE(2, "Ajuda On-line"), //
	ENTIDADES(3, "Entidades"), //
	CADASTROS_BASICOS_PARAMETROS(4, "Cadastros Básicos e Parâmetros"), //
	COMPROMISSOS(5, "Compromissos"), //
	COMUNICADOS(6, "Comunicados"), //
	CARTEIRAS_ADMINISTRADAS(7, "Carteiras Administradas"), //
	FUNDOS(8, "Fundos de Investimento"), //
	PL_COTA(9, "PL/Cota"), //
	SEGURANCA(10, "Segurança"), //
	TARIFAS(11, "Tarifas"),
	EXTRATO(12, "Extrato de Conciliação de Cotas"),
	POSICAO_ATIVOS(13, "Posição de Ativos da Carteira"),
	RECIBOS(14, "Recibos");

	private int id;
	private String link;

	Menu(int id, String link) {
		this.id = id;
		this.link = link;
	}

	public String getLink() {
		return link;
	}

	public int getId() {
		return id;
	}

	public static List<SubMenu> getSubMenus(Menu menuPai) {
		List<SubMenu> subMenus = new ArrayList<SubMenu>();
		for (SubMenu subMenu : SubMenu.values()) {
			if (subMenu.getMenuPai() == menuPai) {
				subMenus.add(subMenu);
			}
		}
		return subMenus;
	}

	
}
