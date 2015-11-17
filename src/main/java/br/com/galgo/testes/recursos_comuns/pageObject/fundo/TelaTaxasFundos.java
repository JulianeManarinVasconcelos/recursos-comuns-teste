package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.file.entidades.FaixasTaxas;
import br.com.galgo.testes.recursos_comuns.file.entidades.TaxaPerformance;
import br.com.galgo.testes.recursos_comuns.file.entidades.TaxasFundos;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaTaxasFundos extends TelaPrincipal {

	public TelaParametrosMovimentacao preencherAba(TaxasFundos taxasFundos) {
		preencherDataInicioVigTaxaAdmin(taxasFundos);
		escolherPerfilTaxaAdminstracao(taxasFundos);
		escolherUnidadeTaxaAdministracao(taxasFundos);
		escolherValorTaxaAdminstracao(taxasFundos);
		escolherPlBaseCalculoTaxa(taxasFundos);
		escolherValorPiso(taxasFundos);
		escolherIndiceCorrecao(taxasFundos);
		escolherPeriodoCorrecao(taxasFundos);
		escolherAplicaOutrosFundos(taxasFundos);
		escolherTaxaMaxima(taxasFundos);
		preencherFaixasTaxas(taxasFundos);
		escolherPerioCobrancaTaxaAdmin(taxasFundos);
		escolherInfoAdicionaisTaxaNaoPadronizada(taxasFundos);
		preencherDataInicioVigTaxaPerformance(taxasFundos);
		escolherCobraTaxaPerformance(taxasFundos);
		preencherDataInicioVigTaxaEntrada(taxasFundos);
		escolherTipoTaxaEntrada(taxasFundos);
		preencherValorTaxaEntrada(taxasFundos);
		preencherInfoAdicionaiTaxaEntrada(taxasFundos);
		preencherDataInicioVigTaxaSaida(taxasFundos);
		escolherTipoTaxaSaida(taxasFundos);
		preencherValorTaxaSaida(taxasFundos);
		preencherInfoAdicionalTaxaSaida(taxasFundos);
		clicarProxima();

		return new TelaParametrosMovimentacao();
	}

	private void preencherDataInicioVigTaxaSaida(TaxasFundos taxasFundos) {
		final String dataInicioVigTaxaSaida = taxasFundos
				.getDataInicioVigTaxaSaida();
		if (dataInicioVigTaxaSaida != "") {
			if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/div[1]/input")) {
				preencherCampoSelectByXPath(
						dataInicioVigTaxaSaida,
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/div[1]/input");
			}
		}
	}

	private void preencherDataInicioVigTaxaEntrada(TaxasFundos taxasFundos) {
		final String dataInicioVigTaxaEntrada = taxasFundos
				.getDataInicioVigTaxaEntrada();
		if (dataInicioVigTaxaEntrada != "") {
			if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/div[1]/input")) {
				preencherCampoSelectByXPath(
						dataInicioVigTaxaEntrada,
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/div[1]/input");
			}
		}
	}

	private void preencherDataInicioVigTaxaPerformance(TaxasFundos taxasFundos) {
		final String dataInicioVigTaxaPerformance = taxasFundos
				.getDataInicioVigTaxaPerformance();
		if (dataInicioVigTaxaPerformance != "") {
			if (verificaCampoVisivelPorId("dtIniVigBlocoTxPerformance")) {
				preencherCampoSelectById(dataInicioVigTaxaPerformance,
						"dtIniVigBlocoTxPerformance");
			}
		}
	}

	private void preencherDataInicioVigTaxaAdmin(TaxasFundos taxasFundos) {
		final String dataInicioVigTaxaAdmin = taxasFundos
				.getDataInicioVigTaxaAdmin();
		if (dataInicioVigTaxaAdmin != "") {
			if (verificaCampoVisivelPorId("dtIniVigBlocoTxAdministracao")) {
				if (verificaCampoHabilitadoPorId("dtIniVigBlocoTxAdministracao")) {
					preencheCampoPorId("dtIniVigBlocoTxAdministracao",
							dataInicioVigTaxaAdmin);
				}
			}
		}
	}

	private void clicarProxima() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/div[3]/button[1]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/div[7]/button[1]");
		}
	}

	private void preencherTaxaPerformance(TaxasFundos taxasFundos) {
		for (TaxaPerformance taxaPerformance : taxasFundos.getTaxaPerformance()) {
			escolherIndicadorTaxaComposta(taxaPerformance);
			preencherPercentual(taxaPerformance);
			preencherPorcentagemIndiceReferencia(taxaPerformance);
			escolherIndiceReferencia(taxaPerformance);
			clicarAdicionar();
		}
	}

	private void escolherIndiceReferencia(TaxaPerformance taxaPerformance) {
		try {
			preencherCampoSelectByXPath(
					taxaPerformance.getIndiceReferencia().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[6]/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					taxaPerformance.getIndiceReferencia().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[6]/select");
		}
	}

	private void escolherIndicadorTaxaComposta(TaxaPerformance taxaPerformance) {
		try {
			preencherCampoSelectByXPath(
					taxaPerformance.getIndicadorTaxaComposta().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					taxaPerformance.getIndicadorTaxaComposta().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[1]/select");
		}
	}

	private void clicarAdicionar() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[7]/div/img[1]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[7]/div/img[1]");
		}
	}

	private void preencherPorcentagemIndiceReferencia(
			TaxaPerformance taxaPerformance) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[4]/input",
					taxaPerformance.getPorcentagemIndiceReferencia());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[4]/input",
					taxaPerformance.getPorcentagemIndiceReferencia());
		}
	}

	private void preencherPercentual(TaxaPerformance taxaPerformance) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/input",
					taxaPerformance.getPercentual());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr[2]/td[2]/input",
					taxaPerformance.getPercentual());
		}
	}

	private void preencherFaixasTaxas(TaxasFundos taxasFundos) {
		for (FaixasTaxas faixasTaxa : taxasFundos.getFaixasTaxas()) {
			if (verificarPreenchimentoFaixaTaxas()) {
				preencherValorInicialPl(faixasTaxa);
				preencherValorFinalPl(faixasTaxa);
				escolherUnidadeTaxa(faixasTaxa);
				preencherTaxa(faixasTaxa);
				clicarBotaoIncluir();
			}
		}
	}

	private boolean verificarPreenchimentoFaixaTaxas() {
		if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/table/tbody/tr[2]/td[1]/input")) {
			return true;
		} else {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/table/tbody/tr[2]/td[1]/input")) {
				return true;
			}
		}
		return false;
	}

	private void escolherUnidadeTaxa(FaixasTaxas faixasTaxa) {
		try {
			preencherCampoSelectByXPath(
					faixasTaxa.getUnidadeTaxa().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/table/tbody/tr[2]/td[3]/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					faixasTaxa.getUnidadeTaxa().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/table/tbody/tr[2]/td[3]/select");
		}
	}

	private void clicarBotaoIncluir() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/table/tbody/tr[2]/td[5]/div/img[1]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/table/tbody/tr[2]/td[5]/div/img[1]");
		}
	}

	private void preencherTaxa(FaixasTaxas faixasTaxa) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/table/tbody/tr[2]/td[4]/input",
					faixasTaxa.getTaxa());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/table/tbody/tr[2]/td[4]/input",
					faixasTaxa.getTaxa());
		}
	}

	private void preencherValorFinalPl(FaixasTaxas faixasTaxa) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/table/tbody/tr[2]/td[2]/input",
					faixasTaxa.getValorFinalPl());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/table/tbody/tr[2]/td[2]/input",
					faixasTaxa.getValorFinalPl());
		}
	}

	private void preencherValorInicialPl(FaixasTaxas faixasTaxa) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/table/tbody/tr[2]/td[1]/input",
					faixasTaxa.getValorInicialPl());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/table/tbody/tr[2]/td[1]/input",
					faixasTaxa.getValorInicialPl());
		}
	}

	private void escolherTipoTaxaSaida(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getTipoTaxaSaida().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/select");
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getTipoTaxaSaida().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/select");
			}
		}
	}

	private void escolherTipoTaxaEntrada(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getTipoTaxaEntrada().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/select");
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getTipoTaxaEntrada().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/select");
			}
		}
	}

	private void escolherPlBaseCalculoTaxaPerfor(TaxasFundos taxasFundos) {
		try {
			preencherCampoSelectByXPath(
					taxasFundos.getPlBaseCalculoTaxaPerfor().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[5]/td[2]/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					taxasFundos.getPlBaseCalculoTaxaPerfor().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[6]/td[2]/select");
		}
	}

	private void escolherPerioCobrancaTaxaPerfor(TaxasFundos taxasFundos) {
		try {
			preencherCampoSelectByXPath(
					taxasFundos.getPerioCobrancaTaxaPerfor().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					taxasFundos.getPerioCobrancaTaxaPerfor().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[5]/td[2]/select");
		}
	}

	private void escolherPerioCobrancaTaxaAdmin(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[12]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getPerioCobrancaTaxaAdmin().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[12]/td[2]/select");
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[13]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getPerioCobrancaTaxaAdmin().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[13]/td[2]/select");
			}
		}
	}

	private void escolherPeriodoCorrecao(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[7]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getPeriodoCorrecao().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[7]/td[2]/select");
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[8]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getPeriodoCorrecao().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[8]/td[2]/select");
			}
		}
	}

	private void escolherIndiceCorrecao(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[6]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getIndiceCorrecao().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[6]/td[2]/select");
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[7]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getIndiceCorrecao().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[7]/td[2]/select");
			}
		}
	}

	private void escolherUnidadeTaxaAdministracao(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getUnidadeTaxaAdministracao().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/select");
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/select")) {
				preencherCampoSelectByXPath(
						taxasFundos.getUnidadeTaxaAdministracao().getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/select");
			}
		}
	}

	private void escolherPerfilTaxaAdminstracao(TaxasFundos taxasFundos) {
		try {
			preencherCampoSelectByXPath(
					taxasFundos.getPerfilTaxaAdminstracao().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					taxasFundos.getPerfilTaxaAdminstracao().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/select");
		}
	}

	private void preencherInfoAdicionalTaxaSaida(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/textarea")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/textarea",
						taxasFundos.getInfoAdicionalTaxaSaida());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/textarea")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/textarea",
						taxasFundos.getInfoAdicionalTaxaSaida());
			}
		}
	}

	private void preencherValorTaxaSaida(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/input",
						taxasFundos.getValorTaxaSaida());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/input",
						taxasFundos.getValorTaxaSaida());
			}
		}
	}

	private void preencherInfoAdicionaiTaxaEntrada(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/textarea")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/textarea",
						taxasFundos.getInfoAdicionaisTaxaEntrada());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/textarea")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/textarea",
						taxasFundos.getInfoAdicionaisTaxaEntrada());
			}
		}
	}

	private void preencherValorTaxaEntrada(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[7]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/input",
						taxasFundos.getValorTaxaEntrada());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[5]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/input",
						taxasFundos.getValorTaxaEntrada());
			}
		}
	}

	private void preencherInfoAdicionaisTaxaPerfor(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/textarea")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/textarea",
						taxasFundos.getInfoAdicionaisTaxaPerfor());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[12]/td[2]/textarea")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[12]/td[2]/textarea",
						taxasFundos.getInfoAdicionaisTaxaPerfor());
			}
		}
	}

	private void escolherAjustePerforCotista(TaxasFundos taxasFundos) {
		if (taxasFundos.isAjustePerforCotista()) {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/input");
			}
		} else {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[10]/td[4]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[11]/td[4]/input");
			}
		}
	}

	private void escolherBaseCalculoTaxaPerfor(TaxasFundos taxasFundos) {
		if (taxasFundos.getBaseCalculoTaxaPerfor().equalsIgnoreCase("PL")) {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[9]/td[2]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[9]/td[2]/input");
			}
		} else {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[10]/td[4]/input");
			}
		}
	}

	private void escolherZeramentoPerformance(TaxasFundos taxasFundos) {
		if (taxasFundos.isZeramentoPerformance()) {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[8]/td[2]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[9]/td[2]/input");
			}
		} else {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[8]/td[4]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[9]/td[4]/input");
			}
		}
	}

	private void escolherLinhaDagua(TaxasFundos taxasFundos) {
		if (taxasFundos.isLinhaDagua()) {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[7]/td[2]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[8]/td[2]/input");
			}
		} else {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[7]/td[4]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[8]/td[4]/input");
			}
		}
	}

	private void escolherDiaUtilCalculoTaxaPerfor(TaxasFundos taxasFundos) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[6]/td[2]/input",
					taxasFundos.getDiaUtilCalculoTaxaPerfor());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[7]/td[2]/input",
					taxasFundos.getDiaUtilCalculoTaxaPerfor());
		}
	}

	private void escolherCupomTaxaPerfonce(TaxasFundos taxasFundos) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/input",
					taxasFundos.getCupomTaxaPerformance());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/input",
					taxasFundos.getCupomTaxaPerformance());
		}
	}

	private void escolherCobraTaxaPerformance(TaxasFundos taxasFundos) {
		if (taxasFundos.isCobraTaxaPerformance()) {
			escolherCobraTaxaPerformance();
			preencherTaxaPerformance(taxasFundos);
			escolherCupomTaxaPerfonce(taxasFundos);
			escolherPerioCobrancaTaxaPerfor(taxasFundos);
			escolherPlBaseCalculoTaxaPerfor(taxasFundos);
			escolherDiaUtilCalculoTaxaPerfor(taxasFundos);
			escolherLinhaDagua(taxasFundos);
			escolherZeramentoPerformance(taxasFundos);
			escolherBaseCalculoTaxaPerfor(taxasFundos);
			escolherAjustePerforCotista(taxasFundos);
			preencherInfoAdicionaisTaxaPerfor(taxasFundos);
		} else {
			escolherNaoCobraTaxaPerformance();
		}
	}

	private void escolherNaoCobraTaxaPerformance() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[1]/td[4]/input");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[4]/input");
		}
	}

	private void escolherCobraTaxaPerformance() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[1]/td[2]/input");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[3]/td/table/tbody/tr/td/div/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/input");
		}
	}

	private void escolherInfoAdicionaisTaxaNaoPadronizada(
			TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[13]/td[2]/textarea")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[13]/td[2]/textarea",
						taxasFundos.getInfoAdicionaisTaxaNaoPadronizada());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[14]/td[2]/textarea")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[14]/td[2]/textarea",
						taxasFundos.getInfoAdicionaisTaxaNaoPadronizada());
			}
		}
	}

	private void escolherTaxaMaxima(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[9]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[9]/td[2]/input",
						taxasFundos.getTaxaMaxima());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/input",
						taxasFundos.getTaxaMaxima());
			}
		}
	}

	private void escolherAplicaOutrosFundos(TaxasFundos taxasFundos) {
		if (taxasFundos.isAplicaOutrosFundos()) {
			try {
				if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[8]/td[2]/input")) {
					clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[8]/td[2]/input");
				}
			} catch (Exception e) {
				if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[9]/td[2]/input")) {
					clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[9]/td[2]/input");
				}
			}
		} else {
			try {
				if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[8]/td[4]/input")) {
					clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[8]/td[4]/input");
				}
			} catch (Exception e) {
				if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[9]/td[4]/input")) {
					clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[9]/td[4]/input");
				}
			}
		}
	}

	private void escolherValorPiso(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[5]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[5]/td[2]/input",
						taxasFundos.getValorPiso());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[6]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[6]/td[2]/input",
						taxasFundos.getValorPiso());
			}
		}
	}

	private void escolherPlBaseCalculoTaxa(TaxasFundos taxasFundos) {
		if (taxasFundos.getPlBaseCalculoTaxa().equalsIgnoreCase("PL de D0")) {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[5]/td[2]/table/tbody/tr/td[1]/input");
			}
		} else {
			try {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[3]/input");
			} catch (Exception e) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[5]/td[2]/table/tbody/tr/td[3]/input");
			}
		}
	}

	private void escolherValorTaxaAdminstracao(TaxasFundos taxasFundos) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/input",
						taxasFundos.getValorTaxaAdminstracao());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[1]/div/table/tbody/tr[1]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/input",
						taxasFundos.getValorTaxaAdminstracao());
			}
		}
	}
}
