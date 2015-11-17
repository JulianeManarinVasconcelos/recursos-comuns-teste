package br.com.galgo.testes.recursos_comuns.utils;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoTeste;
import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;
import br.com.galgo.testes.recursos_comuns.file.ArquivoUtils;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TesteUtils {

	public static void finalizarTeste(String nomeArquivo) {
		try {
			tirarPrint(nomeArquivo);
		} finally {
			TelaPrincipal.fecharBrowser();
		}
	}

	public static void tirarPrint(String nomeArquivo) {
		nomeArquivo = ArquivoUtils.getPathConsulta(nomeArquivo, ".png");
		String caminhoEvidencia = ConfiguracaoSistema
				.getCaminhoEvidenciaTarget(nomeArquivo);
		TelaPrincipal.tirarScreamShot(caminhoEvidencia);
	}

	public static Ambiente configurarTeste(Ambiente ambiente, String pastaSuite) {
		configurar(ambiente, pastaSuite);

		if (ConfiguracaoSistema.configuracaoSuiteTeste != null) {
			ambiente = ConfiguracaoSistema.configuracaoSuiteTeste.getAmbiente();
		}

		return ambiente;
	}

	public static void configurar(Ambiente ambiente, String pastaSuite) {
		ConfiguracaoTeste configuracaoTeste = new ConfiguracaoTeste(ambiente,
				pastaSuite);
		ConfiguracaoSistema.setConfiguracaoTeste(configuracaoTeste);
	}

}
