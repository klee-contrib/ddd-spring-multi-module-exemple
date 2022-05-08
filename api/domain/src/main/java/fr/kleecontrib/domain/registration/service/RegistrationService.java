package fr.kleecontrib.domain.registration.service;

import java.util.Optional;

import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;

public interface RegistrationService {

	void authenticate(String mail, String password);

	Optional<Registration> getClient(RegistrationId registrationId);

	RegistrationId register(Registration registration, String password);
}
