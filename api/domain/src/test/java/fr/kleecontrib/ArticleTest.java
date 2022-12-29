package fr.kleecontrib;

import java.math.BigDecimal;

import fr.kleecontrib.domain.article.error.ArticlePrixInvalidError;
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

	@Test
	void create_artcile_prix_negatif_impossible() {
		Throwable throwable = Assertions.catchThrowable(() -> createArticle(new BigDecimal(-10)));
		Assertions.assertThat(throwable).isNotNull().isInstanceOf(ArticlePrixInvalidError.class);
	}

	private Article createArticle() {
		return Article.creer("arcticleTest", BigDecimal.TEN);
	}
	private Article createArticle(BigDecimal prix) {
		return Article.creer("arcticleTest", prix);
	}
}
