package fr.kleecontrib.port.api.model.mapper;

import fr.kleecontrib.domain.registration.Address;
import fr.kleecontrib.port.api.model.AddressModel;

public class AddressModelMapper {

	private AddressModelMapper() {
	}

	public static Address modelToDomain(AddressModel model) {
		if (model == null) {
			return null;
		}
		return Address.hydrate(model.getNumber(), model.getRoad(), model.getCity(), model.getZipCode(),
				model.getCountry(), model.isCurrent());
	}
}
