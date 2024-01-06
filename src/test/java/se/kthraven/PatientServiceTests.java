package se.kthraven;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import se.kthraven.Model.PatientService;
import se.kthraven.Model.classes.Patient;
import se.kthraven.Model.enums.Role;
import se.kthraven.Persistence.PersonPersistence;
import se.kthraven.Persistence.entities.PersonDB;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
class PatientServiceTests {

    @Inject
    PatientService patientService;

    @BeforeAll
    public static void setup(){
        PersonPersistence mock = Mockito.mock(PersonPersistence.class);
        when(mock.getAllPatients()).thenReturn(Arrays.asList(new PersonDB("1", "John Doe", null, null, Role.PATIENT)));
        when(mock.getPatientById("1")).thenReturn(new PersonDB("1", "John Doe", null, null, Role.PATIENT));
        when(mock.getPatientByConditionName("Condition")).thenReturn(Arrays.asList(new PersonDB("1", "John Doe", null, null, Role.PATIENT)));
        when(mock.getPatientByName("John Doe")).thenReturn(Arrays.asList(new PersonDB("1", "John Doe", null, null, Role.PATIENT)));
        QuarkusMock.installMockForType(mock, PersonPersistence.class);
    }

    @Test
    void testGetAll() {
        List<Patient> patients = patientService.getAll();

        assertEquals(1, patients.size());
        assertEquals("John Doe", patients.get(0).getName());
    }

    @Test
    void testGetById() {
        Patient patient = patientService.getById("1");

        assertEquals("John Doe", patient.getName());
    }

    @Test
    void testGetByName() {
        List<Patient> patients = patientService.getByName("John Doe");

        assertEquals(1, patients.size());
        assertEquals("John Doe", patients.get(0).getName());
    }

    @Test
    void testGetByConditionName() {
        List<Patient> patients = patientService.getByConditionName("Condition");

        assertEquals(1, patients.size());
        assertEquals("John Doe", patients.get(0).getName());
    }
}
