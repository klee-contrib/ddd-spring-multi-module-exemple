package fr.kleecontrib.domain.registration.service;

import java.util.Optional;

import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;

public interface RegistrationStore {

	Optional<Registration> get(RegistrationId regId);

	Optional<Registration> getRegistrationByMail(String email);
}
