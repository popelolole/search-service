package se.kthraven;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import se.kthraven.Model.EncounterService;
import se.kthraven.Model.classes.Encounter;

import java.util.List;

@Path("/encounter")
public class EncounterResource {

    @GET
    @Path("/byDoctor/{id}")
    public List<Encounter> getByDoctorId(@PathParam("id") String id){
        return EncounterService.getByDoctorId(id);
    }
}
