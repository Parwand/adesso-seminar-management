package de.adesso.adessoseminarmanagement.infrastructure.db.person;

import de.adesso.adessoseminarmanagement.applicationservice.repository.person.PersonRepository;
import de.adesso.adessoseminarmanagement.domain.model.person.Person;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {
    private final PersonDao personDao;

    public PersonRepositoryImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public Person savePerson(Person person) {
        return personDao.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        personDao.deleteById(id);
    }
}
