package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class OwnerTest implements ModelTest {

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

    @DisplayName("Value Source")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Nermin", "Nerko", "Nerkec"})
    void testValueSource(String value) {
        System.out.println(value);
    }

    @DisplayName("Enum test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void testEnumValue(OwnerType ownerType) {
        System.out.println(ownerType);
    }

    @DisplayName("Csv input test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvSource({
            "TZ, 1, 1",
            "MO, 2, 2",
            "BL, 3, 3"
    })
    void testCsvInput(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    @DisplayName("Csv input file test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @CsvFileSource(resources = "/city.csv", numLinesToSkip = 1)
    void testCsvInputFile(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    @DisplayName("Method provider test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @MethodSource("getArgs")
    void testMethodProvider(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }

    public static Stream<Arguments> getArgs(){
        return Stream.of(Arguments.of("TZ", 1, 1), Arguments.of("BL", 2, 2),
                Arguments.of("SA", 3, 3));
    }

    @DisplayName("Custom provider test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ArgumentsSource(CustomArgsProvider.class)
    void testCustomProvider(String stateName, int val1, int val2) {
        System.out.println(stateName + " = " + val1 + " : " + val2);
    }





}