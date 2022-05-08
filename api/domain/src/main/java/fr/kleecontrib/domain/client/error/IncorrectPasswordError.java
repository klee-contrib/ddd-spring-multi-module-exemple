package fr.kleecontrib.domain.client.error;

import fr.kleecontrib.domain.error.DomainConstraintError;

public class IncorrectPasswordError extends DomainConstraintError {

	private static final String MESSAGE = "Incorrect password";
	private static final String CODE = "client_incorrect_password";

	public IncorrectPasswordError() {
		super(MESSAGE, CODE);
	}
}
