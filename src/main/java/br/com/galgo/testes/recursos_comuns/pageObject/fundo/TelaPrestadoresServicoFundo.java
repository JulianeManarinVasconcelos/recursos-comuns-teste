package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.fundo.Distribuidor;
import br.com.galgo.testes.recursos_comuns.file.entidades.PrestadoresServicoFundo;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;

public class TelaPrestadoresServicoFundo extends TelaPrincipal {

	public TelaTaxasFundos preencherAba(
			PrestadoresServicoFundo prestadoresServico) {
		escolherAdministrador(prestadoresServico);
		preencherDataInicioVigAdmin(prestadoresServico);
		escolherAgenciaClassificacaoRisco(prestadoresServico);
		escolherConsultoria(prestadoresServico);
		escolherContabilidade(prestadoresServico);
		escolherControladorAtivos(prestadoresServico);
		preencherDataVigControlodarAtivos(prestadoresServico);
		escolherControladorPassivos(prestadoresServico);
		preencherDataInicioVigControladorPassivos(prestadoresServico);
		// coordenadorDistribuidorLider
		escolherCustodianteUnico(prestadoresServico);
		preencherDataInicioVigCustodianteUnico(prestadoresServico);
		escolherCustodianteCotas(prestadoresServico);
		preencherDataInicioVigCustodianteCotas(prestadoresServico);
		escolherCustodianteDerivativos(prestadoresServico);
		preencherDataInicioVigCustodianteDerivativos(prestadoresServico);
		escolherCustodiantesRendaFixa(prestadoresServico);
		preencherDataInicioVigCustodianteRendaFixa(prestadoresServico);
		escolherCustodianteRendaVariavel(prestadoresServico);
		preencherDataInicioVigCustodianteRendaVariavel(prestadoresServico);
		escolherDistribuidor(prestadoresServico);
		escolherEmpresaAvaliacaoRisco(prestadoresServico);
		escolherEscrituradorCotas(prestadoresServico);
		escolherGestorUnico(prestadoresServico);
		preencherDataInicioVigGestorUnico(prestadoresServico);
		escolherGestorCotas(prestadoresServico);
		preencherDataInicioVigGestorCotas(prestadoresServico);
		escolherGestorDerivativos(prestadoresServico);
		preencherDataInicioVigGestorDerivativos(prestadoresServico);
		escolherGestorRendaFixa(prestadoresServico);
		preencherDataInicioVigGestorRendaFixa(prestadoresServico);
		escolherGestorRendaVariavel(prestadoresServico);
		preencherDataInicioVigGestorRendaVariavel(prestadoresServico);
		escolherAuditoria(prestadoresServico);
		clicarProxima();

		return new TelaTaxasFundos();
	}

	private void preencherDataInicioVigGestorRendaVariavel(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataGestorRendaVar())) {
			preencheCampoXPath(getDataGestorRendaVar(),
					prestadoresServico.getDataInicioVigGestorRendaVariavel());
		}
	}

	private String getDataGestorRendaVar() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[11]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigGestorRendaFixa(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataGestorRendaFixa())) {
			preencheCampoPorId("dtIniVigGestorRendaFixa",
					prestadoresServico.getDataInicioVigGestorRendaFixa());
		}
	}

	private String getDataGestorRendaFixa() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[9]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigGestorDerivativos(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataGestorDeriva())) {
			preencheCampoXPath(getDataGestorDeriva(),
					prestadoresServico.getDataInicioVigGestorDerivativos());
		}
	}

	private String getDataGestorDeriva() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[7]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigGestorCotas(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataGestorCotas())) {
			preencheCampoXPath(getDataGestorCotas(),
					prestadoresServico.getDataInicioVigGestorCotas());
		}
	}

	private String getDataGestorCotas() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[5]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigGestorUnico(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataGestorUnico())) {
			preencheCampoXPath(getDataGestorUnico(),
					prestadoresServico.getDataInicioVigGestorUnico());
		}
	}

	private String getDataGestorUnico() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigCustodianteRendaVariavel(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataCustRendaVar())) {
			preencheCampoXPath(getDataCustRendaVar(),
					prestadoresServico.getDataInicioVigGestorRendaVariavel());
		}
	}

	private String getDataCustRendaVar() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[11]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigCustodianteRendaFixa(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataCustRendaFixa())) {
			preencheCampoXPath(getDataCustRendaFixa(),
					prestadoresServico.getDataInicioVigCustodianteRendaFixa());
		}
	}

	private String getDataCustRendaFixa() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[9]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigCustodianteDerivativos(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataCustDeriv())) {
			preencheCampoXPath(getDataCustDeriv(),
					prestadoresServico.getDataInicioVigCustodianteDerivativos());
		}
	}

	private String getDataCustDeriv() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[7]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigCustodianteCotas(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataCustCotas())) {
			preencheCampoXPath(getDataCustCotas(),
					prestadoresServico.getDataInicioVigCustodianteCotas());
		}
	}

	private String getDataCustCotas() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[5]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigCustodianteUnico(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataCustUnico())) {
			preencheCampoXPath(getDataCustUnico(),
					prestadoresServico.getDataInicioVigCustodianteUnico());
		}
	}

	private String getDataCustUnico() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigControladorPassivos(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataContPassivo())) {
			preencheCampoXPath(getDataContPassivo(),
					prestadoresServico.getDataInicioVigControladorPassivos());
		}
	}

	private String getDataContPassivo() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[11]/td[2]/div[1]/input";
	}

	private void preencherDataVigControlodarAtivos(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoHabilitadoPorXPath(getDataContAtivos())) {
			preencheCampoXPath(getDataContAtivos(),
					prestadoresServico.getDataInicioVigControladorAtivos());
		}
	}

	private String getDataContAtivos() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[9]/td[2]/div[1]/input";
	}

	private void preencherDataInicioVigAdmin(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getDataVigAdmin())) {
			preencheCampoXPath(getDataVigAdmin(),
					prestadoresServico.getDataInicioVigAdmin());
		}
	}

	private String getDataVigAdmin() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[2]/td[2]/div[1]/input";
	}

	private void clicarProxima() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/div[1]/button[1]");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/div[3]/button[1]");
		}
	}

	private void escolherDistribuidor(PrestadoresServicoFundo prestadoresServico) {
		final List<Distribuidor> distribuidorList = prestadoresServico
				.getDistribuidorAgenteAutonomo();
		if (distribuidorList.size() == 1) {
			try {
				preencherCampoSelectByXPath(
						distribuidorList.get(0).getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[11]/td[2]/table/tbody/tr/td/select");
			} catch (Exception e) {
				preencherCampoSelectByXPath(
						distribuidorList.get(0).getValue(),
						"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[15]/td[2]/table/tbody/tr/td/select");
			}
		} else {
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				for (Distribuidor distribuidor : distribuidorList) {
					try {
						preencherCampoSelectByXPath(
								distribuidor.getValue(),
								"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[11]/td[2]/table/tbody/tr/td/select");
					} catch (Exception e) {
							preencherCampoSelectByXPath(
									distribuidor.getValue(),
									"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[15]/td[2]/table/tbody/tr/td/select");
					}
				}
				robot.keyRelease(KeyEvent.VK_CONTROL);
			} catch (AWTException e) {
				Assert.fail("Problema ao clicar no Ctrl_click do publico alvo");
			}
		}
	}

	private void escolherGestorRendaVariavel(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorRendaVariavel().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[14]/td/table/tbody/tr/td/div/table/tbody/tr[6]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorRendaVariavel().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[10]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherGestorRendaFixa(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorRendaFixa().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[14]/td/table/tbody/tr/td/div/table/tbody/tr[5]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectById(prestadoresServico.getGestorRendaFixa()
					.getValue(), "select_gestorRFixa_abaPrestServ");
		}
	}

	private void escolherGestorDerivativos(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorDerivativos().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[14]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorDerivativos().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[6]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherGestorCotas(PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorCotas().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[14]/td/table/tbody/tr/td/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorCotas().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherGestorUnico(PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorUnico().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[14]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getGestorUnico().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[18]/td/table/tbody/tr/td/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherEscrituradorCotas(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getEscrituradorCotas().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getEscrituradorCotas().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[17]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherEmpresaAvaliacaoRisco(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getEmpresaAvalicaoRisco().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[12]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getEmpresaAvalicaoRisco().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[16]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherCustodianteRendaVariavel(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodianteRendaVariavel().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[9]/td/table/tbody/tr/td/table/tbody/tr[6]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodianteRendaVariavel().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[10]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherCustodiantesRendaFixa(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodiantesRendaFixa().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[9]/td/table/tbody/tr/td/table/tbody/tr[5]/td[2]/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodiantesRendaFixa().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[8]/td[2]/div/select");
		}
	}

	private void escolherCustodianteDerivativos(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodianteDerivativos().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[9]/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodianteDerivativos().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[6]/td[2]/div/select");
		}
	}

	private void escolherCustodianteCotas(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodianteCotas().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[9]/td/table/tbody/tr/td/table/tbody/tr[3]/td[2]/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodianteCotas().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[4]/td[2]/div/select");
		}
	}

	private void escolherCustodianteUnico(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodianteUnico().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[9]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getCustodianteUnico().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[13]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/div/select");

		}
	}

	private void escolherControladorPassivos(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getControladorPassivo().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[7]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getControladorPassivo().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[8]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherControladorAtivos(
			PrestadoresServicoFundo prestadoresServico) {

		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getControladorAtivo().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[6]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getControladorAtivo().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[8]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherContabilidade(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getContabilidade().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[5]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getContabilidade().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[7]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherConsultoria(PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getConsultoria().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getConsultoria().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[6]/td[2]/table/tbody/tr/td/select");
		}
	}

	private void escolherAuditoria(PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getAuditoria().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getAuditoria().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[4]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherAgenciaClassificacaoRisco(
			PrestadoresServicoFundo prestadoresServico) {
		try {
			preencherCampoSelectByXPath(
					prestadoresServico.getAgenciaClassificacaoRisco()
							.getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[2]/td[2]/table/tbody/tr/td/div/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					prestadoresServico.getAgenciaClassificacaoRisco()
							.getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[3]/td[2]/table/tbody/tr/td/div/select");
		}
	}

	private void escolherAdministrador(
			PrestadoresServicoFundo prestadoresServico) {
		if (verificaCampoVisivelPorXPath(getAdmin())) {
			preencherCampoSelectByXPath(prestadoresServico.getAdministrador()
					.getValue(), getAdmin());
		}
	}

	private String getAdmin() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[11]/div/table/tbody/tr[1]/td[2]/div/select";
	}

}
