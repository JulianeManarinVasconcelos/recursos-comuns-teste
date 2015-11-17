package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.file.entidades.Amortizacao;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaAmortizacao extends TelaPrincipal {

	public TelaContasFundo preencherAba(Amortizacao amortizacao) {

		if (amortizacao.isPossuiMecanismoAmortizacao()) {
			escolherPossuiAmortizacao();
			preencherDataPrimeiraAmortizacao(amortizacao);
			preencherPeriodicidadeAmortizacao(amortizacao);
			preencherDataBaseAmortizacao(amortizacao);
			preencherDiaUtilAmortizacao(amortizacao);
			preencherObservacoesAmortizacao(amortizacao);
		} else {
			escolherNaoPossuiAmortizacao();
		}

		clicarProxima();
		return new TelaContasFundo();
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div/div[3]/button[1]");
	}

	private void preencherObservacoesAmortizacao(Amortizacao amortizacao) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr[5]/td[2]/textarea",
				amortizacao.getObservacoesAmortizacao());
	}

	private void preencherDiaUtilAmortizacao(Amortizacao amortizacao) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr[4]/td[2]/input",
				amortizacao.getDiaUtilAmortizacao());
	}

	private void preencherDataBaseAmortizacao(Amortizacao amortizacao) {
		preencherCampoSelectByXPath(
				amortizacao.getDataBaseAmortizacao().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input");
	}

	private void preencherPeriodicidadeAmortizacao(Amortizacao amortizacao) {
		preencherCampoSelectByXPath(
				amortizacao.getPeriodicidadeAmortizacao().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input");
	}

	private void preencherDataPrimeiraAmortizacao(Amortizacao amortizacao) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input",
				amortizacao.getDataPrimeiraAmortizacao());
	}

	private void escolherNaoPossuiAmortizacao() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[3]/input");
	}

	private void escolherPossuiAmortizacao() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[3]/div/table/tbody/tr[1]/td/table/tbody/tr/td[2]/table/tbody/tr/td[1]/input");
	}
}
