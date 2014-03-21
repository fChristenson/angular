package se.fidde.angular.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import se.fidde.angular.domain.Person;

public interface PersonRepository extends MongoRepository<Person, String> {

    List<Person> findByName(String name);

}
