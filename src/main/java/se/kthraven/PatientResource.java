package se.kthraven;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import se.kthraven.Model.PatientService;
import se.kthraven.Model.classes.Patient;

import java.util.List;

@Path("/patient")
public class PatientResource {

    @Inject
    PatientService patientService;

    @GET
    public List<Patient> get() {
        return patientService.getAll();
    }

    @GET
    @Path("/byId/{id}")
    public Patient getById(@PathParam("id") String id) {
        return patientService.getById(id);
    }

    @GET
    @Path("/byName")
    public List<Patient> getByName(@QueryParam("name") String name) {
        return patientService.getByName(name);
    }

    @GET
    @Path("/byCondition")
    public List<Patient> getByConditionName(@QueryParam("name") String name) {
        return patientService.getByConditionName(name);
    }
}
