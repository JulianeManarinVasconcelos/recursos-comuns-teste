package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.file.entidades.DoctosAnexadosCarteira;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.thread.FazerUpload;

public class TelaDoctosAnexadosCarteira extends TelaPrincipal {

	public TelaInclusaoCarteira preencherAba(
			DoctosAnexadosCarteira doctosAnexados) {

		clicarAnexardocumentos();
		preencherContratoAdministracao(doctosAnexados);
		preencherOutrosDoctos(doctosAnexados);
		clicarVoltar();
		clicarFinalizar();

		return new TelaInclusaoCarteira();
	}

	private void clicarFinalizar() {
		clicarItemPorName("btConfirmar");
	}

	private void clicarVoltar() {
		clicarItemPorId("btVoltar");
	}

	private void preencherOutrosDoctos(DoctosAnexadosCarteira doctosAnexados) {
		final String outrosDoctos = doctosAnexados.getOutrosDoctos();
		if (!outrosDoctos.equals("")) {
			clicarSelecionarOutrosDoctos();
			FazerUpload fazerUpload = new FazerUpload(outrosDoctos);
			fazerUpload.upload(false);
			escolherIdiomaOutrosDoctos(doctosAnexados);
			preencherDescricao();
			clicarIncluirOutrosDoctos();
		}
	}

	private void clicarIncluirOutrosDoctos() {
		clicarItemPorXPath("img_incluir_outro_habilitada");
	}

	private void preencherDescricao() {
		preencheCampoPorId("dsDescricaoOutro", "Outros Doctos Teste");
	}

	private void escolherIdiomaOutrosDoctos(
			DoctosAnexadosCarteira doctosAnexados) {
		preencherCampoSelectById(doctosAnexados.getIdiomaOutrosDoctos()
				.getValue(), "idIdioma_outro");
	}

	private void clicarSelecionarOutrosDoctos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/table[2]/tbody/tr[2]/td/div/div[2]/table[1]/tbody/tr[1]/td[2]/input");
	}

	private void preencherContratoAdministracao(
			DoctosAnexadosCarteira doctosAnexados) {
		final String contrato = doctosAnexados.getContratoAdministracao();
		if (!contrato.equals("")) {
			clicarSelecionarArqContrato();
			FazerUpload fazerUpload = new FazerUpload(contrato);
			fazerUpload.upload(false);
			escolherIdiomaContrato(doctosAnexados);
			clicarIncluirContrato();
		}
	}

	private void clicarIncluirContrato() {
		clicarItemPorId("img_incluir_contratoAdm_habilitada");
	}

	private void escolherIdiomaContrato(DoctosAnexadosCarteira doctosAnexados) {
		preencherCampoSelectById(doctosAnexados
				.getIdiomaContratoAdministracao().getValue(),
				"idIdioma_contratoAdministracao");
	}

	private void clicarSelecionarArqContrato() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/table[2]/tbody/tr[2]/td/div/div[1]/table[1]/tbody/tr/td[2]/input");
	}

	private void clicarAnexardocumentos() {
		clicarItemPorId("btDocsAnexados");
	}

}
