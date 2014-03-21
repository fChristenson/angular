package se.fidde.angular.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import se.fidde.angular.domain.Person;
import se.fidde.angular.repository.PersonRepository;

public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    private Logger log = Logger.getLogger(PersonServiceImpl.class);

    public Person addPerson(Person person) {
        log.debug(String.format("adding person: %s", person));
        return personRepository.save(person);
    }

    @Override
    public void removePerson(String id) {
        personRepository.delete(id);
    }

    @Override
    public Collection<Person> getAllPeople() {
        return personRepository.findAll();
    }

    @Override
    public void removeAll() {
        personRepository.deleteAll();
    }

    @Override
    public Person getPerson(String id) {
        return personRepository.findOne(id);
    }

}
