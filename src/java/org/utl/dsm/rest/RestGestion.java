package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.controller.ControllerGestion;
import org.utl.dsm.model.ModeloGestion;

@Path("gestion")
public class RestGestion {

    @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@QueryParam("idEspecialidad") int idEspecialidad, @QueryParam("semestre") int semestre) {
        String out = "";
        try {
            ControllerGestion cp = new ControllerGestion();
            List<ModeloGestion> producto = cp.getAll(idEspecialidad, semestre);
            Gson gs = new Gson();
            out = gs.toJson(producto);

        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";

        }
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("saludar")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response saludar() {
        String out = """
                    {"result":"Hola Mundo"}
                """;
        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getmateriascalificaciones/{idAlumno}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMateriasCalificaciones(@PathParam("idAlumno") int idAlumno) {
        String out = "";
        try {
            ControllerGestion cp = new ControllerGestion();
            List<ModeloGestion> materiasCalificaciones = cp.getMateriasCalificaciones(idAlumno);
            Gson gs = new Gson();
            out = gs.toJson(materiasCalificaciones);
        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
}
