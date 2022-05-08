package fr.kleecontrib.domain.article.error;

import fr.kleecontrib.domain.error.DomainConstraintError;

public class ArticleCapaciteMaximaleAtteinteError extends DomainConstraintError {

	public ArticleCapaciteMaximaleAtteinteError() {
		super("message", "code");
	}
}
