package fr.kleecontrib.domain.event;

import java.time.LocalDateTime;

import fr.kleecontrib.domain.article.event.ArticleEvent;
import fr.kleecontrib.domain.id.ArticleId;

public class ArticleArrivageEvent implements ArticleEvent {

	private final ArticleId id;
	private final LocalDateTime dateArrivage;
	private final long nombreRecu;

	public ArticleArrivageEvent(ArticleId id, LocalDateTime dateArrivage, long nombreRecu) {
		super();
		this.id = id;
		this.dateArrivage = dateArrivage;
		this.nombreRecu = nombreRecu;
	}

	public LocalDateTime dateArrivage() {
		return dateArrivage;
	}

	public ArticleId id() {
		return id;
	}

	public long nombreRecu() {
		return nombreRecu;
	}
}
