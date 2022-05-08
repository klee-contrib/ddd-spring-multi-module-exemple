package fr.kleecontrib.domain.article;

import fr.kleecontrib.domain.article.error.ArticleCapaciteMaximaleAtteinteError;
import fr.kleecontrib.domain.article.error.ArticleModificationStockError;

public record Stock(long nombreRestant) {

	private static final long CAPACITE_MAX = 10;

	public static Stock hydrate(long nbRestant) {
		return new Stock(nbRestant);
	}

	public static Stock vide() {
		return new Stock(0);
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

	public long nombreRestant() {
		return nombreRestant;
	}
}
