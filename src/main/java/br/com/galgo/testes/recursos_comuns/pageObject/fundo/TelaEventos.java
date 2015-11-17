package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.Evento;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.pageObject.consulta.TelaConsultaFundo;

public class TelaEventos extends TelaPrincipal {

	public TelaPerfilFundos preencherAba(Evento evento) {

		if (evento.isFundoInicializadoPorEventoCorp()) {
			escolherIniciadoPorEventoCorp();
			escolherEvento(evento);
			escolherFundoOrigem(evento);
		} else {
			escolherFundoNaoIniciacoPorEventoCorp();
		}

		clicarProximo();
		return new TelaPerfilFundos();
	}

	public TelaPerfilFundosAlteracao preencherAba(Evento evento,
			Operacao operacao) {
		if (operacao == Operacao.ALTERACAO_FUNDO) {
			preencherAba(evento);
			return new TelaPerfilFundosAlteracao();
		}
		return null;
	}

	private void clicarProximo() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/div[3]/button[1]");
	}

	private void escolherFundoNaoIniciacoPorEventoCorp() {
		if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/input")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/input");
		}
		// se der erro é cnpj já cadastrado
	}

	private void escolherFundoOrigem(Evento evento) {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/table/tbody/tr[3]/td[3]/table/tbody/tr/td[1]/a/input");
		TelaConsultaFundo telaConsultaFundo = new TelaConsultaFundo();
		telaConsultaFundo.consultarFundo(evento.getFundoInvestimentoOrigem());
	}

	private void escolherEvento(Evento evento) {
		preencherCampoSelectByXPath(
				evento.getEvento(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/table/tbody/tr[2]/td[2]/select");
	}

	private void escolherIniciadoPorEventoCorp() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input");
	}
}
