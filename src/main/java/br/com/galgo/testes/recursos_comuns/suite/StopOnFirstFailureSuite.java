package br.com.galgo.testes.recursos_comuns.suite;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

import br.com.galgo.testes.recursos_comuns.suite.listener.FailFastListener;

public class StopOnFirstFailureSuite extends Suite {

	public StopOnFirstFailureSuite(Class<?> klass, Class<?>[] suiteClasses)
			throws InitializationError {
		super(klass, suiteClasses);
	}

	public StopOnFirstFailureSuite(Class<?> klass) throws InitializationError {
		super(klass, klass.getAnnotation(SuiteClasses.class).value());
	}

	@Override
	public void run(RunNotifier runNotifier) {
		runNotifier.addListener(new FailFastListener(runNotifier));
		super.run(runNotifier);
	}
}
