package fr.kleecontrib.port.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.kleecontrib.port.jpa.entities.RegistrationEntity;

public interface RegistrationEntityRepository extends JpaRepository<RegistrationEntity, Long> {

	Optional<RegistrationEntity> findByEmail(String email);
}
