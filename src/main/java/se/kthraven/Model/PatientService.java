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
        List<PersonDB> personDBs = PersonPersistence.getAllPatients();
        List<Patient> patients = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            patients.add(Patient.from(personDB));
        }
        return patients;
    }

    public static Patient getById(String id){
        PersonDB personDB = PersonPersistence.getPatientById(id);
        Patient patient = null;
        patient = Patient.from(personDB);
        return patient;
    }

    public static List<Patient> getByName(String name){
        List<PersonDB> personDBs = PersonPersistence.getPatientByName(name);
        List<Patient> patients = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            patients.add(Patient.from(personDB));
        }
        return patients;
    }

    public static List<Patient> getByConditionName(String name){
        List<PersonDB> personDBs = PersonPersistence.getPatientByConditionName(name);
        List<Patient> patients = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            patients.add(Patient.from(personDB));
        }
        return patients;
    }
}
