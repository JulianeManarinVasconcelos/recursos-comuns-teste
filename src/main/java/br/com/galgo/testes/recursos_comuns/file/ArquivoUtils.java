package br.com.galgo.testes.recursos_comuns.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.enumerador.Canal;
import br.com.galgo.testes.recursos_comuns.enumerador.Grupo;
import br.com.galgo.testes.recursos_comuns.enumerador.IdTeste;
import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.enumerador.Servico;
import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;
import br.com.galgo.testes.recursos_comuns.enumerador.data.FormatoData;
import br.com.galgo.testes.recursos_comuns.enumerador.usuario.UsuarioConfig;
import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.exception.MensagemErro;
import br.com.galgo.testes.recursos_comuns.file.entidades.Arquivo;
import br.com.galgo.testes.recursos_comuns.file.entidades.DadosExpurgo;
import br.com.galgo.testes.recursos_comuns.file.entidades.HistoricoEventos;
import br.com.galgo.testes.recursos_comuns.file.entidades.Teste;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;
import br.com.galgo.testes.recursos_comuns.pageObject.envio.TelaEnvio;
import br.com.galgo.testes.recursos_comuns.utils.DataUtils;

public class ArquivoUtils {

	private static String SEPARADOR = ";";

	public static String getPathConsulta(String path, String extensao) {
		return path.replace(extensao, "")
				+ FormatoData.DDMMYYYYHHMMSS.formata(new Date()) + extensao;
	}

	public static boolean gravaHistorico(String caminhoArq,
			List<HistoricoEventos> listaHistorico, Servico servico)
			throws ErroAplicacao {
		Arquivo arquivo = new Arquivo(caminhoArq);

		try {
			arquivo.openTextFileWriter();
			String csv = "";
			csv = servico.getValue();
			csv = csv + SEPARADOR;
			csv = csv + servico.getDesc();
			csv = csv + "\n";

			csv = csv + "Data" + SEPARADOR;
			csv = csv + "Pre-Consolidada" + SEPARADOR;
			csv = csv + "Pre-Nao consolidada" + SEPARADOR;
			csv = csv + "Pos-Consolidada" + SEPARADOR;
			csv = csv + "Pos-Nao consolidada" + SEPARADOR;
			csv = csv + "\n";

			for (HistoricoEventos historicoEventos : listaHistorico) {
				csv = csv
						+ FormatoData.DD_MM_YYYY.formata(historicoEventos
								.getDataHistorico()) + SEPARADOR;
				csv = csv + historicoEventos.getQtdEventosConsolidadoPre()
						+ SEPARADOR;
				csv = csv + historicoEventos.getQtdEventosNaoConsolidadaPre()
						+ SEPARADOR;
				csv = csv + historicoEventos.getQtdEventosConsolidadoPos()
						+ SEPARADOR;
				csv = csv + historicoEventos.getQtdEventosNaoConsolidadoPos()
						+ SEPARADOR;
				csv = csv + "\n";
			}
			arquivo.append(csv);
			arquivo.Write(caminhoArq);
			return true;
		} catch (IOException e) {
			throw new ErroAplicacao("Arquivo não encontrado no caminho: "
					+ caminhoArq);
		}
	}

	public static List<HistoricoEventos> uploadListaDatasParaValidacao(
			String caminhoArq) throws ErroAplicacao {
		Arquivo arquivo = new Arquivo(caminhoArq);

		List<HistoricoEventos> listaDatasHistoricas = new ArrayList<HistoricoEventos>();

		try {
			arquivo.openTextFile();
			arquivo.readLine();
			arquivo.readLine();
			while (arquivo.next()) {
				String linha = arquivo.readLine();
				String[] vDados = linha.split("[;]");

				HistoricoEventos t = populaLinhaPlanilhaHistoricoEventos(vDados);

				listaDatasHistoricas.add(t);
			}
			return listaDatasHistoricas;

		} catch (IOException e) {
			throw new ErroAplicacao("Arquivo não encontrado no caminho: "
					+ caminhoArq);
		} catch (ParseException e) {
			throw new ErroAplicacao("Data inválida! Caminho: " + caminhoArq);
		} catch (Exception e) {
			throw new ErroAplicacao("Problema geral no arquivo! Caminho: "
					+ caminhoArq);
		}
	}

	public static Servico getServicoHistorico(String caminhoArq)
			throws ErroAplicacao {
		Arquivo arquivo = new Arquivo(caminhoArq);

		Servico service;

		try {
			arquivo.openTextFile();
			String linha = arquivo.readLine();
			String[] vDados = linha.split("[;]");
			service = Servico.fromDesc(vDados[1]);
			if (service == null) {
				service = Servico.fromValue(vDados[0]);
			}
			if (service == null) {
				throw new ErroAplicacao(
						"Arquivo com layout inválido! Caminho: " + caminhoArq);
			}
			return service;

		} catch (IOException e) {
			throw new ErroAplicacao("Arquivo não encontrado no caminho: "
					+ caminhoArq);
		}
	}

	public static String getSenha(UsuarioConfig usuario) throws ErroAplicacao {
		Ambiente ambiente = usuario.getAmbiente();
		if (Ambiente.PRODUCAO == ambiente) {
			return getSenha(usuario, ambiente.getCaminhoArqAutenticacao(), 3,
					4, "PRODUÇÃO");
		} else {
			if (Ambiente.HOMOLOGACAO == ambiente) {
				return getSenha(usuario, ambiente.getCaminhoArqAutenticacao(),
						12, 13, "Usuários");
			} else {
				return getSenha(usuario, ambiente.getCaminhoArqAutenticacao(),
						2, 3, "CloudProducao");
			}
		}
	}

	public static List<Usuario> getUsuarioCumprirEvento(Ambiente ambiente,
			String caminhoArq, Servico servico) throws ErroAplicacao {
		if (Servico.EXTRATO == servico) {
			return getUsuarioCumprirEvento(ambiente, caminhoArq, 2);
		} else if (Servico.PL_COTA == servico || Servico.INFO_ANBIMA == servico) {
			return getUsuarioCumprirEvento(ambiente, caminhoArq, 3);
		} else if (Servico.POSICAO_ATIVOS == servico) {
			return getUsuarioCumprirEvento(ambiente, caminhoArq, 4);
		} else {
			System.out.println("Servico invalido.");
			return null;
		}
	}

	public static void atualizaMassaDeDados(String caminhoArq, String codSTI,
			String dataBase, IdTeste idTesteCancelamento,
			IdTeste idTesteConsulta, IdTeste idTesteReenvio) {
		atualizaMassaDeDados(caminhoArq, codSTI, dataBase, "",
				idTesteCancelamento, idTesteConsulta, idTesteReenvio);
	}

	public static void atualizaMassaDeDados(String caminhoArq, String codSTI,
			String dataBase, String codSTICotista, IdTeste idTesteCancelamento,
			IdTeste idTesteConsulta, IdTeste idTesteReenvio) {
		try {
			ArquivoUtils.atualizaAba(caminhoArq,
					Operacao.CONSULTA_TRANSFERENCIA, codSTI, dataBase,
					codSTICotista, idTesteConsulta);
			ArquivoUtils.atualizaAba(caminhoArq, Operacao.CANCELA_INFORMES,
					codSTI, dataBase, codSTICotista, idTesteCancelamento);
			ArquivoUtils.atualizaAba(caminhoArq, Operacao.REENVIO_INFORMES,
					codSTI, dataBase, codSTICotista, idTesteReenvio);
		} catch (Exception e) {
			Assert.fail("Ocorreu problema ao atualiar massa de dados após envio!"
					+ e.getMessage());
		}
	}

	private static void atualizaAba(String caminhoArq, Operacao operacao,
			String codSTI, String dataBase, String codSTICotista,
			IdTeste idTeste) throws Exception {
		try {
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			if (!verificaMassaJaExisteEAtualiza(caminhoArq, operacao, codSTI,
					dataBase, codSTICotista, idTeste)) {
				final String descAba = operacao.getDescAba();
				XSSFSheet worksheet = workbook.getSheet(descAba);

				final int ultimaLinha = worksheet.getLastRowNum();

				XSSFRow linha = worksheet.createRow(ultimaLinha + 1);

				XSSFCell colunaTeste = linha.createCell(0);
				XSSFCell colunaFundo = linha.createCell(1);
				XSSFCell colunaDataBase = linha.createCell(2);
				XSSFCell colunaCotista = linha.createCell(3);

				final String id = idTeste.getId();
				colunaTeste.setCellValue(id);
				colunaFundo.setCellValue(codSTI);
				dataBase = DataUtils.getDataBase(dataBase);
				colunaDataBase.setCellValue(dataBase);
				if (codSTICotista != "") {
					colunaCotista.setCellValue(codSTICotista);
				}
				fileInputStream.close();
				FileOutputStream out = new FileOutputStream(
						new File(caminhoArq));
				workbook.write(out);
				out.close();
			}
		} catch (FileNotFoundException e) {
			throw new ErroAplicacao(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
		} catch (IOException e) {
			throw new ErroAplicacao(MensagemErro.EXCEL_ERRO);
		}
	}

	private static boolean verificaMassaJaExisteEAtualiza(String caminhoArq,
			Operacao operacao, String codSTI, String dataBase,
			String codSTICotista, IdTeste idTeste) throws ErroAplicacao {
		try {
			boolean achou = false;
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			final String descAba = operacao.getDescAba();
			XSSFSheet worksheet = workbook.getSheet(descAba);

			// eliminando o cabeçalho
			int linhaCorrente = worksheet.getFirstRowNum() + 1;
			final int ultimaLinha = worksheet.getLastRowNum();
			while (linhaCorrente <= ultimaLinha) {
				XSSFRow linha = worksheet.getRow(linhaCorrente);

				XSSFCell colunaTeste = linha.getCell(0);
				final String testeId = colunaTeste.getStringCellValue();

				if (testeId.equals(idTeste.getId())) {
					XSSFCell colunaFundo = linha.getCell(1);
					XSSFCell colunaDataBase = linha.getCell(2);
					XSSFCell colunaCotista = linha.getCell(3);
					colunaFundo.setCellValue(codSTI);

					dataBase = DataUtils.getDataBase(dataBase);
					colunaDataBase.setCellValue(dataBase);
					if (codSTICotista != "") {
						colunaCotista.setCellValue(codSTICotista);
					}
					achou = true;
				}
				linhaCorrente++;
			}
			fileInputStream.close();
			if (achou) {
				FileOutputStream out = new FileOutputStream(
						new File(caminhoArq));
				workbook.write(out);
				out.close();
			}
			return achou;
		} catch (FileNotFoundException e) {
			throw new ErroAplicacao(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
		} catch (IOException e) {
			throw new ErroAplicacao(MensagemErro.EXCEL_ERRO);
		}
	}

	private static List<Usuario> getUsuarioCumprirEvento(Ambiente ambiente,
			String caminhoArq, int idColunaCumprir) throws ErroAplicacao {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		try {
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			XSSFSheet worksheet = workbook.getSheetAt(0);

			// eliminando o cabeçalho
			int linhaCorrente = worksheet.getFirstRowNum() + 1;
			final int ultimaLinha = worksheet.getLastRowNum();
			while (linhaCorrente <= ultimaLinha) {
				XSSFRow linha = worksheet.getRow(linhaCorrente);

				XSSFCell colunaCumprir = linha.getCell(idColunaCumprir);
				final String ehParaCumprir = colunaCumprir.getStringCellValue();

				if (ehParaCumprir.equalsIgnoreCase("Sim")) {
					XSSFCell colunaLogin = linha.getCell(0);
					final String login = colunaLogin.getStringCellValue();

					XSSFCell colunaSenha = linha.getCell(1);
					final String senha = colunaSenha.getStringCellValue();

					Usuario usuario = new Usuario(login, senha, ambiente);
					listaUsuarios.add(usuario);
				}
				linhaCorrente++;
			}
			return listaUsuarios;
		} catch (FileNotFoundException e) {
			throw new ErroAplicacao(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
		} catch (IOException e) {
			throw new ErroAplicacao(MensagemErro.EXCEL_ERRO);
		}
	}

	private static String getSenha(UsuarioConfig usuario, String caminhoArq,
			int celulaLogin, int celulaSenha, String aba) throws ErroAplicacao {
		try {
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			XSSFSheet worksheet = workbook.getSheet(aba);

			int linhaCorrente = worksheet.getFirstRowNum();
			final int ultimaLinha = worksheet.getLastRowNum();
			while (linhaCorrente <= ultimaLinha) {
				XSSFRow linha = worksheet.getRow(linhaCorrente);
				XSSFCell colunaLogin = linha.getCell(celulaLogin);
				final String login = colunaLogin.getStringCellValue();
				if (login.equalsIgnoreCase(usuario.getLogin())) {
					XSSFCell colunaSenha = linha.getCell(celulaSenha);
					return colunaSenha.getStringCellValue();
				}
				linhaCorrente++;
			}
			return null;
		} catch (FileNotFoundException e) {
			throw new ErroAplicacao(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
		} catch (IOException e) {
			throw new ErroAplicacao(MensagemErro.EXCEL_ERRO);
		}
	}

	public static boolean trocaSenha(Usuario usuario, String novaSenha)
			throws ErroAplicacao {
		final String login = usuario.getLogin();

		LogTrocaDeSenha(login, novaSenha);

		Ambiente ambiente = usuario.getAmbiente();

		if (Ambiente.PRODUCAO == ambiente) {
			return trocaSenha(usuario, ambiente.getCaminhoArqAutenticacao(), 3,
					4, novaSenha);
		} else {
			return trocaSenha(usuario, ambiente.getCaminhoArqAutenticacao(),
					12, 13, novaSenha);
		}
	}

	private static void LogTrocaDeSenha(String login, String novaSenha) {
		System.out.println("Foi atualizado a senha do usuario " + login
				+ " para " + novaSenha);
	}

	private static boolean trocaSenha(Usuario usuario, String caminhoArq,
			int celulaLogin, int celulaSenha, String novaSenha)
			throws ErroAplicacao {
		boolean trocou = false;
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(
					caminhoArq));
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			XSSFSheet worksheet = workbook.getSheet("PRODUÇÃO");

			int linhaCorrente = worksheet.getFirstRowNum();
			final int ultimaLinha = worksheet.getLastRowNum();

			while (linhaCorrente <= ultimaLinha && trocou == false) {
				XSSFRow linha = worksheet.getRow(linhaCorrente);
				XSSFCell colunaLogin = linha.getCell(celulaLogin);
				final String login = colunaLogin.getStringCellValue();
				if (login.equalsIgnoreCase(usuario.getLogin())) {
					linha.getCell(celulaSenha).setCellValue(novaSenha);
					trocou = true;
				}
				linhaCorrente++;
			}
			fileInputStream.close();
			FileOutputStream out = new FileOutputStream(new File(caminhoArq));
			workbook.write(out);
			out.close();

			return trocou;
		} catch (FileNotFoundException e) {
			throw new ErroAplicacao(MensagemErro.ARQUIVO_NAO_ENCONTRADO + " "
					+ e.getMessage());
		} catch (IOException e) {
			throw new ErroAplicacao(MensagemErro.EXCEL_ERRO);
		}
	}

	private static HistoricoEventos populaLinhaPlanilhaHistoricoEventos(
			String[] vDados) throws ParseException {
		int i = 0;

		Date dataHistorico = new Date();
		String qtdEventosConsolidadoPre = "";
		String qtdEventosNaoConsolidadaPre = "";
		String qtdEventosConsolidadoPos = "";
		String qtdEventosNaoConsolidadoPos = "";

		if (vDados.length > i) {
			dataHistorico = FormatoData.DD_MM_YYYY.getData(vDados[0].replace(
					"\"", ""));
			i++;
		}
		if (vDados.length > i) {
			qtdEventosConsolidadoPre = vDados[1].replace("\"", "");
			i++;
		}
		if (vDados.length > i) {
			qtdEventosNaoConsolidadaPre = vDados[2].replace("\"", "");
			i++;
		}
		if (vDados.length > i) {
			qtdEventosConsolidadoPos = vDados[3].replace("\"", "");
			i++;
		}
		if (vDados.length > i) {
			qtdEventosNaoConsolidadoPos = vDados[4].replace("\"", "");
			i++;
		}

		HistoricoEventos historicoEventos = new HistoricoEventos(dataHistorico,
				qtdEventosConsolidadoPre, qtdEventosNaoConsolidadaPre,
				qtdEventosConsolidadoPos, qtdEventosNaoConsolidadoPos);

		return historicoEventos;
	}

	public static List<DadosExpurgo> uploadListExpurgo(String caminhoArq)
			throws ErroAplicacao {
		Arquivo arquivo = new Arquivo(caminhoArq);

		List<DadosExpurgo> expurgoList = new ArrayList<DadosExpurgo>();

		try {

			arquivo.openTextFile();
			while (arquivo.next()) {
				String linha = arquivo.readLine();
				// quebrando alinha por caracter ';'
				String[] vDados = linha.split("[;]");
				final String nomeTabela = vDados[0].replace("\"", "")
						.toUpperCase();
				final int qtdRegistros = Integer.parseInt(vDados[1].replace(
						"\"", ""));
				DadosExpurgo t = new DadosExpurgo(nomeTabela, qtdRegistros);
				expurgoList.add(t);
			}

			return expurgoList;

		} catch (IOException e) {
			throw new ErroAplicacao("Arquivo não encontrado no caminho: "
					+ caminhoArq);
		}
	}

	public static boolean verificaEhReenvio(String caminhoArq) {
		Arquivo arquivo = new Arquivo(caminhoArq);

		try {

			arquivo.openTextFile();
			while (arquivo.next()) {
				String linha = arquivo.readLine();
				if (linha.contains("QryRef")) {
					return true;
				}
			}

		} catch (IOException e) {
			System.out
					.println("Não foi possível verificar se era reenvio: Arquivo não encontrado no caminho: "
							+ caminhoArq);
		}
		return false;
	}

	public static List<DadosExpurgo> uploadLogExpurgo(String caminhoArq)
			throws Exception {
		Arquivo arquivo = new Arquivo(caminhoArq);

		List<DadosExpurgo> expurgoList = new ArrayList<DadosExpurgo>();

		try {

			arquivo.openTextFile();
			int j = 0;
			while (j < 4) {
				arquivo.readLine();
				j++;
			}
			while (arquivo.next()) {

				final String nomeTabela = verificaFimInicio(arquivo, false)
						.toUpperCase();
				final String qtdRegistrosSt = verificaFimInicio(arquivo, true)
						.trim();

				int parseInt = 0;
				try {
					parseInt = Integer.parseInt(qtdRegistrosSt);
					DadosExpurgo t = new DadosExpurgo(nomeTabela, parseInt);
					expurgoList.add(t);
				} catch (Exception e) {
					System.out.println(e);
					throw e;
				}

			}

			return expurgoList;

		} catch (IOException e) {
			throw new ErroAplicacao("Arquivo não encontrado no caminho: "
					+ caminhoArq);
		}
	}

	public static String verificaFimInicio(Arquivo arquivo, boolean qtd)
			throws IOException {
		String linha = arquivo.readLine();
		if (qtd) {
			int i = 0;
			while (i < 2) {
				if (linha.toUpperCase().contains("FIM")) {
					System.out.println("4");
				}
				linha = arquivo.readLine();
				i++;
			}
		} else {
			int i = 0;
			while (i < 3) {
				linha = arquivo.readLine();
				i++;
			}
		}
		linha = arquivo.readLine();
		return linha;
	}

	public static void alterarTagXMLComPreTag(String arquivo, String preTag,
			String valor) {
		alterarTagXMLComPreTag(arquivo, preTag, valor, 1);
	}

	public static void alterarTagXMLComPreTag(String arquivo, String preTag,
			String valor, int usarOcorrencia) {
		try {
			String arquivoTmp = arquivo.replace(".xml", "").concat("-temp.xml");

			BufferedReader reader = null;

			BufferedWriter writer = new BufferedWriter(new FileWriter(
					arquivoTmp));
			try {
				reader = new BufferedReader(new FileReader(arquivo));
			} catch (Exception e) {
				Assert.fail("Favor copiar o arquivo " + arquivo
						+ " da pasta de backup");
			}

			String linha;
			int ocorrencia = 0;
			while ((linha = reader.readLine()) != null) {
				if (linha.contains(preTag)) {
					ocorrencia++;
					if (ocorrencia == usarOcorrencia) {
						writer.write(linha + "\n");
						linha = reader.readLine();
						final int begin = linha.indexOf(">") + 1;
						final int end = linha.indexOf("<", begin);

						String valorAntigo = linha.substring(begin, end);
						linha = linha.replace(valorAntigo, valor);
					}
				}
				writer.write(linha + "\n");
			}

			writer.close();
			reader.close();

			new File(arquivo).delete();
			new File(arquivoTmp).renameTo(new File(arquivo));

		} catch (Exception e) {
			Assert.fail("Problema com a alteracao do arquivo " + arquivo + " "
					+ e.getMessage());
		}
	}

	public static void alterarTagXML(String arquivo, String tag, String valor) {
		try {
			String arquivoTmp = arquivo.replace(".xml", "").concat("-temp.xml");

			BufferedWriter writer = new BufferedWriter(new FileWriter(
					arquivoTmp));
			BufferedReader reader = new BufferedReader(new FileReader(arquivo));

			String linha;
			while ((linha = reader.readLine()) != null) {
				if (linha.contains(tag)) {
					final int begin = linha.indexOf(">") + 1;
					final int end = linha.indexOf("<", begin);

					String valorAntigo = linha.substring(begin, end);
					linha = linha.replace(valorAntigo, valor);
				}
				writer.write(linha + "\n");
			}

			writer.close();
			reader.close();

			new File(arquivo).delete();
			new File(arquivoTmp).renameTo(new File(arquivo));
		} catch (Exception e) {
			Assert.fail("Problema com a alteracao do arquivo " + arquivo + " "
					+ e.getMessage());
		}
	}

	public static void descomentarTagXML(String arquivo, String tag,
			int usarOcorrencia) {
		try {
			String arquivoTmp = arquivo.replace(".xml", "").concat("-temp.xml");

			BufferedWriter writer = new BufferedWriter(new FileWriter(
					arquivoTmp));
			BufferedReader reader = new BufferedReader(new FileReader(arquivo));

			int ocorrencia = 0;
			String linha;
			while ((linha = reader.readLine()) != null) {
				if (linha.contains(tag)) {
					ocorrencia++;
					if (ocorrencia == usarOcorrencia) {
						linha = linha.replace("<!--", "");
						linha = linha.replace("-->", "");
					}
				}
				writer.write(linha + "\n");
			}

			writer.close();
			reader.close();

			new File(arquivo).delete();
			new File(arquivoTmp).renameTo(new File(arquivo));
		} catch (Exception e) {
			Assert.fail("Problema com a alteracao do arquivo " + arquivo + " "
					+ e.getMessage());
		}
	}

	public static void comentarTagXML(String arquivo, String tag,
			int usarOcorrencia) {
		try {
			String arquivoTmp = arquivo.replace(".xml", "-temp.xml");

			BufferedWriter writer = new BufferedWriter(new FileWriter(
					arquivoTmp));
			BufferedReader reader = new BufferedReader(new FileReader(arquivo));

			int ocorrencia = 0;
			String linha;
			while ((linha = reader.readLine()) != null) {
				if (linha.contains(tag)) {
					ocorrencia++;
					if (ocorrencia == usarOcorrencia && !linha.contains("<!--")) {
						linha = "<!--" + linha + "-->";
					}
				}
				writer.write(linha + "\n");
			}

			writer.close();
			reader.close();

			new File(arquivo).delete();
			new File(arquivoTmp).renameTo(new File(arquivo));
		} catch (Exception e) {
			Assert.fail("Problema com a alteracao do arquivo " + arquivo + " "
					+ e.getMessage());
		}
	}

	public static String getValorColuna(Teste teste, String caminhoArq,
			boolean obrigatorio, int idColuna, int ocorrencia) {

		try {
			return getColunaAbaAuxiliar(teste, caminhoArq, idColuna,
					obrigatorio, ocorrencia);
		} catch (Exception e) {
			Assert.fail("Erro ao obter a coluna " + idColuna + " [arquivo="
					+ caminhoArq + "]" + e.getMessage());
			return null;
		}

	}

	public static String getValorColuna(Teste teste, String caminhoArq,
			int idColuna, int ocorrencia) {

		try {
			return getColunaAbaAuxiliar(teste, caminhoArq, idColuna, true,
					ocorrencia);
		} catch (Exception e) {
			Assert.fail("Erro ao obter a coluna " + idColuna + " [arquivo="
					+ caminhoArq + "]");
			return null;
		}

	}

	public static String getValorColuna(Teste teste, String caminhoArq,
			int idColuna) {
		try {
			return getColunaAbaAuxiliar(teste, caminhoArq, idColuna, true, 1);
		} catch (Exception e) {
			Assert.fail("Erro ao obter a coluna da Aba auxiliar! [arquivo="
					+ caminhoArq + "]");
			return null;
		}
	}

	public static String getLogin(Teste teste, String caminhoArq) {
		try {
			return getColunaAbaCorrente(teste, caminhoArq, 1);
		} catch (Exception e) {
			Assert.fail("Erro  ao pegar o login! [arquivo=" + caminhoArq + "]");
			return null;
		}
	}

	public static String getAba(Teste teste, String caminhoArq) {
		try {
			return getColunaAbaCorrente(teste, caminhoArq, 3);
		} catch (Exception e) {
			Assert.fail("Erro ao pegar a aba! [arquivo=" + caminhoArq + "]");
			return null;
		}
	}

	public static String getSenha(Teste teste, String caminhoArq) {
		try {
			return getColunaAbaCorrente(teste, caminhoArq, 2);
		} catch (Exception e) {
			Assert.fail("Erro ao pegar a senha! [arquivo=" + caminhoArq + "]");
			return null;
		}
	}

	private static String getColunaAbaAuxiliar(Teste teste, String caminhoArq,
			int idColuna, boolean ehObrigatorio, int ocorrencia)
			throws ErroAplicacao {
		String idTesteProcurado = "";
		String abaBusca = "";
		int qtdOcorrencia = 0;
		try {
			String retorno = "";
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			abaBusca = getColunaAbaCorrente(teste, caminhoArq, 3);

			XSSFSheet worksheet = workbook.getSheet(abaBusca);

			int linhaCorrente = worksheet.getFirstRowNum() + 1;
			final int ultimaLinha = worksheet.getLastRowNum();
			while (linhaCorrente <= ultimaLinha) {
				XSSFRow linha = worksheet.getRow(linhaCorrente);
				XSSFCell colunaIdTeste = linha.getCell(0);
				String idTeste = "";
				try {
					idTesteProcurado = colunaIdTeste.getStringCellValue();
				} catch (Exception e) {
					idTesteProcurado = String.valueOf(
							colunaIdTeste.getNumericCellValue()).replace(".0",
							"");
				}
				idTeste = teste.getId();
				if (idTeste.equals(idTesteProcurado)) {
					qtdOcorrencia++;
					if (qtdOcorrencia == ocorrencia) {
						XSSFCell colunaBuscada = linha.getCell(idColuna);
						if (colunaBuscada != null) {
							try {
								retorno = colunaBuscada.getStringCellValue();
							} catch (Exception e) {
								retorno = String.valueOf(colunaBuscada
										.getNumericCellValue());
							}
						}
						break;
					}
				}
				linhaCorrente++;
			}

			if (retorno.equals("") && ehObrigatorio) {
				Assert.fail("Favor incluir o teste " + idTesteProcurado
						+ " na aba " + abaBusca + ".");
			}
			return retorno;
		} catch (FileNotFoundException e) {
			throw new ErroAplicacao(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
		} catch (Exception e) {
			throw new ErroAplicacao(MensagemErro.EXCEL_ERRO
					+ "Favor incluir o teste " + idTesteProcurado + " na aba "
					+ abaBusca + ".");
		}
	}

	public static boolean getColunaBooleana(XSSFSheet worksheet, int coluna,
			int linhaCorrente) {
		String colunaSt = getLinhaAbaCorrente(worksheet, coluna, linhaCorrente);

		if (colunaSt.equalsIgnoreCase("NÃO") || colunaSt.equals("")) {
			return false;
		}
		return true;
	}

	public static String getLinhaAbaCorrente(XSSFSheet worksheet, int idColuna,
			int linhaCorrente) {

		XSSFRow linha = worksheet.getRow(linhaCorrente);
		XSSFCell coluna = linha.getCell(idColuna);
		if (coluna != null) {
			return coluna.getStringCellValue();
		}
		return "";
	}

	public static List<String> getColunaListaAbaCorrente(XSSFSheet worksheet,
			int idColuna, int linhaInicial) {
		List<String> lista = new ArrayList<String>();

		int linhaCorrente = linhaInicial;
		final int ultimaLinha = worksheet.getLastRowNum();
		while (linhaCorrente <= ultimaLinha) {
			XSSFRow linha = worksheet.getRow(linhaCorrente);
			if (linha != null) {
				XSSFCell coluna1 = linha.getCell(0);
				String valorColuna1 = "";
				if (coluna1 != null) {
					valorColuna1 = coluna1.getStringCellValue();
				}
				XSSFCell colunaProcurada = linha.getCell(idColuna);

				String valorColuna = "";
				if (colunaProcurada != null) {
					valorColuna = colunaProcurada.getStringCellValue();
				}
				if (valorColuna1.equals("") && valorColuna.equals("")) {
					break;
				}
				lista.add(valorColuna);
			} else {
				break;
			}
			linhaCorrente++;
		}

		return lista;
	}

	public static String getColunaAbaCorrente(Teste teste, String caminhoArq,
			int idColuna) {
		try {
			String retorno = "";
			String idTesteProcurado = "";
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			Ambiente ambiente = teste.getAmbiente();
			XSSFSheet worksheet = workbook.getSheet(ambiente.getDesc());

			int linhaCorrente = worksheet.getFirstRowNum() + 1;
			final int ultimaLinha = worksheet.getLastRowNum();
			while (linhaCorrente <= ultimaLinha) {
				XSSFRow linha = worksheet.getRow(linhaCorrente);
				XSSFCell colunaIdTeste = linha.getCell(0);
				String idTeste = "";
				try {
					idTeste = String.valueOf((int) colunaIdTeste
							.getNumericCellValue());
				} catch (Exception e) {
					idTeste = colunaIdTeste.getStringCellValue();
				}
				idTesteProcurado = teste.getId();
				if (idTeste.equals(idTesteProcurado)) {
					XSSFCell coluna = linha.getCell(idColuna);
					retorno = coluna.getStringCellValue();
					break;
				}
				linhaCorrente++;
			}

			if (retorno.equals("")) {
				Assert.fail("Favor incluir o teste " + idTesteProcurado
						+ " na aba " + ambiente.getDesc() + ".");
			}
			return retorno;
		} catch (FileNotFoundException e) {
			Assert.fail(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
		} catch (Exception e) {
			Assert.fail(MensagemErro.EXCEL_ERRO);
		}
		return null;
	}

	public static List<Teste> getListaTeste(Ambiente ambiente,
			String caminhoArq, String aba, int linhaInicial, int idColunaGrupo,
			int idColunaServico, int idColunaCanal, int idColunaId,
			int idColunaOperacao, int idColunaDescricao, int idColunaReteste) {
		try {
			List<Teste> listaTeste = new ArrayList<Teste>();
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(aba);

			int linhaCorrente = linhaInicial;
			final int ultimaLinha = worksheet.getLastRowNum();
			while (linhaCorrente <= ultimaLinha) {
				XSSFRow linha = worksheet.getRow(linhaCorrente);

				XSSFCell colunaGrupo = linha.getCell(idColunaGrupo);
				XSSFCell colunaServico = linha.getCell(idColunaServico);
				XSSFCell colunaCanal = linha.getCell(idColunaCanal);
				XSSFCell colunaId = linha.getCell(idColunaId);
				XSSFCell colunaOperacao = linha.getCell(idColunaOperacao);
				XSSFCell colunaDescricao = linha.getCell(idColunaDescricao);
				XSSFCell colunaReteste = linha.getCell(idColunaReteste);

				if (colunaGrupo != null) {
					Grupo grupo = getGrupo(colunaGrupo);
					Servico servico = getServico(colunaServico);
					Canal canal = getCanal(colunaCanal);
					String id = getId(colunaId);
					Operacao operacao = getOperacao(colunaOperacao);
					String desc = getDescricao(colunaDescricao);
					int qtdReteste = getReteste(colunaReteste);

					Teste teste = new Teste(ambiente, grupo, servico, operacao,
							canal, id, desc, qtdReteste);
					listaTeste.add(teste);
					linhaCorrente++;
				} else {
					break;
				}
			}

			return listaTeste;
		} catch (FileNotFoundException e) {
			Assert.fail(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
			return null;
		} catch (IOException e) {
			Assert.fail(MensagemErro.EXCEL_ERRO);
			return null;
		}
	}

	private static Grupo getGrupo(XSSFCell colunaGrupo) {
		Grupo grupo = Grupo.fromDesc(colunaGrupo.getStringCellValue());
		return grupo;
	}

	private static Servico getServico(XSSFCell colunaServico) {
		if (!colunaServico.getStringCellValue().equals("")) {
			Servico servico = Servico.fromDesc(colunaServico
					.getStringCellValue());
			return servico;
		}
		return null;
	}

	private static Canal getCanal(XSSFCell colunaCanal) {
		Canal canal = Canal.fromDesc(colunaCanal.getStringCellValue());
		return canal;
	}

	private static String getId(XSSFCell colunaId) {
		String id = "";
		try {
			id = String.valueOf((int) colunaId.getNumericCellValue());
		} catch (Exception e) {
			id = colunaId.getStringCellValue();
		}
		return id;
	}

	private static String getDescricao(XSSFCell colunaDescricao) {
		String desc = colunaDescricao.getStringCellValue();
		return desc;
	}

	private static Operacao getOperacao(XSSFCell colunaOperacao) {
		String valor;
		try {
			valor = colunaOperacao.getStringCellValue();
		} catch (Exception e) {
			valor = String.valueOf(colunaOperacao.getNumericCellValue());
		}
		Operacao operacao = Operacao.fromValor(valor);
		return operacao;
	}

	private static int getReteste(XSSFCell colunaReteste) {
		int qtdReteste = 1;
		if (colunaReteste != null) {
			try {
				qtdReteste = (int) colunaReteste.getNumericCellValue();
			} catch (Exception e) {
				qtdReteste = Integer.parseInt(colunaReteste
						.getStringCellValue());
			}
		}
		return qtdReteste;
	}

	public static void atualizarArquivoSalvarExtrato(String path,
			String dataBase, String codigoSTI, String codSTICotista,
			Operacao operacao) throws ParseException {
		final String pathArquivo = ConfiguracaoSistema.getPathArquivo(path,
				false);
		atualizarFundoExtrato(pathArquivo, codigoSTI);
		atualizarCotistaExtrato(pathArquivo, codSTICotista);
		atualizarDataBaseExtrato(pathArquivo, dataBase);
		atualizarDataBaseAnteriorExtrato(pathArquivo, dataBase);
		atualizarOperacaoExtrato(operacao, pathArquivo);
		atualizarValorExtrato(pathArquivo, TelaEnvio.VALOR_ENVIO);
		comentarJustificativaExtrato(pathArquivo);
		if (Operacao.REENVIO_INFORMES == operacao
				|| Operacao.CANCELA_INFORMES == operacao) {
			atualizarValorExtrato(pathArquivo, TelaEnvio.VALOR_REENVIO);
			descomentarJustificativaExtrato(pathArquivo);
		}
	}

	public static void atualizarArquivoSalvarPosicao(String path,
			String dataBase, String codigoSTI, Operacao operacao) {
		final String pathArquivo = ConfiguracaoSistema.getPathArquivo(path,
				false);
		atualizarDataBasePosicao(dataBase, pathArquivo);
		atualizarFundoPosicao(codigoSTI, pathArquivo);
		atualizarOperacaoPosicao(operacao, pathArquivo);
		atualizarValorCota(pathArquivo, operacao);
		comentarJustificativaPosicao(pathArquivo);
		if (Operacao.CANCELA_INFORMES == operacao
				|| Operacao.REENVIO_INFORMES == operacao) {
			descomentarJustificativaPosicao(pathArquivo);
		}
	}

	private static void atualizarValorCota(String path, Operacao operacao) {
		String valor = "";
		if (Operacao.ENVIO_INFORMES == operacao) {
			valor = TelaEnvio.VALOR_ENVIO;
		} else {
			valor = TelaEnvio.VALOR_REENVIO;
		}
		alterarTagXMLComPreTag(path, "<Val>", valor);
	}

	private static void descomentarJustificativaPosicao(final String pathArquivo) {
		descomentarTagXML(pathArquivo, "<StmtId>", 1);
	}

	private static void comentarJustificativaPosicao(final String pathArquivo) {
		comentarTagXML(pathArquivo, "<StmtId>", 1);
	}

	private static void atualizarOperacaoPosicao(Operacao operacao,
			final String pathArquivo) {
		alterarTagXML(pathArquivo, "<QryRef>", operacao.getTipoOperXML());
	}

	private static void atualizarFundoPosicao(String codigoSTI,
			final String pathArquivo) {
		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<OthrId>", codigoSTI);
	}

	private static void atualizarDataBasePosicao(String dataBase,
			final String pathArquivo) {
		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<StmtDtTm>",
				DataUtils.getDataBaseXML(dataBase));
	}

	private static void descomentarJustificativaExtrato(final String pathArquivo) {
		descomentarTagXML(pathArquivo, "<urn:Issr>", 2);
	}

	private static void comentarJustificativaExtrato(final String pathArquivo) {
		comentarTagXML(pathArquivo, "<urn:Issr>", 2);
	}

	private static void atualizarOperacaoExtrato(Operacao operacao,
			final String pathArquivo) {
		alterarTagXMLComPreTag(pathArquivo, "<urn:Strd>",
				operacao.getTipoOperXML());
	}

	private static void atualizarValorExtrato(final String pathArquivo,
			String valor) {
		alterarTagXML(pathArquivo, "<urn:NetAmt", valor);
	}

	public static void atualizarDataBaseAnteriorExtrato(
			final String pathArquivo, String dataBase) throws ParseException {
		String dataBaseAnterior = DataUtils.getDataBaseAnterior(dataBase);
		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<urn:PrvsTradDtTm>",
				dataBaseAnterior);

		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo,
				"<urn:NetCshFcstDtls>", dataBaseAnterior);

		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<urn:CshOutFcst>",
				dataBaseAnterior);

		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<urn:NetCshFcst>",
				dataBaseAnterior);
	}

	public static void atualizarFundoExtrato(final String pathArquivo,
			String codigoSTI) {
		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<urn:OthrPrtryId>",
				codigoSTI);
	}

	public static void atualizarCotistaExtrato(final String pathArquivo,
			String codSTICotista) {
		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<urn:PrtryId>",
				codSTICotista);
	}

	public static void atualizarDataBaseExtrato(final String pathArquivo,
			String dataBase) {
		dataBase = DataUtils.getDataBaseXML(dataBase);
		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<urn:TradDtTm>",
				dataBase);

		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo,
				"<urn:NetCshFcstDtls>", dataBase, 2);

		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<urn:CshOutFcst>",
				dataBase, 2);

		ArquivoUtils.alterarTagXMLComPreTag(pathArquivo, "<urn:NetCshFcst>",
				dataBase, 2);
	}
}
