package fr.kleecontrib.domain.client;

import java.util.List;

import fr.kleecontrib.domain.id.ArticleId;
import fr.kleecontrib.domain.id.CartId;

public record Cart(CartId id, List<ArticleId> articleIds) {

}
