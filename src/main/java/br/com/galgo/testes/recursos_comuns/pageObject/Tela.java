package br.com.galgo.testes.recursos_comuns.pageObject;

import org.openqa.selenium.WebElement;

public interface Tela {

	public void removerCampoReadOnlyPorId(String idCampo);

	public void removerCampoReadOnlyPorName(String nameCampo);

	public boolean verificaCampoVisivelPorId(String idCampo);

	public boolean verificaCampoVisivelPorName(String nameCampo);

	public boolean verificaCampoSelecionavelPorId(String idCampo);

	public boolean verificaCampoSelecionalPorName(String nameCampo);

	public boolean verificaCampoHabilitadoPorId(String idCampo);

	public boolean verificaCampoHabilitadoPorName(String nameCampo);

	public void limparCampoPorId(String idCampo);

	public void limparCampoPorName(String nameCampo);

	public void clicarItemPorId(String idCampo);

	public void clicarItemPorClassName(String nameCampo);

	public void esperarSegundos(int segundos);

	public void preencheCampoPorId(String idCampo, String dado);

	public void preencheCampoPorName(String nameCampo, String dado);

	public WebElement encontrarCampoPorId(String idCampo);

	public WebElement encontrarCampoPorClassName(String nameCampo);

	public void preencherCampoSelect(String valorCampo);

	public void clicarBotaoConfirmar();

	public void clicarBotaoVoltar();

}
