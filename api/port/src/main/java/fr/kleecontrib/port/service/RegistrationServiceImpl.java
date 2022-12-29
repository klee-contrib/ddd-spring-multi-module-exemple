package fr.kleecontrib.port.service;

import fr.kleecontrib.domain.client.error.IncorrectPasswordError;
import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.domain.registration.service.RegistrationService;
import fr.kleecontrib.port.jpa.entities.RegistrationEntity;
import fr.kleecontrib.port.jpa.repository.RegistrationEntityRepository;
import fr.kleecontrib.port.service.mapper.RegistrationEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl implements RegistrationService {

	private final RegistrationEntityRepository registrationEntityRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void authenticate(String mail, String password) {
		Optional<RegistrationEntity> registrationEntityOpt = registrationEntityRepository.findByEmail(mail);
		if (registrationEntityOpt.isEmpty() || !bCryptPasswordEncoder.matches(password, registrationEntityOpt.get().getPassword())) {
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
		String encodePassword = bCryptPasswordEncoder.encode(password);
		RegistrationEntity registrationEntity = RegistrationEntityMapper.domainToEntity(registration, encodePassword);
		registrationEntity.setPassword(encodePassword);
		return new RegistrationId(registrationEntityRepository.save(registrationEntity).getId());
	}
}
