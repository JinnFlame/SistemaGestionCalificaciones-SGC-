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
        String query = "SELECT "
                + "a.idAlumno, "
                + "a.nombreAlumno, "
                + "a.apellidoPaterno, "
                + "a.apellidoMaterno, "
                + "a.noControl, "
                + "a.email, "
                + "a.telefono, "
                + "g.nombreGrupo, "
                + "GROUP_CONCAT(m.nombreMateria SEPARATOR ', ') AS materias, "
                + "GROUP_CONCAT(c.calificacion SEPARATOR ', ') AS calificaciones, "
                + "GROUP_CONCAT(c.promedio SEPARATOR ', ') AS promedios "
                + "FROM Boleta b "
                + "JOIN Alumno a ON b.idAlumno = a.idAlumno "
                + "JOIN Calificacion c ON b.idCalificacion = c.idCalificacion "
                + "JOIN Materia m ON b.idMateria = m.idMateria "
                + "JOIN Grupo g ON a.idGrupo = g.idGrupo "
                + "GROUP BY a.idAlumno";

        try {
            ConexionSQL connMysql = new ConexionSQL();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String Nombre = rs.getString("nombreAlumno");
                String ApellidoP = rs.getString("apellidoPaterno");
                String ApellidoM = rs.getString("apellidoMaterno");
                String Nocontrol = rs.getString("noControl");
                String Email = rs.getString("email");
                String Telefono = rs.getString("telefono");
                String nombreGrupo = rs.getString("nombreGrupo");
                double Calificacion = rs.getDouble("calificaciones");
                double promedio = rs.getDouble("promedios");
                String nombreMateria = rs.getString("materias");
                ModeloGestion persona = new ModeloGestion(idAlumno, Nombre, ApellidoP, ApellidoM, Nocontrol, Email, Telefono, nombreGrupo, Calificacion, promedio, nombreMateria);
                System.out.println(idAlumno + Nocontrol + ApellidoP + ApellidoM + Nombre + Email + Telefono + nombreGrupo + nombreMateria);
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
