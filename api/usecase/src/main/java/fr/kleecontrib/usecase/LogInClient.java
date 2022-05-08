package fr.kleecontrib.usecase;

import org.springframework.stereotype.Component;

import fr.kleecontrib.domain.registration.service.RegistrationService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class LogInClient {

	private RegistrationService registrationService;

	public void execute(String mail, String password) {
		registrationService.authenticate(mail, password);
	}
}
