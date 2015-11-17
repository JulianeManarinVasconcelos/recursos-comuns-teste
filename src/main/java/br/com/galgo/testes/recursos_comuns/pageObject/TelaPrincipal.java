package br.com.galgo.testes.recursos_comuns.pageObject;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.galgo.testes.recursos_comuns.config.ConfiguracaoSistema;
import br.com.galgo.testes.recursos_comuns.enumerador.config.TipoCampo;
import br.com.galgo.testes.recursos_comuns.exception.ErroAplicacao;
import br.com.galgo.testes.recursos_comuns.exception.ErroMenuIndisponivel;

public class TelaPrincipal implements Tela {

	public static WebDriver driver;

	public static void reiniciarBrowser(String url) {
		fecharBrowser();
		abrirBrowser(url);
	}

	public static void abrirBrowser(String url) {
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.MINUTES);
		driver.manage().timeouts().setScriptTimeout(3, TimeUnit.MINUTES);
		limparCookies();
		abrirUrl(url);
	}

	public void logout() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[1]/td[2]/table/tbody/tr[1]/td[3]/a[1]");
	}

	public boolean continuarTentando(int tentativas, String msgError) {
		boolean continua = false;
		tentativas++;
		continua = verificaTextoNaTela(msgError)
				&& tentativas >= ConfiguracaoSistema.MAX_RETENTATIVA;
		return continua;
	}

	public void clicarSelecionarTodos() {
		clicarItemPorXPath("/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr/td/table/tbody/tr/td/div/form/table[6]/tbody/tr[2]/td/input[2]");
	}

	public void clicarBotaoConfirmar() {
		clicarItemPorXPath(getXPathBotaoConfirmar());
	}

	private String getXPathBotaoConfirmar() {
		return "//input[@value='Confirmar']";
	}

	private static void limparCookies() {
		driver.manage().deleteAllCookies();
	}

	public void verificarItemEncontrado() {
		boolean estaNaTela = verificaTextoNaTela("1 item encontrado.")
				|| verificaTextoNaTela("itens encontrados");
		Assert.assertTrue("Busca não trouxe nenhum resultado.", estaNaTela);
	}

	public String getValorCampoPorXPath(String xPath) {
		return encontrarCampoPorXPath(xPath).getAttribute("value");
	}

	public boolean verificaTextoNaTela(String texto) {
		boolean estaNaTela = false;
		try {
			estaNaTela = driver.getPageSource().contains(texto);
		} catch (Exception e) {
			estaNaTela = false;
		}
		return estaNaTela;
	}

	public boolean verificaTextoNoCampoPorXPath(String texto, String XPath) {
		String textoNaTela = encontrarCampoPorXPath(XPath).getText();
		if (!textoNaTela.equals(texto)) {
			return false;
		}
		return true;
	}

	public void garanteTextoNaTela(String texto) {
		String msgErro = "Campo com texto não encontrado [texto procurado="
				+ texto + "].";
		try {
			Assert.assertTrue(msgErro, verificaTextoNaTela(texto));
		} catch (Exception e) {
			Assert.fail(msgErro);
		}
	}

	public boolean temErroNaTela() {
		try {
			return verificaTextoNaTela(getMsgErro())
					|| verificaTextoNaTela("encontra-se com status Suspenso.");
		} catch (Exception e) {
			return false;
		}
	}

	public void garanteTextoNoCampoPorXPath(String texto, String XPath) {
		String msgErro = "Campo com texto não encontrado [texto procurado="
				+ texto + "].";
		try {
			Assert.assertTrue(msgErro,
					verificaTextoNoCampoPorXPath(texto, XPath));
		} catch (Exception e) {
			Assert.fail(msgErro);
		}
	}

	public void preencherCampoSelectByXPath(String valorCampo, String XPath) {
		esperarSegundos(1);
		Select dropdown = new Select(driver.findElement(By.xpath(XPath)));
		dropdown.selectByValue(valorCampo);
	}

	public void preencherCampoSelect(String valorCampo, String nameSelect) {
		esperarSegundos(1);
		Select dropdown = new Select(driver.findElement(By.name(nameSelect)));
		dropdown.selectByValue(valorCampo);
	}

	public void preencherCampoSelectById(String valorCampo, String id) {
		esperarSegundos(1);
		Select dropdown = new Select(driver.findElement(By.id(id)));
		dropdown.selectByValue(valorCampo);
	}

	public void preencherCampoSelect(String valorCampo) {
		Select dropdown = new Select(driver.findElement(By
				.tagName(TipoCampo.SELECT.getDescricao())));
		dropdown.selectByValue(valorCampo);
	}

	public static void tirarScreamShot(String caminho) {
		try {
			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(screenshot, new File(caminho));
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	public void removerCampoReadOnlyPorXPath(String XPath) {
		removerCampoReadOnly(encontrarCampoPorXPath(XPath));
	}

	public void removerCampoReadOnlyPorId(String idCampo) {
		removerCampoReadOnly(encontrarCampoPorId(idCampo));
	}

	public void removerCampoReadOnlyPorName(String nameCampo) {
		removerCampoReadOnly(encontrarCampoPorClassName(nameCampo));
	}

	public boolean verificaCampoVisivelPorXPath(String XPath) {
		try {
			return encontrarCampoPorXPath(XPath).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean verificaCampoVisivelPorId(String idCampo) {
		try {
			return encontrarCampoPorId(idCampo).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean verificaCampoVisivelPorClass(String classCampo) {
		try {
			return encontrarCampoPorClassName(classCampo).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	public void verificaCampoVisivelPorLink(String link, String nomeUsuario)
			throws ErroAplicacao {
		try {
			encontrarCampoPorLink(link);
		} catch (Exception e) {
			throw new ErroMenuIndisponivel(link, nomeUsuario);
		}
	}

	public boolean verificaCampoVisivelPorName(String nameCampo) {
		try {
			return encontrarCampoPorClassName(nameCampo).isDisplayed();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean verificaCampoSelecionavelPorId(String idCampo) {
		try {
			return encontrarCampoPorId(idCampo).isSelected();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean verificaCampoSelecionalPorName(String nameCampo) {
		try {
			return encontrarCampoPorClassName(nameCampo).isSelected();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean verificaCampoHabilitadoPorId(String idCampo) {
		try {
			return encontrarCampoPorId(idCampo).isEnabled();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean verificaCampoHabilitadoPorName(String nameCampo) {
		try {
			return encontrarCampoPorClassName(nameCampo).isEnabled();
		} catch (Exception exception) {
			return false;
		}
	}

	public boolean verificaCampoHabilitadoPorXPath(String xpath) {
		try {
			return encontrarCampoPorXPath(xpath).isEnabled();
		} catch (Exception exception) {
			return false;
		}
	}

	public void limparCampoPorId(String idCampo) {
		encontrarCampo(By.id(idCampo)).clear();
	}

	public void limparCampoPorName(String nameCampo) {
		encontrarCampoPorClassName(nameCampo).clear();
	}

	public void clicarItemPorLink(String link) {
		encontrarCampoPorLink(link).click();
	}

	public void clicarItemPorXPath(String XPath) {
		esperarElementoPorXpath(XPath);
		encontrarCampoPorXPath(XPath).click();
	}

	public void clicarItemPorCss(String selector) {
		encontrarCampoPorCss(selector).click();
	}

	public void clicarItemPorName(String name) {
		encontrarCampoPorName(name).click();
	}

	public void clicarItemPorId(String idCampo) {
		esperarElementoPorId(idCampo);
		encontrarCampo(By.id(idCampo)).click();
	}

	public void abrirSubMenu(String linkMenu, String linkSubMenu) {
		try {
			clicarItemPorLink(linkSubMenu);
		} catch (Exception e) {
			clicarMenu(linkMenu);
			esperarSegundos(5);
			clicarItemPorLink(linkSubMenu);
		}
	}

	public void clicarMenu(String linkMenu) {
		clicarItemPorLink(linkMenu);
	}

	public void clicarItemPorClassName(String classNameCampo) {
		encontrarCampoPorClassName(classNameCampo).click();
	}

	public void clicarItemPorDom(String dom) {
		encontrarCampoPorDom(dom).click();
	}

	public void esperarSegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (final InterruptedException e) {
			return;
		}
	}

	public static void abrirUrl(String url) {
		driver.get(url);
	}

	public void preencheCampoPorId(String idCampo, String dado) {
		WebElement campo = encontrarCampoPorId(idCampo);
		campo.clear();
		campo.sendKeys(dado);
	}

	public void preencheCampoPorName(String nameCampo, String dado) {
		WebElement campo = encontrarCampoPorName(nameCampo);
		campo.clear();
		campo.sendKeys(dado);
	}

	public void preencheCampoXPath(String XPath, String dado) {
		WebElement campo = encontrarCampoPorXPath(XPath);
		campo.clear();
		campo.sendKeys(dado);
	}

	public WebElement encontrarCampoPorId(String idCampo) {
		return encontrarCampo(By.id(idCampo));
	}

	public WebElement encontrarCampoPorTag(String tag) {
		return encontrarCampo(By.tagName(tag));
	}

	public WebElement encontrarCampoPorClassName(String classNameCampo) {
		return encontrarCampo(By.className(classNameCampo));
	}

	public WebElement encontrarCampoPorLink(String link) {
		return encontrarCampo(By.linkText(link));
	}

	public WebElement encontrarCampoPorXPath(String XPath) {
		esperarElementoPorXpath(XPath);

		return encontrarCampo(By.xpath(XPath));
	}

	private void esperarElementoPorId(String id) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}

	private void esperarElementoPorXpath(String XPath) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPath)));
	}

	public WebElement encontrarCampoPorCss(String selector) {
		return encontrarCampo(By.cssSelector(selector));
	}

	public WebElement encontrarCampoPorName(String name) {
		return encontrarCampo(By.name(name));
	}

	private WebElement encontrarCampo(By campo) {
		return driver.findElement(campo);
	}

	private void removerCampoReadOnly(WebElement campo) {
		JavascriptExecutor js = null;
		if (driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
		}
		js.executeScript("arguments[0].removeAttribute('readonly')", campo);
	}

	private WebElement encontrarCampoPorDom(String dom) {
		JavascriptExecutor js = null;
		if (driver instanceof JavascriptExecutor) {
			js = (JavascriptExecutor) driver;
		}
		return (WebElement) js.executeScript("return " + dom);
	}

	public String getTextoPorXPath(String XPath) {
		return encontrarCampoPorXPath(XPath).getText();
	}

	public static void fecharBrowser() {
		((FirefoxDriver) driver).quit();
	}

	public String getMsgErro() {
		return "Ocorreu um erro no sistema. Por favor, entre em contato com o Suporte ao Usuário e informe a ocorrêcia código 26.";
	}

	public void clicarBotaoVoltar() {
		clicarItemPorId("voltar");
	}

	public void fecharAlertaBrowser() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

}
