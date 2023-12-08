package se.kthraven;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import se.kthraven.Model.PatientService;
import se.kthraven.Model.classes.Patient;

import java.util.List;

@Path("/patient")
public class PatientResource {

    @GET
    public List<Patient> getById() {
        return PatientService.getAll();
    }

    @GET
    @Path("/byId/{id}")
    public Patient getById(@PathParam("id") String id) {
        return PatientService.getById(id);
    }

    @GET
    @Path("/byName")
    public List<Patient> getByName(@QueryParam("name") String name) {
        return PatientService.getByName(name);
    }

    @GET
    @Path("/byCondition")
    public List<Patient> getByConditionName(@QueryParam("name") String name) {
        return PatientService.getByConditionName(name);
    }
}
