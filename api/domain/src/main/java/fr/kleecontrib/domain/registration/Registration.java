package fr.kleecontrib.domain.registration;

import java.util.List;
import java.util.Objects;

import fr.kleecontrib.domain.id.RegistrationId;

public record Registration(RegistrationId registrationId, String email, String firstName, String name,
						   Address billAddress, List<Address> deliveryAddress, String phoneNumber) {

	public static Registration registerClient(String email, String name, String firstName, Address billAddress,
			List<Address> deliveryAddress, String phoneNumber) {
		return new Registration(null, email, firstName, name, billAddress, deliveryAddress, phoneNumber);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Registration that = (Registration) o;
		return Objects.equals(registrationId, that.registrationId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(registrationId);
	}
}
