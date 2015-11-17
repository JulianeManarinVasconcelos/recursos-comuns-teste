package br.com.galgo.testes.recursos_comuns.config;

import java.io.File;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;

public class ConfiguracaoSistema {

	public static final String USER_HOME = "user.home";
	public static final String CONFIG = ".config";
	public static final int MAX_RETENTATIVA = 4;
	public static final int MINUTOS_ANTES_LOGIN = 1;
	public static final String PATH_PROJETO = "target/evidencia/";
	public static final String SPACER = "/";

	public static ConfiguracaoSuiteTeste configuracaoSuiteTeste;
	public static ConfiguracaoTeste configuracaoTeste;

	public static String getCaminhoEvidenciaTarget(String nomeArquivo) {
		return getCaminhoDoProjetoEvidencia(nomeArquivo, PATH_PROJETO, "");
	}

	private static String getCaminhoDoProjetoEvidencia(String nomeArquivo,
			String caminhoAmbiente, String pastaEvidencia) {
		StringBuilder caminho = new StringBuilder();
		caminho = caminho.//
				append(caminhoAmbiente)
				.//
				append(pastaEvidencia != "" ? SPACER + pastaEvidencia + SPACER
						: "").//
				append(nomeArquivo);

		return caminho.toString();
	}

	public static String getCaminhoEvidenciaRede(String nomeArquivo) {
		String pastaEvidencia = getPasta();
		String caminhoAmbiente = getCaminhoAmbiente();
		return getCaminhoDoProjetoEvidencia(nomeArquivo, caminhoAmbiente,
				pastaEvidencia);
	}

	private static String getPasta() {
		String pastaEvidencia = "";
		if (configuracaoSuiteTeste != null
				&& configuracaoSuiteTeste.isUsarPastaEvidenciaSuite()) {
			pastaEvidencia = configuracaoSuiteTeste.getPastaEvidencia();
			if (configuracaoSuiteTeste.isConcatenarPastaSuiteETeste()) {
				pastaEvidencia += SPACER
						+ configuracaoTeste.getPastaEvidencia();
			}
		} else {
			pastaEvidencia = configuracaoTeste.getPastaEvidencia();
		}
		return pastaEvidencia;
	}

	private static String getCaminhoAmbiente() {
		Ambiente ambiente;
		if (configuracaoSuiteTeste != null
				&& configuracaoSuiteTeste.isUsarAmbienteEvidenciaSuite()) {
			ambiente = configuracaoSuiteTeste.getAmbiente();
		} else {
			ambiente = configuracaoTeste.getAmbiente();
		}
		return ambiente.getCaminhoEvidencia();
	}

	public static void setConfiguracaoSuiteTeste(
			ConfiguracaoSuiteTeste configuracaoSuiteTeste) {
		ConfiguracaoSistema.configuracaoSuiteTeste = configuracaoSuiteTeste;
	}

	public static void setConfiguracaoTeste(ConfiguracaoTeste configuracaoTeste) {
		ConfiguracaoSistema.configuracaoTeste = configuracaoTeste;
	}

	public static String getPathExecutavel(String pathExecutavel) {
		String userPath = System.getProperty(USER_HOME);
		File f = new File(userPath, File.separator + CONFIG + File.separator
				+ pathExecutavel);
		String executavelPath = f.getAbsolutePath();
		return executavelPath;
	}

	public static String getPathArquivo(String pathArquivo, boolean ehTarget) {
		File f = null;
		if (ehTarget) {
			f = new File(getCaminhoEvidenciaTarget(pathArquivo));
		} else {
			String userPath = System.getProperty(USER_HOME);
			f = new File(userPath, File.separator + CONFIG + File.separator
					+ pathArquivo);
		}

		String executavelPath = f.getAbsolutePath();
		return executavelPath;
	}

	public static String removePathArquivo(String pathArquivo) {
		String userPath = System.getProperty(USER_HOME);
		return pathArquivo.replace(userPath + File.separator + CONFIG
				+ File.separator, "");
	}

	public static String getCmdToAutoIt(String pathExecutavel,
			String pathArquivo, boolean ehDownload) {
		String executavelPath = ConfiguracaoSistema
				.getPathExecutavel(pathExecutavel);

		String cmd = executavelPath + " " + '"' + pathArquivo + '"';

		return cmd;
	}

	public static String getArquivoParaUpload(String pathArquivo,
			boolean ehDownload) {
		String arquivoParaUpload = ConfiguracaoSistema.getPathArquivo(
				pathArquivo, ehDownload);
		return arquivoParaUpload;
	}

}
