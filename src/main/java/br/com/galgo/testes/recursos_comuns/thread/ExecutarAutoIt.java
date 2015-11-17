package br.com.galgo.testes.recursos_comuns.thread;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;

public class ExecutarAutoIt {

	private String pathArquivo;

	public String getPathArquivo() {
		return pathArquivo;
	}

	public boolean executar(String pathExecutavel, String path,
			boolean ehDownload) {
		return executar(pathExecutavel, path, ehDownload, true);
	}

	public boolean executar(String pathExecutavel, String path,
			boolean ehDownload, boolean alteraPath) {
		String cmd = "";
		Process p = null;
		try {
			if (alteraPath) {
				pathArquivo = ConfiguracaoSistema.getArquivoParaUpload(path,
						ehDownload);
			} else {
				pathArquivo = path;
			}
			cmd = ConfiguracaoSistema.getCmdToAutoIt(pathExecutavel,
					pathArquivo, ehDownload);
			System.out.println("[cmd=" + cmd + "]");

			p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
			if (p.isAlive()) {
				p.destroy();
			}
			return true;
		} catch (Exception e) {
			ErroAplicacao erroAplicacao = new ErroAplicacao(
					"Erro ao utilizar executável. [cmd=" + cmd + "]");
			p.destroyForcibly();
			Assert.fail(erroAplicacao.getMessage());
		}
		return false;
	}
}
