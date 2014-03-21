package se.fidde.angular.domain;

import org.apache.log4j.Logger;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Person {

    @Transient
    private Logger log = Logger.getLogger(Person.class);
    private String name;
    private String email;

    @Id
    private String id;

    public Person() {
    }

    public Person(String name, String email) {
        log.debug(String.format("creating person: %s,  email: %s", name, email));
        this.name = name;
        this.email = email;

    }

    public String getName() {
        log.debug(String.format("getting name: %s", name));
        return name;
    }

    public String getEmail() {
        log.debug(String.format("getting email: %s", email));
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", id, name, email);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
