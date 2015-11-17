package br.com.galgo.testes.recursos_comuns.utils;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSuiteTeste;
import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;

public class SuiteUtils {

	public static void configurarSuiteDefault(Ambiente ambiente,
			String pastaSuite) {
		boolean usarAmbienteEvidenciaSuite = true;
		boolean usarCaminhoEvidenciaSuite = true;
		boolean concatenarPastaSuiteETeste = false;

		ConfiguracaoSuiteTeste configuracaoSuiteTeste = new ConfiguracaoSuiteTeste(
				ambiente, pastaSuite, usarAmbienteEvidenciaSuite,
				usarCaminhoEvidenciaSuite, concatenarPastaSuiteETeste);

		ConfiguracaoSistema.setConfiguracaoSuiteTeste(configuracaoSuiteTeste);
	}

}
