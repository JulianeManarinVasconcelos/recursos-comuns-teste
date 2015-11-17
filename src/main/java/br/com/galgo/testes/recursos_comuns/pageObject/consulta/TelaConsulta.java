package br.com.galgo.testes.recursos_comuns.pageObject.consulta;

import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.Tela;

public interface TelaConsulta extends Tela {

	public final int MAX_TENTATIVAS = 5;

	public void consultar(String codigoSTI, String dataFiltro);

	public void fazerDownload(String codigoSTI, String dataFiltro,
			Usuario usuario);

}
