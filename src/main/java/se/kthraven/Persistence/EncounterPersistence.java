package se.kthraven.Persistence;

import jakarta.enterprise.context.ApplicationScoped;
import se.kthraven.Persistence.entities.EncounterDB;

import java.util.List;

@ApplicationScoped
public class EncounterPersistence {

    public List<EncounterDB> getByDoctorId(String id){
        return EncounterDB.list("doctor.id", id);
    }
}
