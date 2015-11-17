package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.file.entidades.PrestadoresServicoCarteira;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaPrestadoresServicoCarteira extends TelaPrincipal {

	public TelaContasCarteira preencherAba(
			PrestadoresServicoCarteira prestadoresServico) {
		escolherAdministrador(prestadoresServico);
		escolherAvaliarRisco(prestadoresServico);
		escolherControladorAtivos(prestadoresServico);
		escolherCustodianteUnico(prestadoresServico);
		escolherCustodianteCotas(prestadoresServico);
		escolherCustodianteDerivativos(prestadoresServico);
		escolherCustodiantesRendaFixa(prestadoresServico);
		escolherCustodianteRendaVariavel(prestadoresServico);
		escolherGestorUnico(prestadoresServico);
		escolherGestorCotas(prestadoresServico);
		escolherGestorDerivativos(prestadoresServico);
		escolherGestorRendaFixa(prestadoresServico);
		escolherGestorRendaVariavel(prestadoresServico);

		clicarProxima();

		return new TelaContasCarteira();
	}

	private void clicarProxima() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/table[1]/tbody/tr/td[3]/a/img");
	}

	private void escolherGestorRendaVariavel(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getGestorRendaVariavel()
				.getValue(), "idGestorRVar");
	}

	private void escolherGestorRendaFixa(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getGestorRendaFixa()
				.getValue(), "idGestorRFixa");
	}

	private void escolherGestorDerivativos(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getGestorDerivativos()
				.getValue(), "idGestorDerivativos");
	}

	private void escolherGestorCotas(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(
				prestadoresServico.getGestorCotas().getValue(), "idGestorCotas");
	}

	private void escolherGestorUnico(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(
				prestadoresServico.getGestorUnico().getValue(), "idGestorUnico");
	}

	private void escolherCustodianteRendaVariavel(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico
				.getCustodianteRendaVariavel().getValue(), "idCustodianteRVar");
	}

	private void escolherCustodiantesRendaFixa(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getCustodiantesRendaFixa()
				.getValue(), "idCustodianteRFixa");
	}

	private void escolherCustodianteDerivativos(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getCustodianteDerivativos()
				.getValue(), "idCustodianteDerivativos");
	}

	private void escolherCustodianteCotas(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getCustodianteCotas()
				.getValue(), "idCustodianteCotas");
	}

	private void escolherCustodianteUnico(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getCustodianteUnico()
				.getValue(), "idCustodianteUnico");
	}

	private void escolherControladorAtivos(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getControladorAtivo()
				.getValue(), "idControladorAtivo");
	}

	private void escolherAdministrador(
			PrestadoresServicoCarteira prestadoresServico) {
		if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/table[2]/tbody/tr[2]/td[2]/select")) {
			preencherCampoSelectByXPath(
					prestadoresServico.getAdministrador().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[7]/div/table[2]/tbody/tr[2]/td[2]/select");
		}
	}

	private void escolherAvaliarRisco(
			PrestadoresServicoCarteira prestadoresServico) {
		preencherCampoSelectById(prestadoresServico.getAvaliadorRisco()
				.getValue(), "idAgenciaAvaliacao");
	}

}
