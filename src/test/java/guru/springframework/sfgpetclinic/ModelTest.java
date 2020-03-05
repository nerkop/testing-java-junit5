package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.*;

@Tag("model")
public interface ModelTest {

    @BeforeEach
    default void beforeEachTest(TestInfo testInfo){
        System.out.println("Before each Model Test : " + testInfo.getDisplayName());
    }


}
