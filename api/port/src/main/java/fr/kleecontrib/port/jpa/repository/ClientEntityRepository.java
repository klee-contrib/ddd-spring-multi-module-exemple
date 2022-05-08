package fr.kleecontrib.port.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.kleecontrib.port.jpa.entities.ClientEntity;

public interface ClientEntityRepository extends JpaRepository<ClientEntity, Long> {

}
