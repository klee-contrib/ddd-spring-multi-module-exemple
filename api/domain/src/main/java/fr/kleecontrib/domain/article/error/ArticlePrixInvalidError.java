package fr.kleecontrib.domain.article.error;

import fr.kleecontrib.domain.error.DomainConstraintError;

public class ArticlePrixInvalidError extends DomainConstraintError {

	public ArticlePrixInvalidError() {
		super("message", "code");
	}
}
