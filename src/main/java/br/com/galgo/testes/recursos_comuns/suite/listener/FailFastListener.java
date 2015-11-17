package br.com.galgo.testes.recursos_comuns.suite.listener;

import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

import br.com.galgo.testes.recursos_comuns.exception.MensagemErro;

public class FailFastListener extends RunListener {

	private RunNotifier runNotifier;

	public FailFastListener(RunNotifier runNotifier) {
		super();
		this.runNotifier = runNotifier;
	}

	@Override
	public void testFailure(Failure failure) throws Exception {
		if (failure.getMessage().equals(MensagemErro.ERRO_LOGIN_INVALIDO)) {
			this.runNotifier.pleaseStop();
		}
	}
}
