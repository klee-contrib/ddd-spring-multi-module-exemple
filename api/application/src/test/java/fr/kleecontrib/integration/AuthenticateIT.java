package fr.kleecontrib.integration;

import fr.kleecontrib.Application;
import fr.kleecontrib.domain.client.error.IncorrectPasswordError;
import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.domain.registration.service.RegistrationService;
import fr.kleecontrib.port.jpa.repository.RegistrationEntityRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@SpringBootTest(classes = Application.class)
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class AuthenticateIT {

	@Autowired
	private RegistrationService registrationService;
	@Autowired
	private RegistrationEntityRepository registrationEntityRepository;

	@Test
	void authenticate() {
		String phoneNumber = "0606060606";
		String mail = "test@gmail.com";
		String name = "name test";
		String firstName = "firstName test";
		Registration registration = Registration.registerClient(mail, name, firstName, null, Collections.emptyList(),
				phoneNumber);
		String password = "test";
		RegistrationId register = registrationService.register(registration, password);
		registrationEntityRepository.flush();
		Throwable throwable = Assertions.catchThrowable(() -> registrationService.authenticate(mail, password));
		Assertions.assertThat(throwable).isNull();
		Throwable throwable2 = Assertions.catchThrowable(() -> registrationService.authenticate(mail, "toto"));
		Assertions.assertThat(throwable2).isNotNull().isInstanceOf(IncorrectPasswordError.class);
	}
}
