package se.kthraven;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.kthraven.Model.DoctorService;
import se.kthraven.Model.classes.Doctor;
import se.kthraven.Model.classes.Patient;
import se.kthraven.Model.enums.Role;
import se.kthraven.Persistence.PersonPersistence;
import se.kthraven.Persistence.entities.PersonDB;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
public class DoctorServiceTests {

    @Inject DoctorService doctorService;

    @BeforeAll
    public static void setup(){
        PersonPersistence mock = Mockito.mock(PersonPersistence.class);
        when(mock.getDoctorByName("John Doe")).thenReturn(Arrays.asList(new PersonDB("1", "John Doe", null, null, Role.DOCTOR)));
        QuarkusMock.installMockForType(mock, PersonPersistence.class);
    }

    @Test
    void testGetByName(){
        List<Doctor> doctors = doctorService.getByName("John Doe");

        assertEquals(1, doctors.size());
        assertEquals("John Doe", doctors.get(0).getName());
    }
}
