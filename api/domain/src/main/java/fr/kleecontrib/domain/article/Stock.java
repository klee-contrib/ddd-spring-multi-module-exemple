package fr.kleecontrib.domain.article;

import fr.kleecontrib.domain.article.error.ArticleCapaciteMaximaleAtteinteError;
import fr.kleecontrib.domain.article.error.ArticleModificationStockError;

public record Stock(long nombreRestant) {

	public Stock {
		if (nombreRestant < 0) {
			throw new ArticleModificationStockError();
		}
	}

	public Stock() {
		this(0);
	}

	private static final long CAPACITE_MAX = 10;

	public static Stock vide() {
		return new Stock();
	}

	public Stock ajouter(long nombre) {
		if (nombre <= 0) {
			throw new ArticleModificationStockError();
		}
		if (nombre + nombreRestant > CAPACITE_MAX) {
			throw new ArticleCapaciteMaximaleAtteinteError();
		}
		return new Stock(nombreRestant + nombre);
	}

	public boolean isEmpty() {
		return this.nombreRestant == 0;
	}

}
