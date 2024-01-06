package se.kthraven;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import se.kthraven.Model.DoctorService;
import se.kthraven.Model.classes.Doctor;

import java.util.List;

@Path("/doctor")
public class DoctorResource {
    @Inject DoctorService doctorService;

    @GET
    @Path("/byName")
    public List<Doctor> getByName(@QueryParam("name") String name){
        return doctorService.getByName(name);
    }
}
