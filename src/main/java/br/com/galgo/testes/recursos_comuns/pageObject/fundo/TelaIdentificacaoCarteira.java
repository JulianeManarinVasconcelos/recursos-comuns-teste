package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.enumerador.carteira.TipoCarteira;
import br.com.galgo.testes.recursos_comuns.file.entidades.IdentificacaoCarteira;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaIdentificacaoCarteira extends TelaPrincipal {

	public TelaPerfilCarteira preencherAba(
			IdentificacaoCarteira identificacaoCarteira, Operacao operacao) {
		if (Operacao.INCLUSAO_CARTEIRA == operacao) {
			escolherTipoCarteira(identificacaoCarteira);
		}
		preencherNome(identificacaoCarteira);
		preencherNomeFantasia(identificacaoCarteira);
		preencherSigla(identificacaoCarteira);
		clicarProxima();
		return new TelaPerfilCarteira();
	}

	private void preencherSigla(IdentificacaoCarteira identificacaoCarteira) {
		preencheCampoPorId("siglaCarteira", identificacaoCarteira.getSigla());
	}

	private void preencherNomeFantasia(
			IdentificacaoCarteira identificacaoCarteira) {
		preencheCampoPorId("nomeFantasia",
				identificacaoCarteira.getNomeFantasia());
	}

	private void preencherNome(IdentificacaoCarteira identificacaoCarteira) {
		preencheCampoPorId("nome", identificacaoCarteira.getNome());
	}

	private void escolherTipoCarteira(
			IdentificacaoCarteira identificacaoCarteira) {

		if (identificacaoCarteira.getTipo() == TipoCarteira.PF) {
			clicarBotaoPF();
			preencherCPF(identificacaoCarteira);
		} else if (identificacaoCarteira.getTipo() == TipoCarteira.PJ) {
			clicarBotaoPJ();
			preencherCNPJ(identificacaoCarteira);
		} else if (identificacaoCarteira.getTipo() == TipoCarteira.INR) {
			clicarINR();
			preencherDoctoEstrangeiro(identificacaoCarteira);
		}
	}

	private void preencherDoctoEstrangeiro(
			IdentificacaoCarteira identificacaoCarteira) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[4]/td[2]/input",
				identificacaoCarteira.getDocto());
	}

	private void clicarINR() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[5]/input");
	}

	private void preencherCNPJ(IdentificacaoCarteira identificacaoCarteira) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[3]/td[2]/input",
				identificacaoCarteira.getDocto());
	}

	private void clicarBotaoPJ() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[3]/input");
	}

	private void preencherCPF(IdentificacaoCarteira identificacaoCarteira) {
		preencherCNPJ(identificacaoCarteira);
	}

	private void clicarBotaoPF() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td[1]/input");
	}

	private void clicarProxima() {
		clicarItemPorXPath(	                       "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[4]/div/div[1]/button");
	}

}
