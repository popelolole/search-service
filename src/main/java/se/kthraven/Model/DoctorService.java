package se.kthraven.Model;

import se.kthraven.Model.classes.Doctor;
import se.kthraven.Model.classes.Patient;
import se.kthraven.Model.enums.Role;
import se.kthraven.Persistence.PersonPersistence;
import se.kthraven.Persistence.entities.PersonDB;

import java.util.LinkedList;
import java.util.List;

public class DoctorService {

    public static List<Doctor> getByName(String name){
        List<PersonDB> personDBs = PersonPersistence.getDoctorByName(name);
        List<Doctor> doctors = new LinkedList<>();
        for(PersonDB personDB : personDBs){
            doctors.add(Doctor.from(personDB));
        }
        return doctors;
    }
}
