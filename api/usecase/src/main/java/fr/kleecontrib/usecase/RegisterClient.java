package fr.kleecontrib.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Address;
import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.domain.registration.error.MailAlreadyInUseError;
import fr.kleecontrib.domain.registration.service.RegistrationService;
import fr.kleecontrib.domain.registration.service.RegistrationStore;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegisterClient {

	private final RegistrationStore registrationStore;
	private final RegistrationService registrationService;

	public RegistrationId execute(String email, String name, String firstName, Address billAddress,
			List<Address> deliveryAddress, String phoneNumber, String password) {
		/// Uniq mail by registration
		if (registrationStore.getRegistrationByMail(email).isPresent()) {
			throw new MailAlreadyInUseError();
		}
		/// Register client
		Registration registration = Registration.registerClient(email, name, firstName, billAddress, deliveryAddress,
				phoneNumber);
		return registrationService.register(registration, password);
	}
}
