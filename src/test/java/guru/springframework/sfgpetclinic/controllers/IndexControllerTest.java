package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.sfgpetclinic.ControllerTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest implements ControllerTest {

    IndexController indexController;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @DisplayName("Test for Index")
    @Test
    void index() {
        assertEquals("index", indexController.index());
        assertThat(indexController.index()).isEqualTo("index");
    }

    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            indexController.oupsHandler();
        });
    }

    @Disabled(value = "Demo of timeout")
    @Test
    void testTimeout() {
        assertTimeout(Duration.ofMillis(100),
                () -> Thread.sleep(5000));
        System.out.println("i got here");
    }

    @Disabled(value = "Demo of timeout")
    @Test
    void testTimeoutPrempt() {
        assertTimeoutPreemptively(Duration.ofMillis(100), ()-> Thread.sleep(5000));
        System.out.println("i got here too. Did I?");
    }

    @Test
    void testAssumptionTrue() {
        assumeTrue("GURU".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
    }

    @Test
    void testAssumptionTrueAssumtionIsTrue() {
        assumeTrue("GURU".equalsIgnoreCase("GURU"));
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testMeOnWindows() {
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testMeForJava8() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "ABC")
    void testEnv() {
    }
}