package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Tag("model")
class PersonTest {

    @Test
    void groupAssertions() {
        //given
        Person person = new Person(1l, "John", "Wayne");
        //then
        assertAll("Test props set",
                () -> assertEquals("John", person.getFirstName(), "First name failed"),
                () -> assertEquals("Wayne", person.getLastName(), "Last name failed"));
    }
}