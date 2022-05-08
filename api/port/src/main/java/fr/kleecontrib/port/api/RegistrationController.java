package fr.kleecontrib.port.api;

import java.util.Collections;

import org.springframework.web.bind.annotation.*;

import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.port.api.model.LogInForm;
import fr.kleecontrib.port.api.model.RegisterForm;
import fr.kleecontrib.port.api.model.mapper.AddressModelMapper;
import fr.kleecontrib.usecase.GetCLient;
import fr.kleecontrib.usecase.LogInClient;
import fr.kleecontrib.usecase.RegisterClient;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegistrationController {

	private final RegisterClient registerClient;
	private final LogInClient logInClient;
	private final GetCLient getClient;

	@PostMapping("/auth")
	public void logInClient(@RequestBody LogInForm logInForm) {
		logInClient.execute(logInForm.getEmail(), logInForm.getPassword());
	}

	@PostMapping
	public Long registerClient(@RequestBody RegisterForm registerForm) {
		return registerClient.execute(registerForm.getEmail(), registerForm.getName(), registerForm.getFirstName(),
				AddressModelMapper.modelToDomain(registerForm.getBillAddress()),
				registerForm.getDeliveryAddress() == null ?
				Collections.emptyList() :
				registerForm.getDeliveryAddress().stream().map(AddressModelMapper::modelToDomain).toList(),
				registerForm.getPhoneNumber(), registerForm.getPassword()).id();
	}

	@GetMapping("/{id}")
	public Registration registerClient(@PathVariable("id") Long id) {
		return getClient.execute(new RegistrationId(id));
	}
}
