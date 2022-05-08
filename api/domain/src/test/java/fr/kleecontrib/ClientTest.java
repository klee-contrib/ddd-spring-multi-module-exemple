package fr.kleecontrib;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import fr.kleecontrib.domain.id.ClientId;
import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Address;
import fr.kleecontrib.domain.registration.Registration;

class ClientTest {

	@Test
	void create_registration() {
		Registration newRegistration = createRegistration();
		Assertions.assertThat(newRegistration).isNotNull();
		Assertions.assertThat(newRegistration.billAddress()).isNotNull();
		Assertions.assertThat(newRegistration.firstName()).isNotNull();
		Assertions.assertThat(newRegistration.name()).isNotNull();
		Assertions.assertThat(newRegistration.email()).isNotNull();
		Assertions.assertThat(newRegistration.phoneNumber()).isNotNull();
		Assertions.assertThat(newRegistration.deliveryAddress()).isNotNull().isNotEmpty().hasSize(1);
	}

	private Registration createRegistration() {
		String mail = "test@gmail.com";
		String name = "testName";
		String firstName = "testFirstName";
		Address billAddess = Address.hydrate("5", "rue de la pompe", "Paris", 75001, "France", true);
		List<Address> deliveryAdresses = List.of(billAddess);
		String phoneNumber = "0606060606";
		return Registration.registerClient(mail, name, firstName, billAddess, deliveryAdresses, phoneNumber);
	}

	@Test
	void record_RegistrationId_test() {
		RegistrationId registrationId1 = new RegistrationId(1L);
		RegistrationId registrationId2 = new RegistrationId(1L);
		Assertions.assertThat(registrationId1.id()).isEqualTo(1L);
		Assertions.assertThat(registrationId1).isEqualTo(registrationId2);
	}

	@Test
	void record_clientId_test() {
		ClientId clientId1 = new ClientId(1L);
		ClientId clientId2 = new ClientId(1L);
		Assertions.assertThat(clientId1.id()).isEqualTo(1L);
		Assertions.assertThat(clientId1).isEqualTo(clientId2);
	}
}
