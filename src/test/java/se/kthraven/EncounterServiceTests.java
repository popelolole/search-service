package se.kthraven;

import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import se.kthraven.Model.EncounterService;
import se.kthraven.Model.classes.Doctor;
import se.kthraven.Model.classes.Encounter;
import se.kthraven.Model.enums.Role;
import se.kthraven.Persistence.EncounterPersistence;
import se.kthraven.Persistence.PersonPersistence;
import se.kthraven.Persistence.entities.EncounterDB;
import se.kthraven.Persistence.entities.PersonDB;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@QuarkusTest
public class EncounterServiceTests {

    @Inject EncounterService encounterService;

    @BeforeAll
    public static void setup(){
        EncounterPersistence mock = Mockito.mock(EncounterPersistence.class);
        when(mock.getByDoctorId("1")).thenReturn(Arrays.asList(new EncounterDB("1", new PersonDB("2", null, null, null, Role.PATIENT), new PersonDB("3", "John Doe", null, null, Role.DOCTOR), null)));
        QuarkusMock.installMockForType(mock, EncounterPersistence.class);
    }

    @Test
    void testGetByDoctorId(){
        List<Encounter> encounters = encounterService.getByDoctorId("1");

        assertEquals(1, encounters.size());
        assertEquals("John Doe", encounters.get(0).getDoctor().getName());
    }
}
