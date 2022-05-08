package fr.kleecontrib.usecase;

import java.util.Optional;

import org.springframework.stereotype.Component;

import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.domain.registration.error.RegistrationNotFoundError;
import fr.kleecontrib.domain.registration.service.RegistrationService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class GetCLient {

	private final RegistrationService registrationService;

	public Registration execute(RegistrationId registrationId) {
		final Optional<Registration> clientOpt = registrationService.getClient(registrationId);
		if (clientOpt.isEmpty()) {
			throw new RegistrationNotFoundError();
		}
		return clientOpt.get();
	}
}
