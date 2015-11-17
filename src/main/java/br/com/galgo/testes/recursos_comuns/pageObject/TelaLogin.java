package br.com.galgo.testes.recursos_comuns.pageObject;

import org.junit.Assert;

import br.com.galgo.testes.recursos_comuns.enumerador.config.Ambiente;
import br.com.galgo.testes.recursos_comuns.exception.MensagemErro;
import br.com.galgo.testes.recursos_comuns.file.entidades.Usuario;

public class TelaLogin extends TelaPrincipal {

	public TelaHome loginAs(Usuario usuario) {
		String login = usuario.getLogin();
		String senha = usuario.getSenha();
		preencherCampoLogin(login);
		preencherCampoSenha(senha);

		if (!submeterFormulario(usuario)) {
			Assert.fail(MensagemErro.ERRO_LOGIN_INVALIDO + "[usuario="
					+ usuario.getLogin() + ", senha=" + senha + "]");
		}
		return new TelaHome(usuario);
	}

	private boolean submeterFormulario(Usuario usuario) {
		clicarItemPorId(getCampoSenha());

		Ambiente ambiente = usuario.getAmbiente();

		clicarItemPorClassName(getClassNameTeclaEnter(ambiente));
		TelaTrocaSenha telaTrocaSenha = new TelaTrocaSenha();
		if (telaTrocaSenha.estaNaTeladeTrocaDeSenha()) {
			return telaTrocaSenha.trocarSenha(usuario);
		}
		esperarSegundos(2);
		if (verificaCampoVisivelPorXPath(getXPathUsuarioBloqueado())) {
			return false;
		}
		return true;
	}

	private void preencherCampoLogin(String login) {
		preencheCampoPorId("nmUsuario", login);
	}

	private void preencherCampoSenha(String senha) {
		String getCampoSenha = getCampoSenha();

		removerCampoReadOnlyPorId(getCampoSenha);
		preencheCampoPorId(getCampoSenha, senha);
	}

	private String getCampoSenha() {
		return "dsSenha";
	}

	private String getClassNameTeclaEnter(Ambiente ambiente) {
		if (Ambiente.HOMOLOGACAO == ambiente) {
			return "submit_ativo";
		} else {
			return "enter";
		}
	}

	private String getXPathUsuarioBloqueado() {
		return "/html/body/div[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td[2]/div/table/tbody/tr[1]/td/table/tbody/tr/td[1]/table/tbody/tr[1]/td/div/form/table/tbody/tr[1]/td/div/div/table/tbody/tr[1]/td[2]/ul/li";
	}

}
