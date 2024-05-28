package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.controller.ControllerReportes;
import org.utl.dsm.model.ModeloReportes;

/**
 *
 * @author Caval
 */
@Path("reportes")
public class RestReportes {

    @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("parcial") int parcial, @QueryParam("semestre") int semestre,
            @QueryParam("idEspecialidad") int idEspecialidad, @QueryParam("periodo") String periodo) {
        String out = "";
        try {
            ControllerReportes cr = new ControllerReportes();
            List<ModeloReportes> rr = cr.getAll(parcial, semestre, idEspecialidad, periodo);
            Gson gs = new Gson();
            out = gs.toJson(rr);

        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";

        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

}