package se.kthraven.Model;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import se.kthraven.Model.classes.Patient;
import se.kthraven.Model.classes.Person;
import se.kthraven.Model.enums.Role;
import se.kthraven.Persistence.PersonPersistence;
import se.kthraven.Persistence.entities.PersonDB;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@ApplicationScoped
public class PatientService {

    @Inject
    PersonPersistence personPersistence;

    public List<Patient> getAll(){
        List<PersonDB> personDBs = personPersistence.getAllPatients();
        List<Patient> patients = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            patients.add(Patient.from(personDB));
        }
        return patients;
    }

    public Patient getById(String id){
        PersonDB personDB = personPersistence.getPatientById(id);
        Patient patient = null;
        patient = Patient.from(personDB);
        return patient;
    }

    public List<Patient> getByName(String name){
        List<PersonDB> personDBs = personPersistence.getPatientByName(name);
        List<Patient> patients = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            patients.add(Patient.from(personDB));
        }
        return patients;
    }

    public List<Patient> getByConditionName(String name){
        List<PersonDB> personDBs = personPersistence.getPatientByConditionName(name);
        List<Patient> patients = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            patients.add(Patient.from(personDB));
        }
        return patients;
    }
}
