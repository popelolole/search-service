package se.kthraven.Persistence;

import se.kthraven.Persistence.entities.EncounterDB;

import java.util.List;

public class EncounterPersistence {

    public static List<EncounterDB> getByDoctorId(String id){
        return EncounterDB.list("doctor.id", id);
    }
}
