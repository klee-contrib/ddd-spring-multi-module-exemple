package fr.kleecontrib.integration;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import fr.kleecontrib.Application;
import fr.kleecontrib.port.jpa.entities.RegistrationEntity;
import fr.kleecontrib.port.jpa.repository.RegistrationEntityRepository;

@SpringBootTest(classes = Application.class)
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
class RegistrationIT {

	@Autowired
	private RegistrationEntityRepository registrationEntityRepository;

	@Test
	void createRegistrationEntity() {
		final String email = "test@gmail.com";
		final String testName = "testName";
		final String testFirstName = "testFirstName";
		final String password = "password";
		final String phoneNumber = "0606060606";
		RegistrationEntity entity = new RegistrationEntity(email, testFirstName, testName, phoneNumber, password);
		registrationEntityRepository.saveAndFlush(entity);
		List<RegistrationEntity> result = registrationEntityRepository.findAll();
		Assertions.assertThat(result).isNotNull().isNotEmpty().hasSize(1);
		Assertions.assertThat(result.get(0)).isEqualTo(entity);
	}
}
