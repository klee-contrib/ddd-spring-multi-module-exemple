package fr.kleecontrib.port.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import fr.kleecontrib.domain.client.error.IncorrectPasswordError;
import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.domain.registration.service.RegistrationService;
import fr.kleecontrib.port.jpa.entities.RegistrationEntity;
import fr.kleecontrib.port.jpa.repository.RegistrationEntityRepository;
import fr.kleecontrib.port.service.mapper.RegistrationEntityMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

	private final RegistrationEntityRepository registrationEntityRepository;

	@Override
	public void authenticate(String mail, String password) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		Optional<RegistrationEntity> registrationEntityOpt = registrationEntityRepository.findByEmail(mail);
		if (registrationEntityOpt.isEmpty() || !bcrypt.matches(password, registrationEntityOpt.get().getPassword())) {
			throw new IncorrectPasswordError();
		}
	}

	@Override
	public Optional<Registration> getClient(RegistrationId registrationId) {
		final Optional<RegistrationEntity> registrationEntityOpt = registrationEntityRepository.findById(
				registrationId.id());
		return registrationEntityOpt.map(RegistrationEntityMapper::entityToDomain);
	}

	@Override
	public RegistrationId register(Registration registration, String password) {
		BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
		String encodePassword = bcrypt.encode(password);
		RegistrationEntity registrationEntity = RegistrationEntityMapper.domainToEntity(registration, encodePassword);
		registrationEntity.setPassword(encodePassword);
		return new RegistrationId(registrationEntityRepository.save(registrationEntity).getId());
	}
}
