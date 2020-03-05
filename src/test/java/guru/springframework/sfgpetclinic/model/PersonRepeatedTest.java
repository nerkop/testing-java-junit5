package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTest;
import guru.springframework.sfgpetclinic.services.springdatajpa.ModelRepatedTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

public class PersonRepeatedTest implements ModelRepatedTest {

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
