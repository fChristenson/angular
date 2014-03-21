package se.fidde.angular.util;

import se.fidde.angular.domain.Person;

public class MockTools {

    public static Person getMockPerson() {
        return new Person(MockStrings.NAME.toString(),
                MockStrings.EMAIL.toString());
    }
}
