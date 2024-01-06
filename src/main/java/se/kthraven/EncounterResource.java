package se.kthraven;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import se.kthraven.Model.EncounterService;
import se.kthraven.Model.classes.Encounter;

import java.util.List;

@Path("/encounter")
public class EncounterResource {

    @Inject EncounterService encounterService;

    @GET
    @Path("/byDoctor/{id}")
    public List<Encounter> getByDoctorId(@PathParam("id") String id){
        return encounterService.getByDoctorId(id);
    }
}
