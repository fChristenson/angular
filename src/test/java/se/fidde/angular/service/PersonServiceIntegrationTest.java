package se.fidde.angular.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import se.fidde.angular.config.ApplicationConfig;
import se.fidde.angular.domain.Person;
import se.fidde.angular.util.MockTools;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class PersonServiceIntegrationTest {

    @Autowired
    private PersonService personService;
    private Person person;
    private Person person2;

    @Before
    public void setUp() throws Exception {
        person = MockTools.getMockPerson();
        person2 = MockTools.getMockPerson();
    }

    @After
    public void tearDown() throws Exception {
        person = null;
        person2 = null;
        personService = null;
    }

    @Test
    public void testGetPersonService() {
        assertNotNull("can get service", personService);
    }

    @Test
    public void testAddPerson() throws Exception {
        Person addPerson = personService.addPerson(person);
        Person addPerson2 = personService.addPerson(person2);

        assertNotEquals("id is unique", addPerson, addPerson2);
    }

    @Test
    public void testGetPerson() throws Exception {
        Person addPerson = personService.addPerson(person);

        assertTrue("can get person",
                personService.getPerson(addPerson.getId()) instanceof Person);
    }

    @Test
    public void testRemovePerson() throws Exception {
        Person result = personService.addPerson(person);
        personService.removePerson(result.getId());
    }

    @Test
    public void testGetAllPeople() throws Exception {
        Collection<Person> allPeople = personService.getAllPeople();
        assertNotNull("can get all people", allPeople);
    }

    @Test
    public void personIntegrationTest() throws Exception {
        Person addedId = personService.addPerson(person);

        assertEquals("can get person", addedId.getId(), personService
                .getPerson(addedId.getId()).getId());

        Collection<Person> allPeople = personService.getAllPeople();
        assertTrue("can get all people", allPeople.size() >= 1);

        personService.removeAll();
    }
}
