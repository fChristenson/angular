package se.fidde.angular.service;

import java.util.Collection;

import se.fidde.angular.domain.Person;

public interface PersonService {

    Person getPerson(String id);

    Person addPerson(Person person);

    void removePerson(String id);

    Collection<Person> getAllPeople();

    void removeAll();

}
