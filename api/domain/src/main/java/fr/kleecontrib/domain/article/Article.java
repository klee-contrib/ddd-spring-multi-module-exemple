package fr.kleecontrib.domain.article;

import java.math.BigDecimal;

import fr.kleecontrib.domain.article.error.ArticlePrixInvalidError;
import fr.kleecontrib.domain.id.ArticleId;

public class Article {

	private final ArticleId id;
	private final String nom;
	private final BigDecimal prix;
	private Stock stock;
	private boolean isAuCatalogue;

	private Article(ArticleId id, String nom, BigDecimal prix, Stock stock, boolean isAuCatalogue) {
		this.id = id;
		this.nom = nom;
		this.prix = prix;
		this.stock = stock;
		this.isAuCatalogue = isAuCatalogue;
	}

	public static Article creer(String nom, BigDecimal prix) {
		if (prix.doubleValue() <= 0) {
			throw new ArticlePrixInvalidError();
		}
		return new Article(null, nom, prix, Stock.vide(), false);
	}

	public static Article hydrate(long id, String nom, BigDecimal prix, long nbRestant, boolean isAuCatalogue) {
		return new Article(new ArticleId(id), nom, prix, Stock.hydrate(nbRestant), isAuCatalogue);
	}

	public Article ajouterAuCatalogue() {
		if (!this.stock.isEmpty()) {
			this.isAuCatalogue = true;
		}
		return this;
	}

	public Article arrivage(long nombre) {
		stock = stock.ajouter(nombre);
		return this;
	}

	public ArticleId id() {
		return id;
	}

	public boolean isAuCatalogue() {
		return isAuCatalogue;
	}

	public String nom() {
		return nom;
	}

	public BigDecimal prix() {
		return prix;
	}
}
