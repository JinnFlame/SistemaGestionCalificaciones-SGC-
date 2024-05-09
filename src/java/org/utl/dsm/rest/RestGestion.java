/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import org.utl.dsm.controller.ControllerGestion;
import org.utl.dsm.model.ModeloGestion;

/**
 *
 * @author Caval
 */
public class RestGestion {
    @Path("getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out = "";
        try {
            ControllerGestion cp = new ControllerGestion();
            List<ModeloGestion> producto = cp.getAll();
            Gson gs = new Gson();
            out = gs.toJson(producto);

        } catch (Exception ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";

        }
        return Response.status(Response.Status.OK).entity(out).build();

    }
}
