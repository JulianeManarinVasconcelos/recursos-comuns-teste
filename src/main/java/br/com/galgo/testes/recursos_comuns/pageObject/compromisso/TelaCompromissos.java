package br.com.galgo.testes.recursos_comuns.pageObject.compromisso;

import static org.junit.Assert.*;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;


public class TelaCompromissos extends TelaPrincipal {

	public void validarVencidosDiasAnteriores() {
		assertTrue(verificaCampoVisivelPorXPath(getXPathBarraDeProgressoVencidosDiasAnteriores()));
	}

	private String getXPathBarraDeProgressoVencidosDiasAnteriores() {
		return "//div[@class='ui-progressbar-value ui-widget-header ui-corner-left']";
	}

}
