package se.fidde.angular.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import se.fidde.angular.config.ApplicationConfig;
import se.fidde.angular.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class PersonRepoTest {

    @Autowired
    PersonRepository personRepository;

    @Test
    public void test() {
        assertNotNull(personRepository);
    }

}
