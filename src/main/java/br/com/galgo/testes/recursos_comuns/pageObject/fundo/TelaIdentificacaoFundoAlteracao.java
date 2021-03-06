package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.file.entidades.IdentificaoFundo;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaIdentificacaoFundoAlteracao extends TelaPrincipal {

	public TelaEventos preencherAba(IdentificaoFundo identificaoFundo) {
		preencherRazaoSocial(identificaoFundo);
		preencherDataInicioVigRazaoSocial(identificaoFundo);
		preencherNomeFantasia(identificaoFundo);
		preencherDataInicioVigNomeFantasia(identificaoFundo);
		preencherNomeFantasioImprensa(identificaoFundo);
		preencherSigla(identificaoFundo);
		preencherMnemonicoCETIP(identificaoFundo);
		preencherISIN(identificaoFundo);
		preencherCUSIP(identificaoFundo);
		preencherDivulgacaoAnbid(identificaoFundo);
		preencherAlteracaoImplicaAnalise(identificaoFundo);
		clicarProxima();
		return new TelaEventos();
	}

	private void preencherAlteracaoImplicaAnalise(
			IdentificaoFundo identificaoFundo) {
		if (identificaoFundo.isAlteracaoImplicaAnalise()) {
			clicarAlteracaoImplicaAnalise();
		} else {
			clicarNaoImplicaAnalise();
		}
	}

	private void clicarNaoImplicaAnalise() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[18]/td[2]/table/tbody/tr/td[3]/input");
	}

	private void clicarAlteracaoImplicaAnalise() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[18]/td[2]/table/tbody/tr/td[1]/input");
	}

	private void preencherDataInicioVigNomeFantasia(
			IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[7]/td[2]/div[1]/input",
				identificaoFundo.getDataInicioVigNomeFantasia());
	}

	private void preencherDataInicioVigRazaoSocial(
			IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[5]/td[2]/div[1]/input",
				identificaoFundo.getDataInicioVigRazaoSocial());
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/div[3]/button");
	}

	private void preencherRazaoSocial(IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[4]/td[2]/input",
				identificaoFundo.getRazaoSocial());
	}

	private void preencherNomeFantasia(IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[6]/td[2]/input",
				identificaoFundo.getNomeFantasia());
	}

	private void preencherNomeFantasioImprensa(IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[8]/td[2]/input",
				identificaoFundo.getNomeFantasioImprensa());
	}

	private void preencherSigla(IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[9]/td[2]/input",
				identificaoFundo.getSigla());
	}

	private void preencherMnemonicoCETIP(IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[10]/td[2]/input",
				identificaoFundo.getMnemonicoCETIP());
	}

	private void preencherISIN(IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[11]/td[2]/input",
				identificaoFundo.getISIN());
	}

	private void preencherCUSIP(IdentificaoFundo identificaoFundo) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[12]/td[2]/input",
				identificaoFundo.getCUSIP());
	}

	private void preencherDivulgacaoAnbid(IdentificaoFundo identificaoFundo) {
		if (identificaoFundo.isDivulgacaoAnbid()) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[13]/td[2]/table/tbody/tr/td[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[6]/div/table/tbody/tr[13]/td[2]/table/tbody/tr/td[3]/input");
		}
	}

}
