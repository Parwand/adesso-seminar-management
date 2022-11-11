package de.adesso.adessoseminarmanagement.infrastructure.db.person;

import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Long> {
}
