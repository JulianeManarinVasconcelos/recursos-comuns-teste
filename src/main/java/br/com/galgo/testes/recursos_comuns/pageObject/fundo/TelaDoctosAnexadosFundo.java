package br.com.galgo.testes.recursos_comuns.pageObject.fundo;

import br.com.galgo.testes.recursos_comuns.enumerador.Operacao;
import br.com.galgo.testes.recursos_comuns.file.entidades.DoctosAnexadosFundos;
import br.com.galgo.testes.recursos_comuns.pageObject.TelaPrincipal;
import br.com.galgo.testes.recursos_comuns.thread.FazerUpload;

public class TelaDoctosAnexadosFundo extends TelaPrincipal {

	public TelaInclusaoFundo preencherAba(DoctosAnexadosFundos doctosAnexados,
			Operacao operacao) {

		clicarAnexardocumentos();
		preencherAta(doctosAnexados);
		preencherCartaIsencao(doctosAnexados);
		preencherProspecto(doctosAnexados);
		preencherRegulamento(doctosAnexados);
		preencherOutrosDoctos(doctosAnexados);
		preencherAlteracaoImpactaBDAnbid(doctosAnexados);
		clicarConfirmar();
		clicarVoltar(operacao);
		clicarFinalizar();
		clicarSim();

		return new TelaInclusaoFundo();
	}

	private void clicarConfirmar() {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[2]/tbody/tr[3]/td/input[2]")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[2]/tbody/tr[3]/td/input[2]");
		}
	}

	private void preencherAlteracaoImpactaBDAnbid(
			DoctosAnexadosFundos doctosAnexados) {
		if (verificaCampoVisivelPorId("icAlteracaoImpactaBDANBID_true")) {
			if (doctosAnexados.isAlteracaoImpactaBDAnbid()) {
				clicarItemPorId("icAlteracaoImpactaBDANBID_true");
			} else {
				clicarItemPorId("icAlteracaoImpactaBDANBID_false");
			}
		}
	}

	private void clicarSim() {
		if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[1]/tbody/tr[3]/td/input[1]")) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[1]/tbody/tr[3]/td/input[1]");
		}
	}

	private void clicarFinalizar() {
		try {
			clicarItemPorName("btfinalizar");
		} catch (Exception ex) {
			clicarItemPorCss("html body div#FLYParent table tbody tr td table tbody tr td table tbody tr td div#mainContent table tbody tr td table tbody tr td div.wpsPortletBody form#InserirFundosForm div#divAlteracao table#skin3 tbody tr td input.submit_ativo");
		}
	}

	private void clicarVoltar(Operacao operacao) {
		if (Operacao.INCLUSAO_FUNDO == operacao) {
			if (verificaCampoVisivelPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[2]/tbody/tr[3]/td/input")) {
				clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[2]/tbody/tr[3]/td/input");
			}
		}
	}

	private void preencherOutrosDoctos(DoctosAnexadosFundos doctosAnexados) {
		final String outrosDoctos = doctosAnexados.getOutrosDoctos();
		if (!outrosDoctos.equals("")) {
			if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[7]/table[2]/tbody/tr[1]/td[2]/input")) {
				clicarSelecionarOutrosDoctos();
				FazerUpload fazerUpload = new FazerUpload(outrosDoctos);
				fazerUpload.upload(false);
				escolherIdiomaOutrosDoctos(doctosAnexados);
				preencherDescricao();
				clicarIncluirOutrosDoctos();
			}
		}
	}

	private void clicarIncluirOutrosDoctos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[7]/table[2]/tbody/tr[2]/td[3]/img");
	}

	private void preencherDescricao() {
		preencheCampoXPath(
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[7]/table[2]/tbody/tr[2]/td[2]/input",
				"Outros Doctos Teste");
	}

	private void escolherIdiomaOutrosDoctos(DoctosAnexadosFundos doctosAnexados) {
		preencherCampoSelectByXPath(
				doctosAnexados.getIdiomaOutrosDoctos().getValue(),
				"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[7]/table[2]/tbody/tr[1]/td[3]/select");
	}

	private void clicarSelecionarOutrosDoctos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[7]/table[2]/tbody/tr[1]/td[2]/input");
	}

	private void preencherRegulamento(DoctosAnexadosFundos doctosAnexados) {
		final String regulamento = doctosAnexados.getRegulamento();
		if (!regulamento.equals("")) {
			if (!doctosAnexados.isVersaoAntRegulamentoValida()) {
				if (verificaCampoVisivelPorXPath(getVersaoRegulamentoNaoValida())) {
					if (verificaCampoHabilitadoPorXPath(getVersaoRegulamentoNaoValida())) {
						clicarItemPorXPath(getVersaoRegulamentoNaoValida());
					}
				}
				if (verificaCampoHabilitadoPorId("file_regulamento")) {
					clicarSelecionarRegulamento();
					FazerUpload fazerUpload = new FazerUpload(regulamento);
					fazerUpload.upload(false);
					escolherIdiomaRegulamento(doctosAnexados);
					clicarIncluirRegulamento();
				}
			} else {
				if (verificaCampoVisivelPorXPath(getVersaoRegulamentoValida())) {
					if (verificaCampoHabilitadoPorXPath(getVersaoRegulamentoValida())) {
						clicarItemPorXPath(getVersaoRegulamentoValida());
					}
				}
			}
		} else {
			if (verificaCampoVisivelPorXPath(getVersaoRegulamentoValida())) {
				if (verificaCampoHabilitadoPorXPath(getVersaoRegulamentoValida())) {
					clicarItemPorXPath(getVersaoRegulamentoValida());
				}
			}
		}
	}

	private String getVersaoRegulamentoValida() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[5]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[1]/input";
	}

	private String getVersaoRegulamentoNaoValida() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[5]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[3]/input";
	}

	private void clicarIncluirRegulamento() {
		if (verificaCampoHabilitadoPorId("img_incluir_regulamento_habilitada")) {
			clicarItemPorId("img_incluir_regulamento_habilitada");
		}
	}

	private void escolherIdiomaRegulamento(DoctosAnexadosFundos doctosAnexados) {
		if (verificaCampoHabilitadoPorId("idIdioma_regulamento")) {
			preencherCampoSelectById(doctosAnexados.getIdiomaRegulamento()
					.getValue(), "idIdioma_regulamento");
		}
	}

	private void clicarSelecionarRegulamento() {
		clicarItemPorId("file_regulamento");
	}

	private void preencherProspecto(DoctosAnexadosFundos doctosAnexados) {
		final String prospecto = doctosAnexados.getProspecto();
		if (!prospecto.equals("")) {
			if (!doctosAnexados.isVersaoAntProspectoValida()) {
				if (verificaCampoVisivelPorXPath(getVersaoProspectoNaoValida())) {
					if (verificaCampoHabilitadoPorXPath(getVersaoProspectoNaoValida())) {
						clicarItemPorXPath(getVersaoProspectoNaoValida());
					}
				}
				if (verificaCampoHabilitadoPorId("file_prospecto")) {
					clicarSelecionarProspecto();
					FazerUpload fazerUpload = new FazerUpload(prospecto);
					fazerUpload.upload(false);
					escolherIdiomaProspecto(doctosAnexados);
					clicarIncluirProspecto();
				}
			} else {
				if (verificaCampoVisivelPorXPath(getVersaoProspectoValida())) {
					if (verificaCampoHabilitadoPorXPath(getVersaoProspectoValida())) {
						clicarItemPorXPath(getVersaoProspectoValida());
					}
				}
			}
		} else {
			if (verificaCampoVisivelPorXPath(getVersaoProspectoValida())) {
				if (verificaCampoHabilitadoPorXPath(getVersaoProspectoValida())) {
					clicarItemPorXPath(getVersaoProspectoValida());
				}
			}
		}
	}

	private String getVersaoProspectoNaoValida() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[4]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[3]/input";
	}

	private String getVersaoProspectoValida() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[3]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[1]/input";
	}

	private void clicarIncluirProspecto() {
		if (verificaCampoVisivelPorId("img_incluir_prospecto_habilitada")) {
			clicarItemPorId("img_incluir_prospecto_habilitada");
		}
	}

	private void escolherIdiomaProspecto(DoctosAnexadosFundos doctosAnexados) {
		if (verificaCampoHabilitadoPorId("idIdioma_prospecto")) {
			preencherCampoSelectById(doctosAnexados.getIdiomaProspecto()
					.getValue(), "idIdioma_prospecto");
		}
	}

	private void clicarSelecionarProspecto() {
		clicarItemPorId("file_prospecto");
	}

	private void preencherCartaIsencao(DoctosAnexadosFundos doctosAnexados) {
		final String cartaIsencao = doctosAnexados.getCartaIsencao();
		if (!cartaIsencao.equals("")) {
			if (!doctosAnexados.isVersaoAntCartaValida()) {
				if (verificaCampoVisivelPorXPath(getVersaoCartaNaoValida())) {
					if (verificaCampoHabilitadoPorXPath(getVersaoCartaNaoValida())) {
						clicarItemPorXPath(getVersaoCartaNaoValida());
					}
				}
				if (verificaCampoHabilitadoPorId("file_cartaIsencao")) {
					clicarSelecionarCartaIsencao();
					FazerUpload fazerUpload = new FazerUpload(cartaIsencao);
					fazerUpload.upload(false);
					escolherIdiomaCartaIsencao(doctosAnexados);
					clicarIncluirCarta();
				}
			} else {
				if (verificaCampoVisivelPorXPath(getVersaoCartaValida())) {
					if (verificaCampoHabilitadoPorXPath(getVersaoCartaValida())) {
						clicarItemPorXPath(getVersaoCartaValida());
					}
				}
			}
		} else {
			if (verificaCampoVisivelPorXPath(getVersaoCartaValida())) {
				if (verificaCampoHabilitadoPorXPath(getVersaoCartaValida())) {
					clicarItemPorXPath(getVersaoCartaValida());
				}
			}
		}
	}

	private String getVersaoCartaValida() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[1]/input";
	}

	private String getVersaoCartaNaoValida() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[2]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[3]/input";
	}

	private void clicarIncluirCarta() {
		if (verificaCampoHabilitadoPorId("img_incluir_cartaIsencao_habilitada")) {
			clicarItemPorId("img_incluir_cartaIsencao_habilitada");
		}
	}

	private void escolherIdiomaCartaIsencao(DoctosAnexadosFundos doctosAnexados) {
		preencherCampoSelectById(doctosAnexados.getIdiomaCartaIsencao()
				.getValue(), "idIdioma_cartaIsencao");
	}

	private void clicarSelecionarCartaIsencao() {
		clicarItemPorId("file_cartaIsencao");
	}

	private void preencherAta(DoctosAnexadosFundos doctosAnexados) {
		final String ataAssembleia = doctosAnexados.getAtaAssembleia();
		if (!ataAssembleia.equals("")) {
			if (!doctosAnexados.isVersaoAntAtaValida()) {
				if (verificaCampoVisivelPorXPath(getVersaoAtaNaoValida())) {
					if (verificaCampoHabilitadoPorXPath(getVersaoAtaNaoValida())) {
						clicarItemPorXPath(getVersaoAtaNaoValida());
					}
				}
				if (verificaCampoHabilitadoPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr/td[2]/input")) {
					clicarSelecionarArqAta();
					FazerUpload fazerUpload = new FazerUpload(ataAssembleia);
					fazerUpload.upload(false);
					escolherIdiomaAta(doctosAnexados);
					clicarIncluirAta();
				}
			} else {
				if (verificaCampoVisivelPorXPath(getVersaoAtaValida())) {
					if (verificaCampoHabilitadoPorXPath(getVersaoAtaValida())) {
						clicarItemPorXPath(getVersaoAtaValida());
					}
				}
			}
		} else {
			if (verificaCampoVisivelPorXPath(getVersaoAtaValida())) {
				if (verificaCampoHabilitadoPorXPath(getVersaoAtaValida())) {
					clicarItemPorXPath(getVersaoAtaValida());
				}
			}
		}
	}

	private String getVersaoAtaValida() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[1]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[1]/input";
	}

	private String getVersaoAtaNaoValida() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[1]/table[1]/tbody/tr/td[2]/table/tbody/tr/td[3]/input";
	}

	private void clicarIncluirAta() {
		if (verificaCampoHabilitadoPorId("img_incluir_ataAssembleia_habilitada")) {
			clicarItemPorId("img_incluir_ataAssembleia_habilitada");
		}
	}

	private void escolherIdiomaAta(DoctosAnexadosFundos doctosAnexados) {
		try {
			preencherCampoSelectByXPath(
					doctosAnexados.getIdiomaAtaAssembleia().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[1]/table[1]/tbody/tr/td[3]/select");
		} catch (Exception e) {
			preencherCampoSelectByXPath(
					doctosAnexados.getIdiomaAtaAssembleia().getValue(),
					"/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr/td[3]/select");
		}
	}

	private void clicarSelecionarArqAta() {
		try {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[1]/table[1]/tbody/tr/td[2]/input");
		} catch (Exception e) {
			clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/table[1]/tbody/tr[2]/td/div/div[1]/table[2]/tbody/tr/td[2]/input");
		}
	}

	private void clicarAnexardocumentos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form[2]/div/div[5]/div/table/tbody/tr[2]/td/input");
	}

}
