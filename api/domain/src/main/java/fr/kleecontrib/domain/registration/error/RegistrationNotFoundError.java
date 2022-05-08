package fr.kleecontrib.domain.registration.error;

import fr.kleecontrib.domain.error.DomainConstraintError;

public class RegistrationNotFoundError extends DomainConstraintError {

	private static final String MESSAGE = "Registration not found";
	private static final String CODE = "registration_not_found";

	public RegistrationNotFoundError() {
		super(MESSAGE, CODE);
	}
}


