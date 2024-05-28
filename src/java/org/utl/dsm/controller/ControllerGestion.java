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

    public List<ModeloGestion> getAll(int idEspecialidad, int semestre) {
        List<ModeloGestion> alumnos = new ArrayList<>();
        String query = "SELECT "
                + "a.idAlumno, "
                + "a.nombreAlumno, "
                + "a.apellidoPaterno, "
                + "a.apellidoMaterno, "
                + "a.noControl, "
                + "a.correoI, "
                + "a.correoP, "
                + "a.telefono1, "
                + "a.telefono2, "
                + "g.nombreGrupo, "
                + "ROUND(AVG((c.parcial1 + c.parcial2 + c.parcial3) / 3), 2) AS promedio, "
                + "SUM(CASE WHEN (c.parcial1 + c.parcial2 + c.parcial3) / 3 < 7 THEN 1 ELSE 0 END) AS materiasReprobadas "
                + "FROM Alumno a "
                + "JOIN Grupo g ON a.idGrupo = g.idGrupo "
                + "JOIN Especialidad e ON g.idEspecialidad = e.idEspecialidad "
                + "LEFT JOIN Calificacion c ON a.idAlumno = c.idAlumno "
                + "WHERE e.idEspecialidad = ? AND g.semestre = ? "
                + "GROUP BY a.idAlumno, a.nombreAlumno, a.apellidoPaterno, a.apellidoMaterno, a.noControl, a.correoI, a.correoP, a.telefono1, a.telefono2, g.nombreGrupo "
                + "ORDER BY materiasReprobadas DESC;";

        try {
            ConexionSQL connMysql = new ConexionSQL();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, idEspecialidad);
            pstm.setInt(2, semestre);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int idAlumno = rs.getInt("idAlumno");
                String Nombre = rs.getString("nombreAlumno");
                String ApellidoP = rs.getString("apellidoPaterno");
                String ApellidoM = rs.getString("apellidoMaterno");
                String Nocontrol = rs.getString("noControl");
                String Email = rs.getString("correoI");
                String EmailIns = rs.getString("correoP");
                String Telefono = rs.getString("telefono1");
                String Telefono2 = rs.getString("telefono2");
                String nombreGrupo = rs.getString("nombreGrupo");
                double promedio = rs.getDouble("promedio");
                int materiasReprobadas = rs.getInt("materiasReprobadas");

                ModeloGestion persona = new ModeloGestion(idAlumno, Nombre, ApellidoP, ApellidoM, Nocontrol, Email,
                        EmailIns, Telefono, Telefono2, nombreGrupo, promedio, materiasReprobadas);
                System.out.println("hola" + Email + EmailIns);
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

    public List<ModeloGestion> getMateriasCalificaciones(int idAlumno) {
        List<ModeloGestion> materiasCalificaciones = new ArrayList<>();
        String query = "SELECT "
                + "m.nombreMateria, "
                + "c.parcial1, "
                + "c.parcial2, "
                + "c.parcial3, "
                + "ROUND((c.parcial1 + c.parcial2 + c.parcial3) / 3, 2) AS promedioParciales "
                + "FROM Calificacion c "
                + "JOIN Materia m ON c.idMateria = m.idMateria "
                + "WHERE c.idAlumno = ?;";

        try {
            ConexionSQL connMysql = new ConexionSQL();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, idAlumno);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                String nombreMateria = rs.getString("nombreMateria");
                double parcial1 = rs.getDouble("parcial1");
                double parcial2 = rs.getDouble("parcial2");
                double parcial3 = rs.getDouble("parcial3");
                double promedioParciales = rs.getDouble("promedioParciales"); // Obtenemos el promedio de los parciales

                ModeloGestion materiaCalificacion = new ModeloGestion();
                materiaCalificacion.setNombreMateria(nombreMateria);
                materiaCalificacion.setParcial1(parcial1);
                materiaCalificacion.setParcial2(parcial2);
                materiaCalificacion.setParcial3(parcial3);
                materiaCalificacion.setPromedioParciales(promedioParciales); // Seteamos el promedio de los parciales

                materiasCalificaciones.add(materiaCalificacion);
            }
            rs.close();
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return materiasCalificaciones;
    }
}