package se.fidde.angular.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.fidde.angular.util.MockStrings;
import se.fidde.angular.util.MockTools;

public class PersonTest {

    private Person person;

    @Before
    public void setUp() throws Exception {
        person = MockTools.getMockPerson();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPerson() throws Exception {
        assertNotNull("can create person", person);
    }

    @Test
    public void testGetName() throws Exception {
        assertEquals("can get name", MockStrings.NAME.toString(),
                person.getName());
    }

    @Test
    public void testGetEmail() throws Exception {
        assertEquals("can get email", MockStrings.EMAIL.toString(),
                person.getEmail());
    }
}
