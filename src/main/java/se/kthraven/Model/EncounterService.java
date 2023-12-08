package se.kthraven.Model;

import se.kthraven.Model.classes.Encounter;
import se.kthraven.Persistence.EncounterPersistence;
import se.kthraven.Persistence.entities.EncounterDB;

import java.util.LinkedList;
import java.util.List;

public class EncounterService {

    public static List<Encounter> getByDoctorId(String id){
        List<EncounterDB> encounterDBs = EncounterPersistence.getByDoctorId(id);
        List<Encounter> encounters = new LinkedList<>();
        for(EncounterDB encounterDB : encounterDBs){
            encounters.add(Encounter.from(encounterDB));
        }
        return encounters;
    }
}
