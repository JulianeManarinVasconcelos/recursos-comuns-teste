
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.teste.Teste;
import br.com.galgo.testes.recursos_comuns.utils.TesteUtils;

public class ExemploAula extends Teste {

	@Before
	public void setUp() throws Exception {
		// configurar();
	}

	@Test
	public void exemploTesteGoogle() throws ErroAplicacao {
		this.setNomeTeste("exemploTesteGoogle.png");
		TelaPrincipal.abrirBrowser("http://google.com.br");
		TelaPrincipal tela = new TelaPrincipal();
		tela.preencheCampoXPath(
				"/html/body/div/div[3]/form/div[2]/div[2]/div[1]/div[1]/div[3]/div/div[3]/div/input[1]",
				"O que é Jenkins");

		String link = tela
				.getTextoPorXPath("/html/body/div/div[5]/div[4]/div[6]/div[1]/div[3]/div/div[2]/div[2]/div/div/ol/li/div[1]/div/div[1]/ol/li[2]/div/span[1]");
		System.out.println(link);

	}

	@After
	public void tearDown() {
		TesteUtils.finalizarTeste(this.getNomeTeste());
	}

}
