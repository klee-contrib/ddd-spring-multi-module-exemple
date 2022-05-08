package fr.kleecontrib.domain.article.event;

public interface ArticleEventPublisher {

	void publish(ArticleEvent event);
}
