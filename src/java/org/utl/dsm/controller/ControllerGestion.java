/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.db.ConexionSQL;
import org.utl.dsm.model.ModeloGestion;

/**
 *
 * @author Caval
 */
public class ControllerGestion {
    public List<ModeloGestion> getAll() {
        //Se crea una lista llamada personas que almacenar� objetos de tipo Persona.
        List<ModeloGestion> personas = new ArrayList<>();
        // Se define una consulta SQL que selecciona todos los registros de la tabla "persona".
        String query = "SELECT * FROM producto";

        // Se establece una conexion con la base de datos.
        try {
            ConexionSQL connMysql = new ConexionSQL();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idProducto");
                String nombre = rs.getString("nombre");
                String nombreGenerico = rs.getString("nombreGenerico");
                String formaFarmaceutica = rs.getString("formaFarmaceutica");
                String unidadMedida = rs.getString("unidadMedida");
                String presentacion = rs.getString("presentacion");
                String principalIndicacion = rs.getString("principalIndicacion");
                String contraindicaciones = rs.getString("contraindicaciones");
                String concentracion = rs.getString("concentracion");
                int unidadesEnvase = rs.getInt("unidadesEnvase");
                float precioCompra = rs.getFloat("precioCompra");
                float precioVenta = rs.getFloat("precioVenta");
                int estatus = rs.getInt("estatus");
                ModeloGestion producto = new ModeloGestion(id, nombre, nombreGenerico, formaFarmaceutica, unidadMedida, presentacion, principalIndicacion, contraindicaciones, concentracion, unidadesEnvase, precioCompra, precioVenta, estatus);
                personas.add(producto);
            }
            rs.close();
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Finalmente, se devuelve la lista personas que contiene todos los registros de la tabla "persona".
        return personas;
    }
}
