package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.file.entidades.DatasFundos;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaDatasFundos extends TelaPrincipal {

	public TelaPrestadoresServicoFundo preencherAba(DatasFundos datasFundos) {
		if (datasFundos.isFasePreOperacional()) {
			escolherFaseOperacional();
		} else {
			escolherFaseNaoOperacional();
			preencherDataInicioAtividade(datasFundos);
		}

		preencherDataPublicInicioOferta(datasFundos);
		preencherDataVinculacaoAnbid(datasFundos);
		preencherDataDesvinculacaoAnbid(datasFundos);
		preencherDataAssembleia(datasFundos);
		preencherDataProtocoloCVM(datasFundos);
		preencherDataInicioValidadeAlteracao(datasFundos);
		clicarProxima();
		return new TelaPrestadoresServicoFundo();
	}

	private void preencherDataInicioValidadeAlteracao(DatasFundos datasFundos) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[11]/td[2]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[11]/td[2]/div[1]/input",
					datasFundos.getDataInicioValidadeAlteracao());
		}
	}

	private void preencherDataProtocoloCVM(DatasFundos datasFundos) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[9]/td[2]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[9]/td[2]/div[1]/input",
					datasFundos.getDataProtocoloCVM());
		}
	}

	private void preencherDataAssembleia(DatasFundos datasFundos) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[8]/td[2]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[8]/td[2]/div[1]/input",
					datasFundos.getDataAssembleia());
		}
	}

	private void preencherDataDesvinculacaoAnbid(DatasFundos datasFundos) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[8]/td[2]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[8]/td[2]/div[1]/input",
					datasFundos.getDataDesvinculacaoAnbid());
		}
	}

	private void preencherDataVinculacaoAnbid(DatasFundos datasFundos) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[6]/td[2]/div[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[6]/td[2]/div[1]/input",
					datasFundos.getDataVinculacaoAnbid());
		}
	}

	private void preencherDataPublicInicioOferta(DatasFundos datasFundos) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td[1]/input",
					datasFundos.getDataPublicInicioOferta());
		}
	}

	private void clicarProxima() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/div[3]/button[1]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/div[4]/button[1]");
		}
	}

	private void preencherDataInicioAtividade(DatasFundos datasFundos) {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[1]/input")) {
			preencheCampoXPath(
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[1]/input",
					datasFundos.getDataInicioAtividade());
		}
	}

	private void escolherFaseNaoOperacional() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/input");
	}

	private void escolherFaseOperacional() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[10]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input");
	}

}
