package de.adesso.adessoseminarmanagement.infrastructure.db.person;

import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonDao extends JpaRepository<Person, Long> {
    Optional<Person> findPersonById(Long id);
}
