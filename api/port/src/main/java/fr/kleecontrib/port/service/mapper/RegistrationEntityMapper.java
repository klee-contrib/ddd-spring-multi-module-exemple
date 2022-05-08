package fr.kleecontrib.port.service.mapper;

import java.util.Collections;

import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.port.jpa.entities.RegistrationEntity;

public class RegistrationEntityMapper {

	private RegistrationEntityMapper() throws IllegalAccessException {
		throw new IllegalAccessException("Utility class");
	}

	public static RegistrationEntity domainToEntity(Registration registration, String password) {
		return new RegistrationEntity(registration.email(), registration.firstName(), registration.name(),
				registration.phoneNumber(), password);
	}

	public static Registration entityToDomain(RegistrationEntity registrationEntity) {
		return new Registration(new RegistrationId(registrationEntity.getId()), registrationEntity.getEmail(),
				registrationEntity.getFirstName(), registrationEntity.getName(), null, Collections.emptyList(),
				registrationEntity.getPhoneNumber());
	}
}
