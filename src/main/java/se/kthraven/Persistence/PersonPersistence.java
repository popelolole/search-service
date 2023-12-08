package se.kthraven.Persistence;

import io.quarkus.panache.common.Parameters;
import se.kthraven.Persistence.entities.PersonDB;

import java.util.List;

public class PersonPersistence {

    public static List<PersonDB> getAll(){
        return PersonDB.listAll();
    }

    public static PersonDB getById(String id){
        return PersonDB.findById(id);
    }

    public static List<PersonDB> getByName(String name){
        return PersonDB.list("name", name);
    }
}
