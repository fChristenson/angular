package se.fidde.angular.util;

public enum MockStrings {
    NAME("foo"), EMAIL("foo@bar.se"), MOCK_PERSON_AS_JSON(
            "{\"id\":0,\"email\":\"foo@bar.se\",\"personName\":\"foo\"}");

    private final String STRING;

    private MockStrings(String string) {
        STRING = string;
    }

    @Override
    public String toString() {
        return STRING;
    }
}
