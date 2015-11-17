package br.com.galgo.testes.recursos_comuns.pageObject.cancelamento;

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvioPosicaoArquivo;

public class TelaCancelamentoPosicao extends TelaPrincipal {

	public void cancelarArquivo(String dataBase, String codigoSTI, Usuario usuario)
			throws Exception {
		TelaEnvioPosicaoArquivo telaEnvioPosicaoArquivo = new TelaEnvioPosicaoArquivo(
				usuario, dataBase, codigoSTI);
		telaEnvioPosicaoArquivo.salvar(Operacao.CANCELA_INFORMES);
		telaEnvioPosicaoArquivo.clicarBotaoVoltar();
	}

	public void clicarBotaoConcelarViaArquivo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/div/form/div[2]/div/div[1]/div/div/input[3]");
	}
}
