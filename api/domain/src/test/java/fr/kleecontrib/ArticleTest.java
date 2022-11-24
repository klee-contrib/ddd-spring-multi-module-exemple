package fr.kleecontrib;

import java.math.BigDecimal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.kleecontrib.domain.article.Article;
import fr.kleecontrib.domain.article.Stock;

class ArticleTest {

	@Test
	void create_artcile() {
		Article newArticle = createArticle();
		Stock stock = new Stock();
		stock.nombreRestant();
		Assertions.assertThat(newArticle).isNotNull();
		Assertions.assertThat(newArticle.nom()).isNotNull();
		Assertions.assertThat(newArticle.prix()).isNotNull();
		Assertions.assertThat(newArticle.isAuCatalogue()).isFalse();
	}

	private Article createArticle() {
		return Article.creer("arcticleTest", BigDecimal.TEN);
	}
}
