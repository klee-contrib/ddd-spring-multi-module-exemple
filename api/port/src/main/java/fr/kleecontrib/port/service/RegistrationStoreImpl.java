package fr.kleecontrib.port.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.kleecontrib.domain.id.RegistrationId;
import fr.kleecontrib.domain.registration.Registration;
import fr.kleecontrib.domain.registration.service.RegistrationStore;
import fr.kleecontrib.port.jpa.repository.RegistrationEntityRepository;
import fr.kleecontrib.port.service.mapper.RegistrationEntityMapper;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegistrationStoreImpl implements RegistrationStore {

	private final RegistrationEntityRepository registrationEntityRepository;

	@Override
	public Optional<Registration> get(RegistrationId regId) {
		return registrationEntityRepository.findById(regId.id()).map(RegistrationEntityMapper::entityToDomain);
	}

	@Override
	public Optional<Registration> getRegistrationByMail(String email) {
		return registrationEntityRepository.findByEmail(email).map(RegistrationEntityMapper::entityToDomain);
	}
}
