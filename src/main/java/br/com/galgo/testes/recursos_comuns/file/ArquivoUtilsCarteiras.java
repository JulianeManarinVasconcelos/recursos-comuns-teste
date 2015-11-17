package br.com.galgo.testes.recursos_comuns.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.carteira.AvaliadorRisco;
import br.com.galgo.testes.recursos_comuns.enumerador.carteira.TipoCarteira;
import br.com.galgo.testes.recursos_comuns.enumerador.carteira.TipoCota;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Administrador;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.CategoriaAnbid;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Controlador;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Custodiante;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Gestor;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Idioma;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PublicoAlvo;
import br.com.galgo.testes.recursos_comuns.exception.MensagemErro;
import br.com.galgo.testes.recursos_comuns.file.entidades.Carteira;
import br.com.galgo.testes.recursos_comuns.file.entidades.DoctosAnexadosCarteira;
import br.com.galgo.testes.recursos_comuns.file.entidades.IdentificacaoCarteira;
import br.com.galgo.testes.recursos_comuns.file.entidades.PerfilCarteira;
import br.com.galgo.testes.recursos_comuns.file.entidades.PrestadoresServicoCarteira;
import br.com.galgo.testes.recursos_comuns.file.entidades.Teste;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesCarteiras;

public class ArquivoUtilsCarteiras {

	public static List<Carteira> getCarteiras(Teste teste, String caminhoArq,
			String aba) {
		try {
			List<Carteira> listaCarteiras = new ArrayList<Carteira>();
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(aba);

			int linhaInicial = worksheet.getFirstRowNum() + 1;
			int linhaFinal = worksheet.getLastRowNum();

			int linhaCorrente = linhaInicial;

			while (linhaCorrente <= linhaFinal) {
				boolean linhaEmbranco = isLinhaEmbranco(worksheet,
						linhaCorrente);

				if (linhaEmbranco) {
					linhaCorrente++;
				}

				if (!fimdeArquivo(worksheet, linhaCorrente)) {
					IdentificacaoCarteira identificacaoCarteira = getIdentificao(
							worksheet, linhaCorrente);
					PerfilCarteira perfilCarteira = getPerfil(worksheet,
							linhaCorrente);
					String dataInicioAtividade = getDataInicioAtividade(
							worksheet, linhaCorrente);
					PrestadoresServicoCarteira prestadoresServicoCarteira = getPrestadoresServico(
							worksheet, linhaCorrente);
					String codSUSEP = getCodSusep(worksheet, linhaCorrente);
					boolean divulgacaoAnbid = getDivulgacaoAnbid(worksheet,
							linhaCorrente);
					DoctosAnexadosCarteira doctosAnexadosCarteira = getDoctosAnexados(
							worksheet, linhaCorrente);
					boolean validacaoInclusao = getValidacaoInclusao(worksheet,
							linhaCorrente);

					Carteira carteira = new Carteira(identificacaoCarteira,
							perfilCarteira, dataInicioAtividade,
							prestadoresServicoCarteira, codSUSEP,
							divulgacaoAnbid, doctosAnexadosCarteira,
							validacaoInclusao);

					listaCarteiras.add(carteira);
					linhaCorrente++;
				}
			}
			return listaCarteiras;
		} catch (FileNotFoundException e) {
			Assert.fail(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
			return null;
		} catch (Exception e) {
			Assert.fail(MensagemErro.EXCEL_ERRO + e.getMessage());
			return null;
		}
	}

	private static boolean getValidacaoInclusao(XSSFSheet worksheet,
			int linhaCorrente) {
		boolean validacaoInclusao = ArquivoUtils.getColunaBooleana(worksheet,
				ConstantesCarteiras.COLUNA_VALIDACAO_INCLUSAO, linhaCorrente);
		return validacaoInclusao;
	}

	private static boolean getDivulgacaoAnbid(XSSFSheet worksheet,
			int linhaCorrente) {
		boolean divulgacaoAnbid = ArquivoUtils.getColunaBooleana(worksheet,
				ConstantesCarteiras.COLUNA_DIVULGACAO_ANBID, linhaCorrente);
		return divulgacaoAnbid;
	}

	private static String getCodSusep(XSSFSheet worksheet, int linhaCorrente) {
		return ArquivoUtils.getLinhaAbaCorrente(worksheet,
				ConstantesCarteiras.COLUNA_COD_SUSEP, linhaCorrente);
	}

	private static String getDataInicioAtividade(XSSFSheet worksheet,
			int linhaCorrente) {
		String dataInicioAtividade = ArquivoUtils.getLinhaAbaCorrente(
				worksheet, ConstantesCarteiras.COLUNA_DATA_INICIO_ATIVIDADE,
				linhaCorrente);
		return dataInicioAtividade;
	}

	private static boolean fimdeArquivo(XSSFSheet worksheet, int linhaCorrente) {
		return isLinhaEmbranco(worksheet, linhaCorrente);
	}

	private static boolean isLinhaEmbranco(XSSFSheet worksheet,
			int linhaCorrente) {
		XSSFRow linha = worksheet.getRow(linhaCorrente);
		if (linha != null) {
			XSSFCell coluna = linha.getCell(0);
			if (coluna != null) {
				if (!coluna.getStringCellValue().equals("")) {
					return false;
				}
			}
		}
		return true;
	}

	private static DoctosAnexadosCarteira getDoctosAnexados(
			XSSFSheet worksheet, int linhaCorrente) {

		String contratoAdministracao = ArquivoUtils.getLinhaAbaCorrente(
				worksheet, ConstantesCarteiras.COLUNA_CONTRATO, linhaCorrente);
		Idioma idiomaContratoAdministracao = Idioma.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_IDIOMA_CONTRATO,
						linhaCorrente));

		String outrosDoctos = ArquivoUtils.getLinhaAbaCorrente(worksheet,
				ConstantesCarteiras.COLUNA_OUTROS_DOCTOS, linhaCorrente);
		Idioma idiomaOutrosDoctos = Idioma.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_IDIOMA_OUTROS_DOCTOS,
						linhaCorrente));

		return new DoctosAnexadosCarteira(contratoAdministracao,
				idiomaContratoAdministracao, outrosDoctos, idiomaOutrosDoctos);
	}

	private static PerfilCarteira getPerfil(XSSFSheet worksheet,
			int linhaCorrente) {
		TipoCota calculoCotas = TipoCota
				.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_CALCULO_COTA, linhaCorrente));
		String horarioCompPlCota = ArquivoUtils.getLinhaAbaCorrente(worksheet,
				ConstantesCarteiras.COLUNA_HORARIO_PL_COTA, linhaCorrente);
		String horarioCompPosiaco = ArquivoUtils.getLinhaAbaCorrente(worksheet,
				ConstantesCarteiras.COLUNA_HORARIO_POSICAO, linhaCorrente);
		CategoriaAnbid categoriaAnbid = CategoriaAnbid.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_CATEGORIA_ANBID,
						linhaCorrente));
		PublicoAlvo tipoIvestidor = PublicoAlvo.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_TIPO_INVESTIDOR,
						linhaCorrente));

		return new PerfilCarteira(calculoCotas, horarioCompPlCota,
				horarioCompPosiaco, categoriaAnbid, tipoIvestidor);
	}

	private static PrestadoresServicoCarteira getPrestadoresServico(
			XSSFSheet worksheet, int linhaCorrente) {
		Administrador administrador = Administrador
				.fromDesc(ArquivoUtils
						.getLinhaAbaCorrente(worksheet,
								ConstantesCarteiras.COLUNA_ADMINISTRADOR,
								linhaCorrente));
		AvaliadorRisco avaliadorRisco = AvaliadorRisco.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_AVALIADOR_RISCO,
						linhaCorrente));
		Controlador controladorAtivo = Controlador.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_CONTROLADOR_ATIVOS,
						linhaCorrente));
		Custodiante custodianteUnico = Custodiante.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_CUSTODIANTES_UNICO,
						linhaCorrente));
		Custodiante custodianteCotas = Custodiante.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_CUSTODIANTE_COTAS,
						linhaCorrente));
		Custodiante custodianteDerivativos = Custodiante.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_CUSTODIANTE_DERIVATIVOS,
						linhaCorrente));
		Custodiante custodiantesRendaFixa = Custodiante.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_CUSTODIANTES_RENDA_FIXA,
						linhaCorrente));
		Custodiante custodianteRendaVariavel = Custodiante
				.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_CUSTODIANTE_RENDA_VARIAVEL,
						linhaCorrente));
		Gestor gestorUnico = Gestor.fromDesc(ArquivoUtils.getLinhaAbaCorrente(
				worksheet, ConstantesCarteiras.COLUNA_GESTOR_UNICO,
				linhaCorrente));
		Gestor gestorCotas = Gestor.fromDesc(ArquivoUtils.getLinhaAbaCorrente(
				worksheet, ConstantesCarteiras.COLUNA_GESTOR_COTAS,
				linhaCorrente));
		Gestor gestorDerivativos = Gestor.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_GESTOR_DERIVATIVOS,
						linhaCorrente));
		Gestor gestorRendaFixa = Gestor.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_GESTOR_RENDA_FIXA,
						linhaCorrente));
		Gestor gestorRendaVariavel = Gestor.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_GESTOR_RENDA_VARIAVEL,
						linhaCorrente));

		return new PrestadoresServicoCarteira(administrador, avaliadorRisco,
				controladorAtivo, custodianteUnico, custodianteCotas,
				custodianteDerivativos, custodiantesRendaFixa,
				custodianteRendaVariavel, gestorUnico, gestorCotas,
				gestorDerivativos, gestorRendaFixa, gestorRendaVariavel);
	}

	private static IdentificacaoCarteira getIdentificao(XSSFSheet worksheet,
			int linhaCorrente) {

		TipoCarteira tipo = TipoCarteira.fromDesc(ArquivoUtils
				.getLinhaAbaCorrente(worksheet,
						ConstantesCarteiras.COLUNA_TIPO, linhaCorrente));
		String docto = ArquivoUtils.getLinhaAbaCorrente(worksheet,
				ConstantesCarteiras.COLUNA_DOCTO, linhaCorrente);
		String nome = ArquivoUtils.getLinhaAbaCorrente(worksheet,
				ConstantesCarteiras.COLUNA_NOME, linhaCorrente);
		String nomeFantasia = ArquivoUtils.getLinhaAbaCorrente(worksheet,
				ConstantesCarteiras.COLUNA_NOME_FANTASIA, linhaCorrente);
		String sigla = ArquivoUtils.getLinhaAbaCorrente(worksheet,
				ConstantesCarteiras.COLUNA_SIGLA, linhaCorrente);

		return new IdentificacaoCarteira(tipo, docto, nome, nomeFantasia, sigla);
	}

}
