package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.PublicoAlvo;
import br.com.galgo.testes.recursos_comuns.file.entidades.PerfilFundo;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaPerfilFundos extends TelaPrincipal {

	public TelaDatasFundos preencherAba(PerfilFundo perfil) {
		esperarSegundos(5);
		escolherClassificacaoCVM(perfil);
		escolherCategoriaAnbid(perfil);
		escolherTipoAnbid(perfil);
		escolherPlanoPrevidencia(perfil);
		escolherAplicacaoAutomatica(perfil);
		escolherFocoAtuacao(perfil);
		escolherCalculaCota(perfil);
		preencherHorarioCompromPlCota(perfil);
		preencherHorarioCompromPosicao(perfil);
		escolherPeriodicidadeDivulgacao(perfil);
		escolherAbertoEstaturiamente(perfil);
		preencherDuracaoFundo(perfil);
		escolherComposicao(perfil);
		escolherInvestidorQualificado(perfil);
		escolherPrevidenciario(perfil);
		escolherAlavancado(perfil);
		escolherCreditoPrivado(perfil);
		escolherInvestimentoExterior(perfil);
		escolherRestricaoInvestimento(perfil);
		escolherPublicoAlvo(perfil);
		escolherDivulgacaoImprensa(perfil);
		escolherTributacaoPerseguida(perfil);
		escolherPossuiPorspecto(perfil);
		clicarProxima();

		return new TelaDatasFundos();
	}

	private void escolherRespeitaLimitesEmissosAtivo(PerfilFundo perfil) {
		if (perfil.isRespeitaLimitesEmissosAtivo()) {
			preencherCampoSelectByXPath(
					"1",
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[25]/td[2]/select");
		} else {
			preencherCampoSelectByXPath(
					"2",
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[25]/td[2]/select");
		}
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/div[3]/button[1]");
	}

	private void escolherPublicoAlvo(PerfilFundo perfil) {
		final List<PublicoAlvo> publicoAlvoList = perfil.getPublicoAlvo();
		if (publicoAlvoList.size() == 1) {
			preencherCampoSelectByXPath(
					publicoAlvoList.get(0).getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[23]/td[2]/table/tbody/tr[2]/td/select");
		} else {
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				for (PublicoAlvo publicoAlvo : publicoAlvoList) {
					preencherCampoSelectByXPath(
							publicoAlvo.getValue(),
							"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[23]/td[2]/table/tbody/tr[2]/td/select");
				}
				robot.keyRelease(KeyEvent.VK_CONTROL);
			} catch (AWTException e) {
				Assert.fail("Problema ao clicar no Ctrl_click do publico alvo");
			}
		}
	}

	private void escolherTributacaoPerseguida(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getTributacaoPerseguida().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[26]/td[2]/select");
	}

	private void escolherPossuiPorspecto(PerfilFundo perfil) {
		if (perfil.isPossuiPorspecto()) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[27]/td[2]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[27]/td[3]/div[1]/input");
		}
	}

	private void escolherDivulgacaoImprensa(PerfilFundo perfil) {
		if (perfil.isDivulgacaoImprensa()) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[24]/td[2]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[24]/td[3]/div[1]/input");
		}
	}

	private void escolherRestricaoInvestimento(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getRestricaoInvestimento().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[22]/td[2]/select");
	}

	private void escolherInvestimentoExterior(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getInvestimentoExterior().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[21]/td[2]/select");
	}

	private void escolherCreditoPrivado(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getCreditoPrivado().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[20]/td[2]/select");
	}

	private void escolherPrevidenciario(PerfilFundo perfil) {
		if (perfil.isPrevidenciario()) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[19]/td[2]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[19]/td[3]/div[1]/input");
		}
	}

	private void escolherAlavancado(PerfilFundo perfil) {
		if (perfil.isAlavancado()) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[18]/td[2]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[18]/td[3]/div[1]/input");
		}
	}

	private void escolherInvestidorQualificado(PerfilFundo perfil) {
		if (perfil.isInvestidorQualificado()) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[17]/td[2]/div[1]/input");
			escolherRespeitaLimitesEmissosAtivo(perfil);
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[17]/td[3]/div[1]/input");
		}
	}

	private void escolherComposicao(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getComposicao().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[16]/td[2]/select");
	}

	private void preencherDuracaoFundo(PerfilFundo perfil) {
		if (perfil.getDuracaoFundo().equalsIgnoreCase("INDETERMINADO")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[12]/td[2]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[12]/td[3]/div[1]/input[2]");
			escolherUnidadeDuracaoFundo(perfil);
			preencherPrazoDuracaoFundo(perfil);
			escolherBaseDuracaoFundo(perfil);
		}
	}

	private void escolherBaseDuracaoFundo(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getBaseDuracaoFundo().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[13]/td[2]/select");
	}

	private void preencherPrazoDuracaoFundo(PerfilFundo perfil) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[14]/td[2]/input",
				perfil.getPrazoDuracaoFundo());
	}

	private void escolherUnidadeDuracaoFundo(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getUnidadeDuracaoFundo().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[13]/td[2]/select");
	}

	private void escolherAbertoEstaturiamente(PerfilFundo perfil) {
		if (perfil.isAbertoEstaturiamente()) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[11]/td[2]/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[11]/td[3]/div[1]/input");
		}
	}

	private void escolherPeriodicidadeDivulgacao(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getPeriodicidadeDivulgacao().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[10]/td[2]/select");
	}

	private void preencherHorarioCompromPosicao(PerfilFundo perfil) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[9]/td[2]/input",
				perfil.getHorarioCompromPosicao());
	}

	private void preencherHorarioCompromPlCota(PerfilFundo perfil) {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[8]/td[2]/input",
				perfil.getHorarioCompromPlCota());
	}

	private void escolherCalculaCota(PerfilFundo perfil) {
		if (perfil.getCalculaCota().equalsIgnoreCase("ABERTURA")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[7]/td[2]/div/div[1]/input");
		} else {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[7]/td[3]/div/div[1]/input");
		}
	}

	private void escolherFocoAtuacao(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getFocoAtuacao().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[6]/td[2]/select");
	}

	private void escolherAplicacaoAutomatica(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getAplicacaoAutomatica().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[5]/td[2]/select");
	}

	private void escolherPlanoPrevidencia(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getPlanoPrevidencia().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[4]/td[2]/select");
	}

	private void escolherTipoAnbid(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getTipoAnbid().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[3]/td[2]/select");
	}

	private void escolherCategoriaAnbid(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getCategoriaAnbid().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[2]/td[2]/select");
	}

	private void escolherClassificacaoCVM(PerfilFundo perfil) {
		preencherCampoSelectByXPath(
				perfil.getClassificacaoCVM().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[8]/div/table/tbody/tr[1]/td[2]/select");
	}
}
