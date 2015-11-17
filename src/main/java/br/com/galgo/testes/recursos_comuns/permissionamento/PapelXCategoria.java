package br.com.galgo.testes.recursos_comuns.permissionamento;

import java.util.List;

import br.com.galgo.testes.recursos_comuns.enumerador.usuario.Categoria;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.Papel;

public class PapelXCategoria {

	private List<Papel> papeis;
	private List<Categoria> categorias;
	
	public PapelXCategoria(List<Papel> papeis,List<Categoria> categorias){
		this.papeis=papeis;
		this.categorias=categorias;
	}
	
	public List<Papel> getPapeis() {
		return papeis;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}
	
}
