package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.enumerador.carteira.TipoCota;
import br.com.galgo.testes.recursos_comuns.file.entidades.PerfilCarteira;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaPerfilCarteira extends TelaPrincipal {

	public TelaDatasCarteira preencherAba(PerfilCarteira perfil) {
		escolherTipoCota(perfil);
		preencherHorarioCompPlCota(perfil);
		preencherHorarioCompPosicao(perfil);
		escolherCategoriaAnbid(perfil);
		escolherTipoInvestidor(perfil);
		clicarProxima();

		return new TelaDatasCarteira();
	}

	private void escolherTipoInvestidor(PerfilCarteira perfil) {
		preencherCampoSelectById(perfil.getTipoIvestidor().getValue(),
				"tipoInvestidor");
	}

	private void escolherCategoriaAnbid(PerfilCarteira perfil) {
		preencherCampoSelectById(perfil.getCategoriaAnbid().getValue(),
				"categoriaANBID");
	}

	private void preencherHorarioCompPosicao(PerfilCarteira perfil) {
		preencheCampoPorId("horarioCompPosAtivoCarteira",
				perfil.getHorarioCompPosiaco());
	}

	private void preencherHorarioCompPlCota(PerfilCarteira perfil) {
		preencheCampoPorId("horarioCompPlCota", perfil.getHorarioCompPlCota());
	}

	private void escolherTipoCota(PerfilCarteira perfil) {
		if (perfil.getCalculoCotas() == TipoCota.ABERTURA) {
			clicarTipoAbertura();
		} else {
			clicarTipoFechamento();
		}
	}

	private void clicarTipoAbertura() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[5]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[1]/input");
	}

	private void clicarTipoFechamento() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[5]/div/table/tbody/tr[1]/td[2]/table/tbody/tr/td[3]/input");
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[5]/div/div[1]/button[1]");
	}

}
