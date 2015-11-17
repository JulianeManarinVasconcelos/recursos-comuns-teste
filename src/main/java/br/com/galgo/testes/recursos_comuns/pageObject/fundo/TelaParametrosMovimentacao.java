package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.file.entidades.ParametrosMovimentacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaParametrosMovimentacao extends TelaPrincipal {

	public TelaAmortizacao preencherAba(
			ParametrosMovimentacao parametrosMovimentacao) {
		escolherIndicadorPrazoConversaoCotas(parametrosMovimentacao);
		preencherPrazoConversaoCotasAplicacao(parametrosMovimentacao);
		preencherDataInicioVigPrazoConvCotasAplic(parametrosMovimentacao);
		escolherEstabeleceValoresMinimosMovimentacao(parametrosMovimentacao);
		escolherIndicadorPrazoConversaoResgate(parametrosMovimentacao);
		escolherPrazoConversaoResgate(parametrosMovimentacao);
		preencherDataInicioVigPrazoConvResg(parametrosMovimentacao);
		escolherIndicadorPrazoPagtoResgate(parametrosMovimentacao);
		preencherPrazoPrazoPagtoResgate(parametrosMovimentacao);
		preencherDataInicioVigPrazoPagtoResg(parametrosMovimentacao);
		escolherPossuiPagtoResgate(parametrosMovimentacao);
		preencherDataInicioVigPossuiPagtoResg(parametrosMovimentacao);
		preencherCarenciaInicial(parametrosMovimentacao);
		preencherCarenciaCiclica(parametrosMovimentacao);
		escolherAbertoCaptacao(parametrosMovimentacao);
		preencherDataAberturaCaptacao(parametrosMovimentacao);
		preencherDataFechamentoCaptacao(parametrosMovimentacao);
		clicarProxima();
		return new TelaAmortizacao();
	}

	private void preencherDataFechamentoCaptacao(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[19]/td[2]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[19]/td[2]/div[1]/input",
					parametrosMovimentacao.getDataFechamentoCaptacao());
		}
	}

	private void preencherDataInicioVigPossuiPagtoResg(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[9]/td[4]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[9]/td[4]/div[1]/input",
					parametrosMovimentacao.getDataInicioVigPossuiPagtoResg());
		}
	}

	private void preencherDataInicioVigPrazoPagtoResg(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[9]/td[4]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[9]/td[4]/div[1]/input",
					parametrosMovimentacao.getDataInicioVigPrazoPagtoResg());
		}
	}

	private void preencherDataInicioVigPrazoConvResg(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[7]/td[4]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[7]/td[4]/div[1]/input",
					parametrosMovimentacao.getDataInicioVigPrazoConvResg());
		}
	}

	private void preencherDataInicioVigPrazoConvCotasAplic(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[2]/td[4]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[2]/td[4]/div[1]/input",
					parametrosMovimentacao
							.getDataInicioVigPrazoConvCotasAplic());
		}
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/div[3]/button[1]");
	}

	private void preencherDataAberturaCaptacao(
			ParametrosMovimentacao parametrosMovimentacao) {
		try {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[17]/td[2]/div[1]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[17]/td[2]/div[1]/input",
						parametrosMovimentacao.getDataAberturaCaptacao());
			}
		} catch (Exception e) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[18]/td[2]/div[1]/input")) {
				preencheCampoXPath(
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[18]/td[2]/div[1]/input",
						parametrosMovimentacao.getDataAberturaCaptacao());
			}
		}
	}

	private void escolherAbertoCaptacao(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[16]/td[2]/div[1]/div[1]/input")) {
			if (parametrosMovimentacao.isAbertoCaptacao()) {
				try {
					clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[16]/td[2]/div[1]/div[1]/input");
				} catch (Exception e) {
					clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[17]/td[2]/div[1]/div[1]/input");
				}
			} else {
				try {
					clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[16]/td[2]/div[2]/div[1]/input");
				} catch (Exception e) {
					clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[17]/td[2]/div[2]/div[1]/input");
				}
			}
		}
	}

	private void escolherSaldoMinimo(
			ParametrosMovimentacao parametrosMovimentacao) {
		preencheCampoPorId("text_saldoMinmo_abaParamMovim",
				parametrosMovimentacao.getSaldoMinimo());
	}

	private void preencherResgate(ParametrosMovimentacao parametrosMovimentacao) {
		if (verificaCampoVisivelPorId("text_resgate_abaParamMovim")) {
			preencheCampoPorId("text_resgate_abaParamMovim",
					parametrosMovimentacao.getResgate());
		}
	}

	private void preencherCarenciaCiclica(
			ParametrosMovimentacao parametrosMovimentacao) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[13]/td[2]/input",
					parametrosMovimentacao.getRegraPagtoResgate());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[14]/td[2]/input",
					parametrosMovimentacao.getRegraPagtoResgate());
		}
	}

	private void preencherCarenciaInicial(
			ParametrosMovimentacao parametrosMovimentacao) {
		try {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[12]/td[2]/input",
					parametrosMovimentacao.getRegraPagtoResgate());
		} catch (Exception e) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[13]/td[2]/input",
					parametrosMovimentacao.getRegraPagtoResgate());
		}
	}

	private void escolherPossuiPagtoResgate(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (parametrosMovimentacao.isPossuiPagtoResgate()) {
			escolherPossuiPagtoResgSim();
			preencherRegraPagtoResgate(parametrosMovimentacao);
			preencherDataInicioVigRegraPagtoResg(parametrosMovimentacao);
		} else {
			escolherPossuiPagtoResgNao();
		}
	}

	private void preencherDataInicioVigRegraPagtoResg(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[12]/td[2]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[12]/td[2]/div[1]/input",
					parametrosMovimentacao.getDataInicioVigRegraPagtoResg());
		}
	}

	private void escolherPossuiPagtoResgNao() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[10]/td[2]/div[2]/div[1]/input");
	}

	private void escolherPossuiPagtoResgSim() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[10]/td[2]/div[1]");
	}

	private void preencherRegraPagtoResgate(
			ParametrosMovimentacao parametrosMovimentacao) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[11]/td[2]/input",
				parametrosMovimentacao.getRegraPagtoResgate());
	}

	private void preencherPrazoPrazoPagtoResgate(
			ParametrosMovimentacao parametrosMovimentacao) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[9]/td[2]/input",
				parametrosMovimentacao.getPrazoPrazoPagtoResgate());
	}

	private void escolherIndicadorPrazoPagtoResgate(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (parametrosMovimentacao.getIndicadorPrazoPagtoResgate()
				.equalsIgnoreCase("Dias Corridos")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[8]/td[2]/div[1]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[8]/td[2]/div[1]/div[1]/input");
		}
	}

	private void escolherPrazoConversaoResgate(
			ParametrosMovimentacao parametrosMovimentacao) {
		preencheCampoPorId("prazoConvResgate_abaTaxa",
				parametrosMovimentacao.getPrazoConversaoResgate());
	}

	private void escolherIndicadorPrazoConversaoResgate(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (parametrosMovimentacao.getIndicadorPrazoConversaoResgate()
				.equalsIgnoreCase("Dias Corridos")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[6]/td[2]/div[1]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[6]/td[2]/div[2]/div[1]/input");
		}
	}

	private void escolherAplicacaoAdicional(
			ParametrosMovimentacao parametrosMovimentacao) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[5]/td[2]/input",
				parametrosMovimentacao.getAplicacaoAdicional());
	}

	private void escolherAplicacaoInicial(
			ParametrosMovimentacao parametrosMovimentacao) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[4]/td[2]/input",
				parametrosMovimentacao.getAplicacaoInicial());
	}

	private void escolherEstabeleceValoresMinimosMovimentacao(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (parametrosMovimentacao.isEstabeleceValoresMinimosMovimentacao()) {
			escolherEstabeleceValorMinimoSim();
			escolherAplicacaoInicial(parametrosMovimentacao);
			escolherAplicacaoAdicional(parametrosMovimentacao);
			preencherResgate(parametrosMovimentacao);
			escolherSaldoMinimo(parametrosMovimentacao);
		} else {
			escolherEstabelceValorMinimoNao();
		}
	}

	private void escolherEstabelceValorMinimoNao() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/div[2]/div[1]/input");
	}

	private void escolherEstabeleceValorMinimoSim() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[3]/td[2]/div[1]/div[1]/input");
	}

	private void preencherPrazoConversaoCotasAplicacao(
			ParametrosMovimentacao parametrosMovimentacao) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[2]/td[2]/div/input",
				parametrosMovimentacao.getPrazoConversaoCotasAplicacao());
	}

	private void escolherIndicadorPrazoConversaoCotas(
			ParametrosMovimentacao parametrosMovimentacao) {
		if (parametrosMovimentacao.getIndicadorPrazoConversaoCotas()
				.equalsIgnoreCase("Dias Corridos")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div[1]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/div[2]/div[1]/input");
		}
	}

}
