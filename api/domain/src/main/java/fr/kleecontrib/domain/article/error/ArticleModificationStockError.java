package fr.kleecontrib.domain.article.error;

import fr.kleecontrib.domain.error.DomainConstraintError;

public class ArticleModificationStockError extends DomainConstraintError {

	public ArticleModificationStockError() {
		super("message", "code");
	}
}
