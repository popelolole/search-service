package se.kthraven.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kthraven.Model.classes.Encounter;
import se.kthraven.Persistence.EncounterPersistence;
import se.kthraven.Persistence.entities.EncounterDB;

import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class EncounterService {

    @Inject EncounterPersistence encounterPersistence;
    public List<Encounter> getByDoctorId(String id){
        List<EncounterDB> encounterDBs = encounterPersistence.getByDoctorId(id);
        List<Encounter> encounters = new LinkedList<>();
        for(EncounterDB encounterDB : encounterDBs){
            encounters.add(Encounter.from(encounterDB));
        }
        return encounters;
    }
}
