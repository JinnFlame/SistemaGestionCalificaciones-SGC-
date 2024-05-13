/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
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
        List<ModeloGestion> alumnos = new ArrayList<>();
        System.out.println("hola");
        String query = "SELECT a.*, g.nombre_grupo, m.nombre_materia "
                + "FROM Alumnos a "
                + "JOIN Grupos g ON a.id_grupo = g.id_grupo "
                + "JOIN Materias m ON g.id_materia = m.id_materia";

        try {
            ConexionSQL connMysql = new ConexionSQL();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                ModeloGestion alumno = new ModeloGestion();

                int id_alumno = rs.getInt("id_alumno");
                String Nocontrol = rs.getString("Nocontrol");
                String ApellidoP = rs.getString("ApellidoP");
                String ApellidoM = rs.getString("ApellidoM");
                String Nombre = rs.getString("Nombre");
                String Email = rs.getString("Email");
                String Telefono = rs.getString("Telefono");
                String Nombre_grupo = rs.getString("Nombre_grupo");
                String Nombre_materia = rs.getString("Nombre_materia");
                ModeloGestion persona = new ModeloGestion(id_alumno, Nocontrol, ApellidoP, ApellidoM, Nombre, Email, Telefono, Nombre_grupo, Nombre_materia);
                alumnos.add(persona);
            }
            rs.close();
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return alumnos;
    }
}
