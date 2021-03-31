package com.mocking.test_doubles.dummy;

public class DummyEmailService implements EmailService {

	@Override
	public boolean sendEmail(String str) {
		throw new AssertionError("The method not implemented");
	}

}
