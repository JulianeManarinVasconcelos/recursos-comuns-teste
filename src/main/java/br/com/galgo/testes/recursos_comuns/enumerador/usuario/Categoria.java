package br.com.galgo.testes.recursos_comuns.enumerador.usuario;

import java.util.ArrayList;
import java.util.List;


public enum Categoria {

	MASTER_STI("MASTER_STI"), //
	USUARIO_FINAL_STI("USUARIO_FINAL_STI"), //
	MASTER_ENTIDADE("MASTER_ENTIDADE"), //
	MASTER_ENTIDADE_SEGURANCA("MASTER_ENTIDADE_SEGURANCA"), //
	MASTER_ENTIDADE_NEGOCIO("MASTER_ENTIDADE_NEGOCIO"), //
	MASTER_PAPEL("MASTER_PAPEL"), //
	MASTER_PAPEL_SEGURANCA("MASTER_PAPEL_SEGURANCA"), //
	MASTER_PAPEL_NEGOCIO("MASTER_PAPEL_NEGOCIO"), //
	USUARIO_SEGURANCA("USUARIO_SEGURANCA"), //
	USUARIO_FINAL("USUARIO_FINAL"), //
	USUARIO_SISTEMA_EXTERNO("USUARIO_SISTEMA_EXTERNO");

	private String descricao;

	Categoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}
	
	public static List<Categoria> getList(Categoria... categorias) {
		List<Categoria> lista = new ArrayList<Categoria>();
		for (Categoria categoria : categorias) {
			lista.add(categoria);
		}
		return lista;
	}

}
