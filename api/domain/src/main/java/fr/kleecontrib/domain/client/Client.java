package fr.kleecontrib.domain.client;

import fr.kleecontrib.domain.id.ClientId;

public record Client(ClientId id, Cart cart) {

}
