package se.kthraven.Persistence;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import se.kthraven.Model.enums.Role;
import se.kthraven.Persistence.entities.PersonDB;

import java.util.List;

public class PersonPersistence {

    public static List<PersonDB> getAllPatients(){
        return PersonDB.find("role", Role.PATIENT).list();
    }

    public static PersonDB getPatientById(String id){
        return PersonDB.find("id = ?1 and role = ?2", id, Role.PATIENT).singleResult();
    }

    public static List<PersonDB> getPatientByName(String name){
        return PersonDB.find("name = ?1 and role = ?2", name, Role.PATIENT).list();
    }

    public static List<PersonDB> getPatientByConditionName(String name){
        return PersonDB.find("condition.condition = ?1 and role = ?2", name, Role.PATIENT).list();
    }

    public static List<PersonDB> getDoctorByName(String name){
        return PersonDB.find("name = ?1 and role = ?2", name, Role.DOCTOR).list();
    }
}
