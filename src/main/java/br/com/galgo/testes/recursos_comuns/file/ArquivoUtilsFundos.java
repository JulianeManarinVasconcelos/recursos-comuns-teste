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

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Administrador;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.AgenciaClassificacaoRisco;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.AplicacaoAutomatica;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Auditoria;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.BancoContaCorrente;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.BaseDuracaoFundo;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.CategoriaAnbid;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.ClassificacaoCVM;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Composicao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Consultoria;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Contabilidade;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Controlador;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.CreditoPrivado;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Custodiante;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.DataBaseAmortizacao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Distribuidor;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.EmpresaAvaliacaoRisco;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.EscrituradorCotas;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.FocoAtuacao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Gestor;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Idioma;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.IndicadorTaxaComposta;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Indice;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.InvestimentoExterior;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PerfilTaxaAdministracao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PerioCobranca;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PeriodicidadeAmortizacao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PeriodicidadeDivulgacao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PeriodoCorrecao;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PlBaseCalculoTaxaPerfor;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PlanoPrevidencia;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PublicoAlvo;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.RestricaoInvestimento;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.TipoAnbid;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.TipoTaxa;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.TributacaoPerseguida;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.UnidadeDuracaoFundo;
import br.com.galgo.testes.recursos_comuns.enumerador.fundo.UnidadeTaxa;
import br.com.galgo.testes.recursos_comuns.exception.MensagemErro;
import br.com.galgo.testes.recursos_comuns.file.entidades.Amortizacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.Contas;
import br.com.galgo.testes.recursos_comuns.file.entidades.DatasFundos;
import br.com.galgo.testes.recursos_comuns.file.entidades.DoctosAnexadosFundos;
import br.com.galgo.testes.recursos_comuns.file.entidades.Evento;
import br.com.galgo.testes.recursos_comuns.file.entidades.EventoIncorporacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.EventoTrocaAdmin;
import br.com.galgo.testes.recursos_comuns.file.entidades.FaixasTaxas;
import br.com.galgo.testes.recursos_comuns.file.entidades.Fundo;
import br.com.galgo.testes.recursos_comuns.file.entidades.IdentificaoFundo;
import br.com.galgo.testes.recursos_comuns.file.entidades.ParametrosMovimentacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.PerfilFundo;
import br.com.galgo.testes.recursos_comuns.file.entidades.PrestadoresServicoFundo;
import br.com.galgo.testes.recursos_comuns.file.entidades.TaxaPerformance;
import br.com.galgo.testes.recursos_comuns.file.entidades.TaxasFundos;
import br.com.galgo.testes.recursos_comuns.file.entidades.Teste;
import br.com.galgo.testes.recursos_comuns.utils.ConstantesFundos;

public class ArquivoUtilsFundos {

	public static List<EventoTrocaAdmin> getEventoTrocaAdmin(Teste teste,
			String caminhoArq, String aba, Operacao operacao) {
		try {
			List<EventoTrocaAdmin> listaEventos = new ArrayList<EventoTrocaAdmin>();
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(operacao.getDescAba());

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
					String cnpj = ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CNPJ_ALTERACAO_ADMIN,
							linhaCorrente);
					Administrador administrador = Administrador
							.fromDesc(ArquivoUtils.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_NOVO_ADMIN,
									linhaCorrente));
					String dataEvento = ArquivoUtils.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_EVENTO_TROCA_ADMIN,
							linhaCorrente);

					EventoTrocaAdmin eventoTrocaAdmin = new EventoTrocaAdmin(
							cnpj, administrador, dataEvento);

					listaEventos.add(eventoTrocaAdmin);
					linhaCorrente++;
				}
			}
			return listaEventos;
		} catch (FileNotFoundException e) {
			Assert.fail(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
			return null;
		} catch (Exception e) {
			Assert.fail(MensagemErro.EXCEL_ERRO + e.getMessage());
			return null;
		}
	}

	public static List<EventoIncorporacao> getEventoIncorporacao(Teste teste,
			String caminhoArq, String aba, Operacao operacao) {
		try {
			List<EventoIncorporacao> listaEventos = new ArrayList<EventoIncorporacao>();
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(operacao.getDescAba());

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
					String cnpjOrigem = ArquivoUtils.getLinhaAbaCorrente(
							worksheet, ConstantesFundos.COLUNA_CNPJ_ORIGEM,
							linhaCorrente);
					String cnpjDestino = ArquivoUtils.getLinhaAbaCorrente(
							worksheet, ConstantesFundos.COLUNA_NOVO_DESTINO,
							linhaCorrente);
					String dataEvento = ArquivoUtils.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_EVENTO_INCORP,
							linhaCorrente);

					EventoIncorporacao eventoTrocaAdmin = new EventoIncorporacao(
							cnpjOrigem, cnpjDestino, dataEvento);

					listaEventos.add(eventoTrocaAdmin);
					linhaCorrente++;
				}
			}
			return listaEventos;
		} catch (FileNotFoundException e) {
			Assert.fail(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
			return null;
		} catch (Exception e) {
			Assert.fail(MensagemErro.EXCEL_ERRO + e.getMessage());
			return null;
		}
	}

	public static List<Fundo> getFundos(Teste teste, String caminhoArq,
			String aba, Operacao operacao) {
		try {
			List<Fundo> listaFundos = new ArrayList<Fundo>();
			FileInputStream fileInputStream = new FileInputStream(caminhoArq);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet worksheet = workbook.getSheet(operacao.getDescAba());

			int linhaInicial = worksheet.getFirstRowNum() + 2;
			int linhaFinal = worksheet.getLastRowNum();

			int linhaCorrente = linhaInicial;

			while (linhaCorrente <= linhaFinal) {
				boolean linhaEmbranco = isLinhaEmbranco(worksheet,
						linhaCorrente);

				if (linhaEmbranco) {
					linhaCorrente++;
				}

				if (!fimdeArquivo(worksheet, linhaCorrente)) {
					IdentificaoFundo identificaoFundo = getIdentificao(
							worksheet, linhaCorrente, operacao);
					Evento evento = getEvento(worksheet, linhaCorrente,
							operacao);
					PerfilFundo perfil = getPerfil(worksheet, linhaCorrente,
							operacao);
					DatasFundos datasFundos = getDatasFundos(worksheet,
							linhaCorrente, operacao);
					PrestadoresServicoFundo prestadoresServico = getPrestadoresServico(
							worksheet, linhaCorrente, operacao);
					TaxasFundos taxasFundos = getTaxasFundos(worksheet,
							linhaCorrente, operacao);
					ParametrosMovimentacao parametrosMovimentacao = getParametrosMovimentacao(
							worksheet, linhaCorrente, operacao);
					Amortizacao amortizacao = getAmortizacao(worksheet,
							linhaCorrente, operacao);
					Contas contas = getContas(worksheet, linhaCorrente,
							operacao);
					DoctosAnexadosFundos doctosAnexados = getDoctosAnexados(
							worksheet, linhaCorrente, operacao);
					Fundo fundo = new Fundo(identificaoFundo, evento, perfil,
							datasFundos, prestadoresServico, taxasFundos,
							parametrosMovimentacao, amortizacao, contas,
							doctosAnexados);

					listaFundos.add(fundo);
					linhaCorrente++;
				}
			}
			return listaFundos;
		} catch (FileNotFoundException e) {
			Assert.fail(MensagemErro.ARQUIVO_NAO_ENCONTRADO);
			return null;
		} catch (Exception e) {
			Assert.fail(MensagemErro.EXCEL_ERRO + e.getMessage());
			return null;
		}
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

	private static DoctosAnexadosFundos getDoctosAnexados(XSSFSheet worksheet,
			int linhaCorrente, Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			String ataAssembleia = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_ATA_ASSEMBLEIA, linhaCorrente);
			Idioma idiomaAtaAssembleia = Idioma.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_IDIOMA_ATA_ASSEMBLEIA,
							linhaCorrente));

			String cartaIsencao = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_CARTA_ISENCAO, linhaCorrente);
			Idioma idiomaCartaIsencao = Idioma.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_IDIOMA_CARTA_ISENCAO,
							linhaCorrente));

			String prospecto = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_PROSPECTO, linhaCorrente);
			Idioma idiomaProspecto = Idioma.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_IDIOMA_PROSPECTO,
							linhaCorrente));

			String regulamento = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_REGULAMENTO, linhaCorrente);
			Idioma idiomaRegulamento = Idioma.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_IDIOMA_REGULAMENTO,
							linhaCorrente));

			String outrosDoctos = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_OUTROS_DOCTOS, linhaCorrente);
			Idioma idiomaOutrosDoctos = Idioma.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_IDIOMA_OUTROS_DOCTOS,
							linhaCorrente));

			return new DoctosAnexadosFundos(ataAssembleia, idiomaAtaAssembleia,
					cartaIsencao, idiomaCartaIsencao, prospecto,
					idiomaProspecto, regulamento, idiomaRegulamento,
					outrosDoctos, idiomaOutrosDoctos);
		} else {
			boolean alteracaoImpactaBDAnbid = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_ALTERACAO_IMPACTA_BD_ANBID,
					linhaCorrente);

			String ataAssembleia = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_ATA_ASSEMBLEIA_ALTERACAO,
					linhaCorrente);
			Idioma idiomaAtaAssembleia = Idioma
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_IDIOMA_ATA_ASSEMBLEIA_ALTERACAO,
									linhaCorrente));
			boolean versaoAntAtaValida = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_VERSAO_ANTERIOR_VALIDA_ATA,
					linhaCorrente);

			String cartaIsencao = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_CARTA_ISENCAO, linhaCorrente);
			Idioma idiomaCartaIsencao = Idioma
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_IDIOMA_CARTA_ISENCAO_ALTERACAO,
									linhaCorrente));
			boolean versaoAntCartaValida = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_VERSAO_ANTERIOR_VALIDA_CARTA,
					linhaCorrente);

			String prospecto = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_PROSPECTO_ALTERACAO, linhaCorrente);
			Idioma idiomaProspecto = Idioma.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_IDIOMA_PROSPECTO,
							linhaCorrente));
			boolean versaoAntProspectoValida = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_VERSAO_ANTERIOR_VALIDA_PROSPECTO,
					linhaCorrente);

			String regulamento = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_REGULAMENTO_ALTERACAO,
					linhaCorrente);
			Idioma idiomaRegulamento = Idioma
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_IDIOMA_REGULAMENTO_ALTERACAO,
									linhaCorrente));
			boolean versaoAntRegulamentoValida = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_VERSAO_ANTERIOR_VALIDA_REGULAMENTO,
							linhaCorrente);

			String outrosDoctos = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_OUTROS_DOCTOS, linhaCorrente);
			Idioma idiomaOutrosDoctos = Idioma
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_IDIOMA_OUTROS_DOCTOS_ALTERACAO,
									linhaCorrente));
			boolean versaoAntOutrosDoctosValida = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_VERSAO_ANTERIOR_VALIDA_OUTROS_DOCTOS,
							linhaCorrente);

			return new DoctosAnexadosFundos(alteracaoImpactaBDAnbid,
					ataAssembleia, idiomaAtaAssembleia, versaoAntAtaValida,
					cartaIsencao, idiomaCartaIsencao, versaoAntCartaValida,
					prospecto, idiomaProspecto, versaoAntProspectoValida,
					regulamento, idiomaRegulamento, versaoAntRegulamentoValida,
					outrosDoctos, idiomaOutrosDoctos,
					versaoAntOutrosDoctosValida);
		}
	}

	private static Contas getContas(XSSFSheet worksheet, int linhaCorrente,
			Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			BancoContaCorrente bancoConstaCorrenteAplicacao = BancoContaCorrente
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_BANCO_CONSTA_CORRENTE_APLIC,
									linhaCorrente));
			String agenciaContaCorrenteAplicacao = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_AGENCIA_CONTA_CORRENTE_APLIC,
							linhaCorrente);
			String constaCorrenteAplicacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_CONSTA_CORRENTE_APLIC,
					linhaCorrente);
			String codSUSEP = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_COD_SUSEP, linhaCorrente);

			return new Contas(bancoConstaCorrenteAplicacao,
					agenciaContaCorrenteAplicacao, constaCorrenteAplicacao,
					codSUSEP);
		} else {
			BancoContaCorrente bancoConstaCorrenteAplicacao = BancoContaCorrente
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_BANCO_CONSTA_CORRENTE_APLIC_ALTERACAO,
									linhaCorrente));
			String agenciaContaCorrenteAplicacao = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_AGENCIA_CONTA_CORRENTE_APLIC_ALTERACAO,
							linhaCorrente);
			String constaCorrenteAplicacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_CONSTA_CORRENTE_APLIC_ALTERACAO,
					linhaCorrente);
			String codSUSEP = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_COD_SUSEP_ALTERACAO, linhaCorrente);

			return new Contas(bancoConstaCorrenteAplicacao,
					agenciaContaCorrenteAplicacao, constaCorrenteAplicacao,
					codSUSEP);
		}
	}

	private static Amortizacao getAmortizacao(XSSFSheet worksheet,
			int linhaCorrente, Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			boolean possuiMecanismoAmortizacao = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_POSSUI_MECANISMO_AMORTIZACAO,
							linhaCorrente);
			String dataPrimeiraAmortizacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_PRIMEIRA_AMORTIZACAO,
					linhaCorrente);
			PeriodicidadeAmortizacao periodicidadeAmortizacao = PeriodicidadeAmortizacao
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PERIODICIDADE_AMORTIZACAO,
							linhaCorrente));
			DataBaseAmortizacao dataBaseAmortizacao = DataBaseAmortizacao
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_DATA_BASE_AMORTIZACAO,
							linhaCorrente));
			String diaUtilAmortizacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DIA_UTIL_AMORTIZACAO,
					linhaCorrente);
			String observacoesAmortizacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_OBSERVACOES_AMORTIZACAO,
					linhaCorrente);

			return new Amortizacao(possuiMecanismoAmortizacao,
					dataPrimeiraAmortizacao, periodicidadeAmortizacao,
					dataBaseAmortizacao, diaUtilAmortizacao,
					observacoesAmortizacao);
		} else {
			boolean possuiMecanismoAmortizacao = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_POSSUI_MECANISMO_AMORTIZACAO_ALTERACAO,
							linhaCorrente);
			String dataPrimeiraAmortizacao = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_PRIMEIRA_AMORTIZACAO_ALTERACAO,
							linhaCorrente);
			PeriodicidadeAmortizacao periodicidadeAmortizacao = PeriodicidadeAmortizacao
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PERIODICIDADE_AMORTIZACAO_ALTERACAO,
									linhaCorrente));
			DataBaseAmortizacao dataBaseAmortizacao = DataBaseAmortizacao
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_DATA_BASE_AMORTIZACAO_ALTERACAO,
									linhaCorrente));
			String diaUtilAmortizacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DIA_UTIL_AMORTIZACAO_ALTERACAO,
					linhaCorrente);
			String observacoesAmortizacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_OBSERVACOES_AMORTIZACAO_ALTERACAO,
					linhaCorrente);

			return new Amortizacao(possuiMecanismoAmortizacao,
					dataPrimeiraAmortizacao, periodicidadeAmortizacao,
					dataBaseAmortizacao, diaUtilAmortizacao,
					observacoesAmortizacao);
		}
	}

	private static TaxasFundos getTaxasFundos(XSSFSheet worksheet,
			int linhaCorrente, Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			PerfilTaxaAdministracao perfilTaxaAdminstracao = PerfilTaxaAdministracao
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PERFIL_TAXA_ADMIN,
							linhaCorrente));
			UnidadeTaxa unidadeTaxaAdministracao = UnidadeTaxa
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_UNIDADE_TAXA_ADMIN,
							linhaCorrente));
			String valorTaxaAdminstracao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_VALOR_TAXA_ADMIN,
					linhaCorrente);
			String plBaseCalculoTaxa = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_PL_BASE_CALCULO_TAXA,
					linhaCorrente);
			String valorPiso = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_VALOR_PISO, linhaCorrente);
			Indice indiceCorrecao = Indice.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_INDICE_CORRECAO,
							linhaCorrente));
			PeriodoCorrecao periodoCorrecao = PeriodoCorrecao
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PERIODO_CORRECAO,
							linhaCorrente));
			boolean aplicaOutrosFundos = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_APLICAO_OUTROS_FUNDOS,
					linhaCorrente);
			String taxaMaxima = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_TAXA_MAXIMA, linhaCorrente);

			List<String> valorInicialPl = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_VALOR_INICIAL_PL,
							linhaCorrente);
			List<String> valorFinalPl = ArquivoUtils.getColunaListaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_VALOR_FINAL_PL,
					linhaCorrente);
			List<String> unidadeTaxaSt = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_UNIDADE_TAXA, linhaCorrente);
			List<UnidadeTaxa> unidadeTaxa = UnidadeTaxa
					.fromListDesc(unidadeTaxaSt);

			List<String> taxa = ArquivoUtils.getColunaListaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_TAXA, linhaCorrente);
			List<FaixasTaxas> faixasTaxas = FaixasTaxas.fromList(
					valorInicialPl, valorFinalPl, unidadeTaxa, taxa);

			PerioCobranca perioCobrancaTaxaAdmin = PerioCobranca
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PERIODO_COBR_TAXA_ADMIN,
							linhaCorrente));
			String infoAdicionaisTaxaNaoPadronizada = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INFO_ADICIONAL_TAXA_NAO_PADRONIZADA,
							linhaCorrente);
			boolean cobraTaxaPerformance = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_COBRA_TAXA_PERFORM,
					linhaCorrente);

			List<String> indicadorTaxaCompostaSt = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_INDICADOR_TAXA_COMPOSTA,
							linhaCorrente);
			List<IndicadorTaxaComposta> indicadorTaxaComposta = IndicadorTaxaComposta
					.fromListDesc(indicadorTaxaCompostaSt);

			List<String> percentual = ArquivoUtils.getColunaListaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_PERCENTUAL,
					linhaCorrente);
			List<String> porcentagemIndiceReferencia = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PORCENT_INDICE_REFERENCIA,
							linhaCorrente);
			List<String> indiceReferenciaSt = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_INDICE_REFERENCIA,
							linhaCorrente);
			List<Indice> indiceReferencia = Indice
					.fromListDesc(indiceReferenciaSt);

			List<TaxaPerformance> taxaPerformance = TaxaPerformance.fromList(
					indicadorTaxaComposta, percentual,
					porcentagemIndiceReferencia, indiceReferencia);

			String cupomTaxaPerfonce = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_CUPOM_TAXA_PERFORM,
					linhaCorrente);
			PerioCobranca perioCobrancaTaxaPerfor = PerioCobranca
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PERIOD_COBRANC_TAXA_PERFORM,
									linhaCorrente));
			PlBaseCalculoTaxaPerfor plBaseCalculoTaxaPerfor = PlBaseCalculoTaxaPerfor
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PL_BASE_CALCULO_TAXA_PERFORM,
									linhaCorrente));
			String diaUtilCalculoTaxaPerfor = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DIA_UTIL_CALCULO_TAXA_PERFORM,
					linhaCorrente);
			boolean linhaDagua = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_LINHA_DAGUA, linhaCorrente);
			boolean zeramentoPerformance = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_ZERAMENTO_PERFORMANCE,
					linhaCorrente);
			String baseCalculoTaxaPerfor = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_BASE_CALCULO_TAXA_PERFORM,
					linhaCorrente);
			boolean ajustePerforCotista = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_AJUSTE_PERFORM_COTISTA,
					linhaCorrente);
			String infoAdicionaisTaxaPerfor = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_INFO_ADICIONAIS_TAXA_PERFORM,
					linhaCorrente);
			TipoTaxa tipoTaxaEntrada = TipoTaxa.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_TIPO_TAXA_ENTRADA,
							linhaCorrente));
			String valorTaxaEntrada = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_VALOR_TAXA_ENTRADA,
					linhaCorrente);
			String infoAdicionaiTaxaEntrada = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_INFO_ADICIONAL_TAXA_ENTRADA,
					linhaCorrente);
			TipoTaxa tipoTaxaSaida = TipoTaxa.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_TIPO_TAXA_SAIDA,
							linhaCorrente));
			String valorTaxaSaida = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_VALOR_TAXA_SAIDA, linhaCorrente);
			String infoAdicionalTaxaSaida = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_INFO_ADICIONAL_TAXA_SAIDA,
					linhaCorrente);

			return new TaxasFundos(perfilTaxaAdminstracao,
					unidadeTaxaAdministracao, valorTaxaAdminstracao,
					plBaseCalculoTaxa, valorPiso, indiceCorrecao,
					periodoCorrecao, aplicaOutrosFundos, taxaMaxima,
					faixasTaxas, perioCobrancaTaxaAdmin,
					infoAdicionaisTaxaNaoPadronizada, cobraTaxaPerformance,
					taxaPerformance, cupomTaxaPerfonce,
					perioCobrancaTaxaPerfor, plBaseCalculoTaxaPerfor,
					diaUtilCalculoTaxaPerfor, linhaDagua, zeramentoPerformance,
					baseCalculoTaxaPerfor, ajustePerforCotista,
					infoAdicionaisTaxaPerfor, tipoTaxaEntrada,
					valorTaxaEntrada, infoAdicionaiTaxaEntrada, tipoTaxaSaida,
					valorTaxaSaida, infoAdicionalTaxaSaida);
		} else {
			String dataInicioVigTaxaAdmin = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_INI_VIG_TAXA_ADMIN,
					linhaCorrente);
			PerfilTaxaAdministracao perfilTaxaAdminstracao = PerfilTaxaAdministracao
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PERFIL_TAXA_ADMIN_ALTERACAO,
									linhaCorrente));
			UnidadeTaxa unidadeTaxaAdministracao = UnidadeTaxa
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_UNIDADE_TAXA_ADMIN_ALTERACAO,
									linhaCorrente));
			String valorTaxaAdminstracao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_VALOR_TAXA_ADMIN_ALTERACAO,
					linhaCorrente);
			String plBaseCalculoTaxa = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_PL_BASE_CALCULO_TAXA_ALTERACAO,
					linhaCorrente);
			String valorPiso = ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_VALOR_PISO_ALTERACAO,
							linhaCorrente);
			Indice indiceCorrecao = Indice.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_INDICE_CORRECAO_ALTERACAO,
							linhaCorrente));
			PeriodoCorrecao periodoCorrecao = PeriodoCorrecao
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PERIODO_CORRECAO_ALTERACAO,
							linhaCorrente));
			boolean aplicaOutrosFundos = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_APLICAO_OUTROS_FUNDOS_ALTERACAO,
					linhaCorrente);
			String taxaMaxima = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_TAXA_MAXIMA_ALTERACAO,
					linhaCorrente);
			List<String> valorInicialPl = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_VALOR_INICIAL_PL_ALTERACAO,
							linhaCorrente);
			List<String> valorFinalPl = ArquivoUtils.getColunaListaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_VALOR_FINAL_PL_ALTERACAO,
					linhaCorrente);
			List<String> unidadeTaxaSt = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_UNIDADE_TAXA_ALTERACAO,
							linhaCorrente);
			List<UnidadeTaxa> unidadeTaxa = UnidadeTaxa
					.fromListDesc(unidadeTaxaSt);
			List<String> taxa = ArquivoUtils.getColunaListaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_TAXA_ALTERACAO,
					linhaCorrente);
			List<FaixasTaxas> faixasTaxas = FaixasTaxas.fromList(
					valorInicialPl, valorFinalPl, unidadeTaxa, taxa);
			PerioCobranca perioCobrancaTaxaAdmin = PerioCobranca
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PERIODO_COBR_TAXA_ADMIN_ALTERACAO,
									linhaCorrente));
			String infoAdicionaisTaxaNaoPadronizada = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INFO_ADICIONAL_TAXA_NAO_PADRONIZADA_ALTERACAO,
							linhaCorrente);
			String dataInicioVigTaxaPerformance = ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_TAXA_PERFORM,
							linhaCorrente);
			boolean cobraTaxaPerformance = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_COBRA_TAXA_PERFORM_ALTERACAO,
					linhaCorrente);
			List<String> indicadorTaxaCompostaSt = ArquivoUtils
					.getColunaListaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INDICADOR_TAXA_COMPOSTA_ALTERACAO,
							linhaCorrente);
			List<IndicadorTaxaComposta> indicadorTaxaComposta = IndicadorTaxaComposta
					.fromListDesc(indicadorTaxaCompostaSt);

			List<String> percentual = ArquivoUtils.getColunaListaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_PERCENTUAL_ALTERACAO,
					linhaCorrente);
			List<String> porcentagemIndiceReferencia = ArquivoUtils
					.getColunaListaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_PORCENT_INDICE_REFERENCIA_ALTERACAO,
							linhaCorrente);
			List<String> indiceReferenciaSt = ArquivoUtils
					.getColunaListaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INDICE_REFERENCIA_ALTERACAO,
							linhaCorrente);
			List<Indice> indiceReferencia = Indice
					.fromListDesc(indiceReferenciaSt);
			List<TaxaPerformance> taxaPerformance = TaxaPerformance.fromList(
					indicadorTaxaComposta, percentual,
					porcentagemIndiceReferencia, indiceReferencia);
			String cupomTaxaPerformance = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_CUPOM_TAXA_PERFORM_ALTERACAO,
					linhaCorrente);
			PerioCobranca perioCobrancaTaxaPerfor = PerioCobranca
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PERIOD_COBRANC_TAXA_PERFORM_ALTERACAO,
									linhaCorrente));
			PlBaseCalculoTaxaPerfor plBaseCalculoTaxaPerfor = PlBaseCalculoTaxaPerfor
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PL_BASE_CALCULO_TAXA_PERFORM_ALTERACAO,
									linhaCorrente));
			String diaUtilCalculoTaxaPerfor = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DIA_UTIL_CALCULO_TAXA_PERFORM_ALTERACAO,
							linhaCorrente);
			boolean linhaDagua = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_LINHA_DAGUA, linhaCorrente);
			boolean zeramentoPerformance = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_ZERAMENTO_PERFORMANCE_ALTERACAO,
					linhaCorrente);
			String baseCalculoTaxaPerfor = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_BASE_CALCULO_TAXA_PERFORM_ALTERACAO,
							linhaCorrente);
			boolean ajustePerforCotista = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_AJUSTE_PERFORM_COTISTA_ALTERACAO,
					linhaCorrente);
			String infoAdicionaisTaxaPerfor = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INFO_ADICIONAIS_TAXA_PERFORM_ALTERACAO,
							linhaCorrente);
			String dataInicioVigTaxaEntrada = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_TAXA_ENTRADA,
					linhaCorrente);
			TipoTaxa tipoTaxaEntrada = TipoTaxa
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_TIPO_TAXA_ENTRADA_ALTERACAO,
									linhaCorrente));
			String valorTaxaEntrada = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_VALOR_TAXA_ENTRADA_ALTERACAO,
					linhaCorrente);
			String infoAdicionaisTaxaEntrada = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INFO_ADICIONAL_TAXA_ENTRADA_ALTERACAO,
							linhaCorrente);
			String dataInicioVigTaxaSaida = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_INI_VIG_TAXA_SAIDA,
					linhaCorrente);
			TipoTaxa tipoTaxaSaida = TipoTaxa.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_TIPO_TAXA_SAIDA_ALTERACAO,
							linhaCorrente));
			String valorTaxaSaida = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_VALOR_TAXA_SAIDA_ALTERACAO,
					linhaCorrente);
			String infoAdicionalTaxaSaida = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INFO_ADICIONAL_TAXA_SAIDA_ALTERACAO,
							linhaCorrente);

			return new TaxasFundos(dataInicioVigTaxaAdmin,
					perfilTaxaAdminstracao, unidadeTaxaAdministracao,
					valorTaxaAdminstracao, plBaseCalculoTaxa, valorPiso,
					indiceCorrecao, periodoCorrecao, aplicaOutrosFundos,
					taxaMaxima, faixasTaxas, perioCobrancaTaxaAdmin,
					infoAdicionaisTaxaNaoPadronizada,
					dataInicioVigTaxaPerformance, cobraTaxaPerformance,
					taxaPerformance, cupomTaxaPerformance,
					perioCobrancaTaxaPerfor, plBaseCalculoTaxaPerfor,
					diaUtilCalculoTaxaPerfor, linhaDagua, zeramentoPerformance,
					baseCalculoTaxaPerfor, ajustePerforCotista,
					infoAdicionaisTaxaPerfor, dataInicioVigTaxaEntrada,
					tipoTaxaEntrada, valorTaxaEntrada,
					infoAdicionaisTaxaEntrada, dataInicioVigTaxaSaida,
					tipoTaxaSaida, valorTaxaSaida, infoAdicionalTaxaSaida);
		}
	}

	private static PerfilFundo getPerfil(XSSFSheet worksheet,
			int linhaCorrente, Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			ClassificacaoCVM classificacaoCVM = ClassificacaoCVM
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CLASSIF_CVM, linhaCorrente));
			CategoriaAnbid categoriaAnbid = CategoriaAnbid
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CATEGORIA_ANBID,
							linhaCorrente));
			TipoAnbid tipoAnbid = TipoAnbid.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_TIPO_ANBID, linhaCorrente));
			PlanoPrevidencia planoPrevidencia = PlanoPrevidencia
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PLANO_PREVIDENCIA,
							linhaCorrente));
			AplicacaoAutomatica aplicacaoAutomatica = AplicacaoAutomatica
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_APLICACAO_AUTOMATICA,
							linhaCorrente));
			FocoAtuacao focoAtuacao = FocoAtuacao
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(worksheet,
									ConstantesFundos.COLUNA_FOCO_ATUACAO,
									linhaCorrente));
			String calculaCota = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_CALCULO_COTAS, linhaCorrente);
			String horarioCompromPlCota = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_HORARIO_PL_COTA,
					linhaCorrente);
			String horarioCompromPosicao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_HORARIO_POSICAO,
					linhaCorrente);
			PeriodicidadeDivulgacao periodicidadeDivulgacao = PeriodicidadeDivulgacao
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PERIODICIDADE_DIVULGACAO,
							linhaCorrente));
			boolean abertoEstaturiamente = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_ABERTO_ESTATURIAMENTE,
					linhaCorrente);
			String duracaoFundo = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_DURACAO_FUNDO, linhaCorrente);
			UnidadeDuracaoFundo unidadeDuracaoFundo = UnidadeDuracaoFundo
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_UNIDADE_DURACAO,
							linhaCorrente));
			String prazoDuracaoFundo = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_PRAZO_DURACAO_FUNDO,
					linhaCorrente);
			BaseDuracaoFundo baseDuracaoFundo = BaseDuracaoFundo
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_BASE_DURACAO_FUNDO,
							linhaCorrente));
			Composicao composicao = Composicao.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_COMPOSICAO, linhaCorrente));
			boolean investidorQualificado = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_INVESTIDOR_QUALIFICADO,
					linhaCorrente);
			boolean alavancado = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_ALAVANCADO, linhaCorrente);
			boolean previdenciario = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_PREVIDENCIARIO, linhaCorrente);
			CreditoPrivado creditoPrivado = CreditoPrivado
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CREDITO_PRIVADO,
							linhaCorrente));
			InvestimentoExterior investimentoExterior = InvestimentoExterior
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_INVESTIMENTO_EXTERIOR,
							linhaCorrente));
			RestricaoInvestimento restricaoInvestimento = RestricaoInvestimento
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_RESTRICAO_INVESTIMENTO,
							linhaCorrente));
			List<String> publicoAlvoSt = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PUBLICO_ALVO, linhaCorrente);
			List<PublicoAlvo> publicoAlvo = PublicoAlvo
					.fromListDesc(publicoAlvoSt);
			boolean divulgacaoImprensa = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_DIVULGA_IMPRENSA,
					linhaCorrente);
			boolean respeitaLimitesEmissosAtivo = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_RESPEITA_LIMITES_EMISSAO_ATIVO,
							linhaCorrente);
			TributacaoPerseguida tributacaoPerseguida = TributacaoPerseguida
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_TRIBUTACAO_PERSEGUIDA,
							linhaCorrente));
			boolean possuiPorspecto = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_POSSUI_PROSPECTO, linhaCorrente);

			return new PerfilFundo(classificacaoCVM, categoriaAnbid, tipoAnbid,
					planoPrevidencia, aplicacaoAutomatica, focoAtuacao,
					calculaCota, horarioCompromPlCota, horarioCompromPosicao,
					periodicidadeDivulgacao, abertoEstaturiamente,
					duracaoFundo, unidadeDuracaoFundo, prazoDuracaoFundo,
					baseDuracaoFundo, composicao, investidorQualificado,
					alavancado, previdenciario, creditoPrivado,
					investimentoExterior, restricaoInvestimento, publicoAlvo,
					divulgacaoImprensa, respeitaLimitesEmissosAtivo,
					tributacaoPerseguida, possuiPorspecto);
		} else {
			ClassificacaoCVM classificacaoCVM = ClassificacaoCVM
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CLASSIF_CVM_ALTERACAO,
							linhaCorrente));
			String dataInicioVigClassificCVM = ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CLASSIF_CVM,
							linhaCorrente);
			CategoriaAnbid categoriaAnbid = CategoriaAnbid
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CATEGORIA_ANBID_ALTERACAO,
							linhaCorrente));
			String dataInicioVigCategoriaAnbid = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CATEGORIA_ANBID,
							linhaCorrente);
			TipoAnbid tipoAnbid = TipoAnbid.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_TIPO_ANBID_ALTERACAO,
							linhaCorrente));
			String dataInicioVigTipoAnbid = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_INI_VIG_TIPO_ANBID,
					linhaCorrente);
			PlanoPrevidencia planoPrevidencia = PlanoPrevidencia
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PLANO_PREVIDENCIA_ALTERACAO,
									linhaCorrente));
			String dataInicioVigPlanoPrev = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_PLANO_PREVIDENCIA,
					linhaCorrente);
			AplicacaoAutomatica aplicacaoAutomatica = AplicacaoAutomatica
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_APLICACAO_AUTOMATICA_ALTERACAO,
									linhaCorrente));
			String dataInicioVigAplcAuto = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_APLICACAO_AUTOMATICA,
					linhaCorrente);
			FocoAtuacao focoAtuacao = FocoAtuacao.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_FOCO_ATUACAO_ALTERACAO,
							linhaCorrente));
			String dataInicioVigFocoAtuacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_FOCO_ATUACAO,
					linhaCorrente);
			String calculaCota = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_CALCULO_COTAS_ALTERACAO,
					linhaCorrente);
			String dataInicioVigCalculoCotas = ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CALCULO_COTAS,
							linhaCorrente);
			String horarioCompromPlCota = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_HORARIO_PL_COTA_ALTERACAO,
					linhaCorrente);
			String horarioCompromPosicao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_HORARIO_POSICAO_ALTERACAO,
					linhaCorrente);
			PeriodicidadeDivulgacao periodicidadeDivulgacao = PeriodicidadeDivulgacao
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_PERIODICIDADE_DIVULGACAO_ALTERACAO,
									linhaCorrente));
			boolean abertoEstaturiamente = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_ABERTO_ESTATURIAMENTE_ALTERACAO,
					linhaCorrente);
			String duracaoFundo = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_DURACAO_FUNDO_ALTERACAO,
					linhaCorrente);
			UnidadeDuracaoFundo unidadeDuracaoFundo = UnidadeDuracaoFundo
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_UNIDADE_DURACAO_ALTERACAO,
							linhaCorrente));
			String prazoDuracaoFundo = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_PRAZO_DURACAO_FUNDO_ALTERACAO,
					linhaCorrente);
			BaseDuracaoFundo baseDuracaoFundo = BaseDuracaoFundo
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_BASE_DURACAO_FUNDO_ALTERACAO,
									linhaCorrente));
			Composicao composicao = Composicao.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_COMPOSICAO_ALTERACAO,
							linhaCorrente));
			String dataInicioVigComposicao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_INI_VIG_COMPOSICAO,
					linhaCorrente);
			boolean investidorQualificado = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_INVESTIDOR_QUALIFICADO_ALTERACAO,
					linhaCorrente);
			String dataInicioVigInvestidorQualificado = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_INVESTIDOR_QUALIFICADO,
							linhaCorrente);
			boolean alavancado = ArquivoUtils
					.getColunaBooleana(worksheet,
							ConstantesFundos.COLUNA_ALAVANCADO_ALTERACAO,
							linhaCorrente);
			String dataInicioVigAlavancado = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_INI_VIG_ALAVANCADO,
					linhaCorrente);
			boolean previdenciario = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_PREVIDENCIARIO_ALTERACAO,
					linhaCorrente);
			String dataInicioVigPrevidenciario = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG__PREVIDENCIARIO,
							linhaCorrente);
			CreditoPrivado creditoPrivado = CreditoPrivado
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CREDITO_PRIVADO_ALTERACAO,
							linhaCorrente));
			String dataInicioVigCreditoPriv = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_CREDITO_PRIVADO,
					linhaCorrente);
			InvestimentoExterior investimentoExterior = InvestimentoExterior
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_INVESTIMENTO_EXTERIOR_ALTERACAO,
									linhaCorrente));
			String dataInicioVigInvestExt = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_INVESTIMENTO_EXTERIOR,
					linhaCorrente);
			RestricaoInvestimento restricaoInvestimento = RestricaoInvestimento
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_RESTRICAO_INVESTIMENTO_ALTERACAO,
									linhaCorrente));
			String dataInicioVigRestricaoInvestimentot = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_RESTRICAO_INVESTIMENTO,
							linhaCorrente);
			List<String> publicoAlvoSt = ArquivoUtils
					.getColunaListaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PUBLICO_ALVO_ALTERACAO,
							linhaCorrente);
			List<PublicoAlvo> publicoAlvo = PublicoAlvo
					.fromListDesc(publicoAlvoSt);
			String dataInicioVigPublicoAlvo = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_PUBLICO_ALVO,
					linhaCorrente);
			boolean divulgacaoImprensa = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_DIVULGA_IMPRENSA_ALTERACAO,
					linhaCorrente);
			boolean respeitaLimitesEmissosAtivo = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_RESPEITA_LIMITES_EMISSAO_ATIVO,
							linhaCorrente);
			String dataInicioVigRespeitaLimites = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_RESPEITA_LIMITES_EMISSAO_ATIVO,
							linhaCorrente);
			TributacaoPerseguida tributacaoPerseguida = TributacaoPerseguida
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_TRIBUTACAO_PERSEGUIDA_ALTERACAO,
									linhaCorrente));
			String dataInicioVigTributacaoPerseguida = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_TRIBUTACAO_PERSEGUIDA,
							linhaCorrente);
			boolean possuiPorspecto = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_POSSUI_PROSPECTO_ALTERACAO,
					linhaCorrente);

			return new PerfilFundo(classificacaoCVM, dataInicioVigClassificCVM,
					categoriaAnbid, dataInicioVigCategoriaAnbid, tipoAnbid,
					dataInicioVigTipoAnbid, planoPrevidencia,
					dataInicioVigPlanoPrev, aplicacaoAutomatica,
					dataInicioVigAplcAuto, focoAtuacao,
					dataInicioVigFocoAtuacao, calculaCota,
					dataInicioVigCalculoCotas, horarioCompromPlCota,
					horarioCompromPosicao, periodicidadeDivulgacao,
					abertoEstaturiamente, duracaoFundo, unidadeDuracaoFundo,
					prazoDuracaoFundo, baseDuracaoFundo, composicao,
					dataInicioVigComposicao, investidorQualificado,
					dataInicioVigInvestidorQualificado, alavancado,
					dataInicioVigAlavancado, previdenciario,
					dataInicioVigPrevidenciario, creditoPrivado,
					dataInicioVigCreditoPriv, investimentoExterior,
					dataInicioVigInvestExt, restricaoInvestimento,
					dataInicioVigRestricaoInvestimentot, publicoAlvo,
					dataInicioVigPublicoAlvo, divulgacaoImprensa,
					respeitaLimitesEmissosAtivo, dataInicioVigRespeitaLimites,
					tributacaoPerseguida, dataInicioVigTributacaoPerseguida,
					possuiPorspecto);
		}
	}

	private static ParametrosMovimentacao getParametrosMovimentacao(
			XSSFSheet worksheet, int linhaCorrente, Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			String indicadorPrazoConversaoCotas = ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_IND_PRAZO_CONVERSAO_COTAS,
							linhaCorrente);
			String prazoConversaoCotasAplicacao = ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_PRAZO_CONVERSAO_APLICACAO,
							linhaCorrente);
			boolean estabeleceValoresMinimosMovimentacao = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_ESTABELECE_VALORES_MINIMOS_MOV,
							linhaCorrente);
			String aplicacaoInicial = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_APLICACAO_INICIAL,
					linhaCorrente);
			String aplicacaoAdicional = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_APLICACAO_ADICIONAL,
					linhaCorrente);
			String indicadorPrazoConversaoResgate = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INDICADOR_PRAZO_CONVERSAO_RESG,
							linhaCorrente);
			String prazoConversaoResgate = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_PRAZO_CONVERSAO_RESG,
					linhaCorrente);
			String indicadorPrazoPagtoResgate = ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_IND_PRAZO_PAGTO_RESG,
							linhaCorrente);
			String prazoPrazoPagtoResgate = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_PRAZO_PAGTO_RESG,
					linhaCorrente);
			boolean possuiPagtoResgate = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_POSSUI_PAGTO_RESG,
					linhaCorrente);
			String regraPagtoResgate = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_REGRA_PAGTO_RESG,
					linhaCorrente);
			String carenciaInicial = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_CARENCIA_INICIAL,
					linhaCorrente);
			String carenciaCiclica = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_CARENCIA_CICLICA,
					linhaCorrente);
			String resgate = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_RESGATE, linhaCorrente);
			String saldoMinimo = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_SALDO_MINIMO, linhaCorrente);
			boolean abertoCaptacao = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_ABERTO_CAPTACAO, linhaCorrente);
			String dataAberturaCaptacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_ABERTURA_CAPTACAO,
					linhaCorrente);

			return new ParametrosMovimentacao(indicadorPrazoConversaoCotas,
					prazoConversaoCotasAplicacao,
					estabeleceValoresMinimosMovimentacao, aplicacaoInicial,
					aplicacaoAdicional, indicadorPrazoConversaoResgate,
					prazoConversaoResgate, indicadorPrazoPagtoResgate,
					prazoPrazoPagtoResgate, possuiPagtoResgate,
					regraPagtoResgate, carenciaInicial, carenciaCiclica,
					resgate, saldoMinimo, abertoCaptacao, dataAberturaCaptacao);
		} else {
			String indicadorPrazoConversaoCotas = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_IND_PRAZO_CONVERSAO_COTAS_ALTERACAO,
							linhaCorrente);
			String prazoConversaoCotasAplicacao = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_PRAZO_CONVERSAO_APLICACAO_ALTERACAO,
							linhaCorrente);
			String dataInicioVigPrazoConvCotasAplic = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_PRAZO_CONVERSAO_APLICACAO,
							linhaCorrente);
			boolean estabeleceValoresMinimosMovimentacao = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_ESTABELECE_VALORES_MINIMOS_MOV_ALTERACAO,
							linhaCorrente);
			String aplicacaoInicial = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_APLICACAO_INICIAL_ALTERACAO,
					linhaCorrente);
			String aplicacaoAdicional = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_APLICACAO_ADICIONAL_ALTERACAO,
					linhaCorrente);
			String indicadorPrazoConversaoResgate = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_INDICADOR_PRAZO_CONVERSAO_RESG_ALTERACAO,
							linhaCorrente);
			String prazoConversaoResgate = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_PRAZO_CONVERSAO_RESG_ALTERACAO,
					linhaCorrente);
			String dataInicioVigPrazoConvResg = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_PRAZO_CONVERSAO_RESG,
							linhaCorrente);
			String indicadorPrazoPagtoResgate = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_IND_PRAZO_PAGTO_RESG_ALTERACAO,
							linhaCorrente);
			String prazoPrazoPagtoResgate = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_PRAZO_PAGTO_RESG_ALTERACAO,
					linhaCorrente);
			String dataInicioVigPrazoPagtoResg = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_PRAZO_PAGTO_RESG,
							linhaCorrente);
			boolean possuiPagtoResgate = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_POSSUI_PAGTO_RESG_ALTERACAO,
					linhaCorrente);
			String dataInicioVigPossuiPagtoResg = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_POSSUI_PAGTO_RESG,
							linhaCorrente);
			String regraPagtoResgate = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_REGRA_PAGTO_RESG_ALTERACAO,
					linhaCorrente);
			String dataInicioVigRegraPagtoResg = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_REGRA_PAGTO_RESG,
							linhaCorrente);
			String carenciaInicial = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_CARENCIA_INICIAL_ALTERACAO,
					linhaCorrente);
			String carenciaCiclica = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_CARENCIA_CICLICA_ALTERACAO,
					linhaCorrente);
			String resgate = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_RESGATE_ALTERACAO, linhaCorrente);
			String saldoMinimo = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_SALDO_MINIMO_ALTERACAO,
					linhaCorrente);
			boolean abertoCaptacao = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_ABERTO_CAPTACAO_ALTERACAO,
					linhaCorrente);
			String dataAberturaCaptacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_ABERTURA_CAPTACAO_ALTERACAO,
					linhaCorrente);
			String dataFechamentoCaptacao = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_FECHAMENTO_CAPTACAO_ALTERACAO,
					linhaCorrente);

			return new ParametrosMovimentacao(indicadorPrazoConversaoCotas,
					prazoConversaoCotasAplicacao,
					dataInicioVigPrazoConvCotasAplic,
					estabeleceValoresMinimosMovimentacao, aplicacaoInicial,
					aplicacaoAdicional, indicadorPrazoConversaoResgate,
					prazoConversaoResgate, dataInicioVigPrazoConvResg,
					indicadorPrazoPagtoResgate, prazoPrazoPagtoResgate,
					dataInicioVigPrazoPagtoResg, possuiPagtoResgate,
					dataInicioVigPossuiPagtoResg, regraPagtoResgate,
					dataInicioVigRegraPagtoResg, carenciaInicial,
					carenciaCiclica, resgate, saldoMinimo, abertoCaptacao,
					dataAberturaCaptacao, dataFechamentoCaptacao);
		}
	}

	private static PrestadoresServicoFundo getPrestadoresServico(
			XSSFSheet worksheet, int linhaCorrente, Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			Administrador administrador = Administrador.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_ADMINISTRADOR,
							linhaCorrente));
			AgenciaClassificacaoRisco agenciaClassificacaoRisco = AgenciaClassificacaoRisco
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_AGENCIA_CLASSIF_RISCO,
							linhaCorrente));
			Auditoria auditoria = Auditoria.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_AUDITORIA, linhaCorrente));
			Consultoria consultoria = Consultoria
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CONSULTORIA, linhaCorrente));
			Contabilidade contabilidade = Contabilidade.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CONTABILIDADE,
							linhaCorrente));
			Controlador controladorAtivo = Controlador.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CONTROLADOR_ATIVOS,
							linhaCorrente));
			Controlador controladorPassivo = Controlador.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CONTROLADOR_PASSIVOS,
							linhaCorrente));
			String coordenadorDistribuidorLider = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_COORDENADOR_DISTRIBUIDOR_LIDER,
							linhaCorrente);
			Custodiante custodianteUnico = Custodiante.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CUSTODIANTES_UNICO,
							linhaCorrente));
			Custodiante custdianteCotas = Custodiante.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CUSTODIANTE_COTAS,
							linhaCorrente));
			Custodiante custpdianteDerivativos = Custodiante
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CUSTODIANTE_DERIVATIVOS,
							linhaCorrente));
			Custodiante custodiantesRendaFixa = Custodiante
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CUSTODIANTES_RENDA_FIXA,
							linhaCorrente));
			Custodiante custodianteRendaVariavel = Custodiante
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CUSTODIANTE_RENDA_VARIAVEL,
							linhaCorrente));
			List<String> distribuidorArgenteAutonomoSt = ArquivoUtils
					.getColunaListaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DISTRIBUIDOR_AGENTE_AUTONOMO,
							linhaCorrente);
			List<Distribuidor> distribuidorArgenteAutonomo = Distribuidor
					.fromListDesc(distribuidorArgenteAutonomoSt);
			EmpresaAvaliacaoRisco empresaAvalicaoRisco = EmpresaAvaliacaoRisco
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_EMPRESA_AVALIACAO_RISCO,
							linhaCorrente));
			EscrituradorCotas escrituradorCotas = EscrituradorCotas
					.fromDesc(ArquivoUtils.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_ESCRITURADOR_COTAS,
							linhaCorrente));
			Gestor gestorUnico = Gestor
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(worksheet,
									ConstantesFundos.COLUNA_GESTOR_UNICO,
									linhaCorrente));
			Gestor gestorCotas = Gestor
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(worksheet,
									ConstantesFundos.COLUNA_GESTOR_COTAS,
									linhaCorrente));
			Gestor gestorDerivativos = Gestor.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_GESTOR_DERIVATIVOS,
							linhaCorrente));
			Gestor gestorRendaFixa = Gestor.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_GESTOR_RENDA_FIXA,
							linhaCorrente));
			Gestor gestorRendaVariavel = Gestor.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_GESTOR_RENDA_VARIAVEL,
							linhaCorrente));

			return new PrestadoresServicoFundo(administrador,
					agenciaClassificacaoRisco, auditoria, consultoria,
					contabilidade, controladorAtivo, controladorPassivo,
					coordenadorDistribuidorLider, custodianteUnico,
					custdianteCotas, custpdianteDerivativos,
					custodiantesRendaFixa, custodianteRendaVariavel,
					distribuidorArgenteAutonomo, empresaAvalicaoRisco,
					escrituradorCotas, gestorUnico, gestorCotas,
					gestorDerivativos, gestorRendaFixa, gestorRendaVariavel);
		} else {
			Administrador administrador = Administrador.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_ADMINISTRADOR_ALTERACAO,
							linhaCorrente));
			String dataInicioVigAdmin = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_ADMINISTRADOR,
					linhaCorrente);

			AgenciaClassificacaoRisco agenciaClassificacaoRisco = AgenciaClassificacaoRisco
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_AGENCIA_CLASSIF_RISCO_ALTERACAO,
									linhaCorrente));

			Auditoria auditoria = Auditoria.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_AUDITORIA_ALTERACAO,
							linhaCorrente));

			String dataInicioVigAuditoria = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_INI_VIG_AUDITORIA,
					linhaCorrente);

			Consultoria consultoria = Consultoria.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CONSULTORIA_ALTERACAO,
							linhaCorrente));
			Contabilidade contabilidade = Contabilidade.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_CONTABILIDADE_ALTERACAO,
							linhaCorrente));
			Controlador controladorAtivo = Controlador
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_CONTROLADOR_ATIVOS_ALTERACAO,
									linhaCorrente));
			String dataInicioVigControladorAtivos = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CONTROLADOR_ATIVOS,
							linhaCorrente);

			Controlador controladorPassivo = Controlador
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_CONTROLADOR_PASSIVOS_ALTERACAO,
									linhaCorrente));
			String dataInicioVigControladorPassivos = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CONTROLADOR_PASSIVOS,
							linhaCorrente);

			String coordenadorDistribuidorLider = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_COORDENADOR_DISTRIBUIDOR_LIDER_ALTERACAO,
							linhaCorrente);
			Custodiante custodianteUnico = Custodiante
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_CUSTODIANTES_UNICO_ALTERACAO,
									linhaCorrente));
			String dataInicioVigCustodianteUnico = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CUSTODIANTES_UNICO,
							linhaCorrente);

			Custodiante custodianteCotas = Custodiante
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_CUSTODIANTE_COTAS_ALTERACAO,
									linhaCorrente));
			String dataInicioVigCustodianteCotas = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CUSTODIANTE_COTAS,
							linhaCorrente);

			Custodiante custodianteDerivativos = Custodiante
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_CUSTODIANTE_DERIVATIVOS_ALTERACAO,
									linhaCorrente));
			String dataInicioVigCustodianteDerivativos = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CUSTODIANTE_DERIVATIVOS,
							linhaCorrente);

			Custodiante custodiantesRendaFixa = Custodiante
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_CUSTODIANTES_RENDA_FIXA_ALTERACAO,
									linhaCorrente));
			String dataInicioVigCustodianteRendaFixa = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CUSTODIANTES_RENDA_FIXA,
							linhaCorrente);

			Custodiante custodianteRendaVariavel = Custodiante
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_CUSTODIANTE_RENDA_VARIAVEL_ALTERACAO,
									linhaCorrente));
			String dataInicioVigCustodianteRendaVariavel = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_CUSTODIANTE_RENDA_VARIAVEL,
							linhaCorrente);

			List<String> distribuidorArgenteAutonomoSt = ArquivoUtils
					.getColunaListaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DISTRIBUIDOR_AGENTE_AUTONOMO_ALTERACAO,
							linhaCorrente);
			List<Distribuidor> distribuidorAgenteAutonomo = Distribuidor
					.fromListDesc(distribuidorArgenteAutonomoSt);
			EmpresaAvaliacaoRisco empresaAvalicaoRisco = EmpresaAvaliacaoRisco
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_EMPRESA_AVALIACAO_RISCO_ALTERACAO,
									linhaCorrente));
			EscrituradorCotas escrituradorCotas = EscrituradorCotas
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_ESCRITURADOR_COTAS_ALTERACAO,
									linhaCorrente));
			Gestor gestorUnico = Gestor.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_GESTOR_UNICO_ALTERACAO,
							linhaCorrente));
			String dataInicioVigGestorUnico = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_GESTOR_UNICO,
					linhaCorrente);

			Gestor gestorCotas = Gestor.fromDesc(ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_GESTOR_COTAS_ALTERACAO,
							linhaCorrente));
			String dataInicioVigGestorCotas = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_GESTOR_COTAS,
					linhaCorrente);

			Gestor gestorDerivativos = Gestor
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_GESTOR_DERIVATIVOS_ALTERACAO,
									linhaCorrente));
			String dataInicioVigGestorDerivativos = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_GESTOR_DERIVATIVOS,
							linhaCorrente);

			Gestor gestorRendaFixa = Gestor
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_GESTOR_RENDA_FIXA_ALTERACAO,
									linhaCorrente));
			String dataInicioVigGestorRendaFixa = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_GESTOR_RENDA_FIXA,
							linhaCorrente);

			Gestor gestorRendaVariavel = Gestor
					.fromDesc(ArquivoUtils
							.getLinhaAbaCorrente(
									worksheet,
									ConstantesFundos.COLUNA_GESTOR_RENDA_VARIAVEL_ALTERACAO,
									linhaCorrente));
			String dataInicioVigGestorRendaVariavel = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_GESTOR_RENDA_VARIAVEL,
							linhaCorrente);

			return new PrestadoresServicoFundo(administrador,
					dataInicioVigAdmin, agenciaClassificacaoRisco, auditoria,
					dataInicioVigAuditoria, consultoria, contabilidade,
					controladorAtivo, dataInicioVigControladorAtivos,
					controladorPassivo, dataInicioVigControladorPassivos,
					coordenadorDistribuidorLider, custodianteUnico,
					dataInicioVigCustodianteUnico, custodianteCotas,
					dataInicioVigCustodianteCotas, custodianteDerivativos,
					dataInicioVigCustodianteDerivativos, custodiantesRendaFixa,
					dataInicioVigCustodianteRendaFixa,
					custodianteRendaVariavel,
					dataInicioVigCustodianteRendaVariavel,
					distribuidorAgenteAutonomo, empresaAvalicaoRisco,
					escrituradorCotas, gestorUnico, dataInicioVigGestorUnico,
					gestorCotas, dataInicioVigGestorCotas, gestorDerivativos,
					dataInicioVigGestorDerivativos, gestorRendaFixa,
					dataInicioVigGestorRendaFixa, gestorRendaVariavel,
					dataInicioVigGestorRendaVariavel);
		}
	}

	private static IdentificaoFundo getIdentificao(XSSFSheet worksheet,
			int linhaCorrente, Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			String cnpj = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_CNPJ, linhaCorrente);
			String razaoSocial = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_RAZAO_SOCIAL, linhaCorrente);
			String nomeFantasia = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_NOME_FANTASIA, linhaCorrente);
			String nomeFantasioImprensa = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_NOME_FANTASIA_IMPRENSA,
					linhaCorrente);
			String sigla = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_SIGLA, linhaCorrente);
			String mnemonicoCETIP = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_MNEMONICO_CETIP, linhaCorrente);
			String ISIN = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_ISIN, linhaCorrente);
			String CUSIP = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_CUSIP, linhaCorrente);
			boolean divulgacaoAnbid = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_DIVULGACAO_ANBID, linhaCorrente);

			return new IdentificaoFundo(cnpj, razaoSocial, nomeFantasia,
					nomeFantasioImprensa, sigla, mnemonicoCETIP, ISIN, CUSIP,
					divulgacaoAnbid);
		} else {
			String cnpj = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_CNPJ_ALTERACAO, linhaCorrente);
			String razaoSocial = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_RAZAO_SOCIAL_ALTERACAO,
					linhaCorrente);
			String dataInicioVigRazaoSocial = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_INI_VIG_RAZAO_SOCIAL,
					linhaCorrente);
			String nomeFantasia = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_NOME_FANTASIA_ALTERACAO,
					linhaCorrente);
			String dataInicioVigNomeFantasia = ArquivoUtils
					.getLinhaAbaCorrente(worksheet,
							ConstantesFundos.COLUNA_DATA_INI_VIG_NOME_FANTASIA,
							linhaCorrente);
			String nomeFantasioImprensa = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_NOME_FANTASIA_IMPRENSA_ALTERACAO,
					linhaCorrente);
			String sigla = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_SIGLA_ALTERACAO, linhaCorrente);
			String mnemonicoCETIP = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_MNEMONICO_CETIP_ALTERACAO,
					linhaCorrente);
			String ISIN = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_ISIN_ALTERACAO, linhaCorrente);
			String CUSIP = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_CUSIP_ALTERACAO, linhaCorrente);
			boolean divulgacaoAnbid = ArquivoUtils.getColunaBooleana(worksheet,
					ConstantesFundos.COLUNA_DIVULGACAO_ANBID_ALTERACAO,
					linhaCorrente);
			boolean alteracaoImplicaAnalise = ArquivoUtils.getColunaBooleana(
					worksheet,
					ConstantesFundos.COLUNA_ALTERACAO_INPLICA_ANALISE,
					linhaCorrente);

			return new IdentificaoFundo(cnpj, razaoSocial,
					dataInicioVigRazaoSocial, nomeFantasia,
					dataInicioVigNomeFantasia, nomeFantasioImprensa, sigla,
					mnemonicoCETIP, ISIN, CUSIP, divulgacaoAnbid,
					alteracaoImplicaAnalise);
		}

	}

	private static DatasFundos getDatasFundos(XSSFSheet worksheet,
			int linhaCorrente, Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			boolean fasePreOperacional = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_FASE_PRE_OPERACIONAL,
					linhaCorrente);
			String dataInicioAtividade = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_INICIO_ATIVIDADE,
					linhaCorrente);

			return new DatasFundos(fasePreOperacional, dataInicioAtividade);
		} else {
			boolean fasePreOperacional = ArquivoUtils.getColunaBooleana(
					worksheet, ConstantesFundos.COLUNA_FASE_PRE_OPERACIONAL,
					linhaCorrente);
			String dataInicioAtividade = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_INICIO_ATIVIDADE,
					linhaCorrente);
			String dataPublicInicioOferta = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_PUBLIC_INICIO_OFERTA,
					linhaCorrente);
			String dataVinculacaoAnbid = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_VINCULACAO_ANBID,
					linhaCorrente);
			String dataDesvinculacaoAnbid = ArquivoUtils.getLinhaAbaCorrente(
					worksheet,
					ConstantesFundos.COLUNA_DATA_DESVINCULACAO_ANBID,
					linhaCorrente);
			String dataAssembleia = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_DATA_ASSEMBLEIA, linhaCorrente);
			String dataProtocoloCVM = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_DATA_PROTOCOLO_CVM,
					linhaCorrente);
			String dataInicioValidadeAlteracao = ArquivoUtils
					.getLinhaAbaCorrente(
							worksheet,
							ConstantesFundos.COLUNA_DATA_INICIO_VALIDADE_ALTERACAO,
							linhaCorrente);

			return new DatasFundos(fasePreOperacional, dataInicioAtividade,
					dataPublicInicioOferta, dataVinculacaoAnbid,
					dataDesvinculacaoAnbid, dataAssembleia, dataProtocoloCVM,
					dataInicioValidadeAlteracao);
		}
	}

	private static Evento getEvento(XSSFSheet worksheet, int linhaCorrente,
			Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			boolean fundoInicializadoPorEventoCorp = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_FUNDO_INICIALIZA_ENVENTO_CORP,
							linhaCorrente);
			String evento = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_EVENTO, linhaCorrente);
			String fundoInvestimentoOrigem = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_FUNDO_ORIGEM,
					linhaCorrente);

			return new Evento(fundoInicializadoPorEventoCorp, evento,
					fundoInvestimentoOrigem);
		} else {
			boolean fundoInicializadoPorEventoCorp = ArquivoUtils
					.getColunaBooleana(
							worksheet,
							ConstantesFundos.COLUNA_FUNDO_INICIALIZA_ENVENTO_CORP_ALTERACAO,
							linhaCorrente);
			String evento = ArquivoUtils.getLinhaAbaCorrente(worksheet,
					ConstantesFundos.COLUNA_EVENTO_ALTERACAO, linhaCorrente);
			String fundoInvestimentoOrigem = ArquivoUtils.getLinhaAbaCorrente(
					worksheet, ConstantesFundos.COLUNA_FUNDO_ORIGEM_ALTERACAO,
					linhaCorrente);

			return new Evento(fundoInicializadoPorEventoCorp, evento,
					fundoInvestimentoOrigem);

		}
	}

}
