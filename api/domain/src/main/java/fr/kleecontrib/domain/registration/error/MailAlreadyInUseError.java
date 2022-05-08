package fr.kleecontrib.domain.registration.error;

import fr.kleecontrib.domain.error.DomainConstraintError;

public class MailAlreadyInUseError extends DomainConstraintError {

	private static final String MESSAGE = "Mail already in use";
	private static final String CODE = "register_mail_already_in_use";

	public MailAlreadyInUseError() {
		super(MESSAGE, CODE);
	}
}
