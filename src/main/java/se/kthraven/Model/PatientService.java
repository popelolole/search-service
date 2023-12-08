package se.kthraven.Model;

import se.kthraven.Model.classes.Patient;
import se.kthraven.Model.classes.Person;
import se.kthraven.Model.enums.Role;
import se.kthraven.Persistence.PersonPersistence;
import se.kthraven.Persistence.entities.PersonDB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PatientService {

    public static List<Patient> getAll(){
        List<PersonDB> personDBs = PersonPersistence.getAll();
        List<Patient> patients = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            if(personDB.getRole().equals(Role.PATIENT))
                patients.add(Patient.from(personDB));
        }
        return patients;
    }

    public static Patient getById(String id){
        PersonDB personDB = PersonPersistence.getById(id);
        Patient patient = null;
        if(personDB.getRole().equals(Role.PATIENT))
            patient = Patient.from(personDB);
        return patient;
    }

    public static List<Patient> getByName(String name){
        List<PersonDB> personDBs = PersonPersistence.getByName(name);
        List<Patient> patients = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            if(personDB.getRole().equals(Role.PATIENT))
                patients.add(Patient.from(personDB));
        }
        return patients;
    }
}
