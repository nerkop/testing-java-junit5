package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest implements ModelTest {

    @Test
    void groupAssertions() {
        //given
        Person person = new Person(1l, "John", "Wayne");
        //then
        assertAll("Test props set",
                () -> assertEquals("John", person.getFirstName(), "First name failed"),
                () -> assertEquals("Wayne", person.getLastName(), "Last name failed"));
    }

    @DisplayName("My Repeated test")
    @RepeatedTest(value = 5, name = RepeatedTest.SHORT_DISPLAY_NAME)
    void myRepeatedTest() {
        System.out.println("Repeated test");

    }

    @RepeatedTest(5)
    void myRepatedTestWithId(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " : " + repetitionInfo.getCurrentRepetition());
    }

    @RepeatedTest(value = 3, name = "{displayName} : {currentRepetition} / {totalRepetitions}")
    @DisplayName("My Assigment Repated test")
    void myAssigmentRepeated() {
    }
}