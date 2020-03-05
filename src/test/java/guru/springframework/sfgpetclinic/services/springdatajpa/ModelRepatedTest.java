package guru.springframework.sfgpetclinic.services.springdatajpa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("repeat")
public interface ModelRepatedTest {

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo, RepetitionInfo repetitionInfo){
        System.out.println("Before each Model Test : " + testInfo.getDisplayName() + " , " + repetitionInfo.getCurrentRepetition());
    }

}
