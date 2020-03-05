package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertion() {
        Owner owner = new Owner(1l, "John", "Wayne");
        owner.setCity("Ši City");
        owner.setTelephone("+3123456789");

        assertAll("Property test",
                () -> assertAll("Person properties",
                        () -> assertEquals("John", owner.getFirstName(), "First name dont match"),
                        () -> assertEquals("Wayne", owner.getLastName(), "Last name dont match")),
                () -> assertAll("Owner Properties",
                        () -> assertEquals("Ši City", owner.getCity(), "City dont match"),
                        () -> assertEquals("+3123456789", owner.getTelephone(), "Phone num dont match")
                ));

        assertThat(owner.getCity(), is("Ši City"));


    }
}