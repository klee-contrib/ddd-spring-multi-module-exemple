package fr.kleecontrib.usecase;

import java.util.Collections;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.domain.registration.error.MailAlreadyInUseError;
import fr.kleecontrib.domain.registration.service.RegistrationService;
import fr.kleecontrib.domain.registration.service.RegistrationStore;

@ExtendWith(MockitoExtension.class)
class RegisterClientTest {

	@Mock
	private RegistrationStore registrationStore;
	@Mock
	private RegistrationService registrationService;
	private RegisterClient registerClient;

	@BeforeEach
	void init() {
		this.registerClient = new RegisterClient(registrationStore, registrationService);
	}

	@Test
	void should_not_register_client_client_already_exist() {
		String mail = "mail";
		String name = "name";
		String firstName = "firstName";
		String phoneNumber = "060454874";
		String password = "password";
		Registration registration = Registration.registerClient(mail, name, firstName, null, Collections.emptyList(),
				phoneNumber);
		Mockito.when(registrationStore.getRegistrationByMail("mail")).thenReturn(Optional.of(registration));
		Throwable throwable = Assertions.catchThrowable(
				() -> registerClient.execute(mail, name, firstName, null, Collections.emptyList(), phoneNumber,
						password));
		Assertions.assertThat(throwable).isInstanceOf(MailAlreadyInUseError.class);
	}

	@Test
	void should_register_client() {
		String mail = "mail";
		String name = "name";
		String firstName = "firstName";
		String phoneNumber = "060454874";
		String password = "password";
		registerClient.execute(mail, name, firstName, null, Collections.emptyList(), phoneNumber, password);
		Mockito.verify(registrationService).register(Mockito.any(), Mockito.any());
	}
}
