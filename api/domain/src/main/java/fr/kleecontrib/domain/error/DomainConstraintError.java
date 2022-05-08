package fr.kleecontrib.domain.error;

public abstract class DomainConstraintError extends RuntimeException {

	private String code;

	public DomainConstraintError(String message, String code) {
		super(message);
		this.code = code;
	}
}
