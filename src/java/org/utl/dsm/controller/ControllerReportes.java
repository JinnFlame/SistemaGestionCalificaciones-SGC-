import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.utl.dsm.db.ConexionSQL;
import org.utl.dsm.model.ModeloReportes;

public class ControllerReportes {

    public List<ModeloReportes> getAll(int parcial, int semestre, int idEspecialidad, String periodo) {
        List<ModeloReportes> reportes = new ArrayList<>();
        String query = "SELECT "
                + "e.Especialidad, "
                + "g.turno, "
                + "g.nombreGrupo, "
                + "COUNT(a.idAlumno) AS Numero_Alumnos, "
                + "SUM(CASE WHEN c.reprobadas = 0 THEN 1 ELSE 0 END) AS No_Reprobados, "
                + "SUM(CASE WHEN c.reprobadas = 1 THEN 1 ELSE 0 END) AS Reprobados_1, "
                + "SUM(CASE WHEN c.reprobadas = 2 THEN 1 ELSE 0 END) AS Reprobados_2, "
                + "SUM(CASE WHEN c.reprobadas = 3 THEN 1 ELSE 0 END) AS Reprobados_3, "
                + "SUM(CASE WHEN c.reprobadas = 4 THEN 1 ELSE 0 END) AS Reprobados_4, "
                + "SUM(CASE WHEN c.reprobadas >= 5 THEN 1 ELSE 0 END) AS Reprobados_5_o_mas, "
                + "ROUND(100.0 * SUM(CASE WHEN c.reprobadas = 0 THEN 1 ELSE 0 END) / COUNT(a.idAlumno), 2) AS Porcentaje_Aprobados, "
                + "ROUND(100.0 * SUM(CASE WHEN c.reprobadas > 0 THEN 1 ELSE 0 END) / COUNT(a.idAlumno), 2) AS Porcentaje_Reprobados "
                + "FROM "
                + "Grupo g "
                + "LEFT JOIN "
                + "Alumno a ON a.idGrupo = g.idGrupo "
                + "JOIN "
                + "Especialidad e ON g.idEspecialidad = e.idEspecialidad "
                + "LEFT JOIN "
                + "(SELECT "
                + "idAlumno, "
                + "SUM(CASE "
                + "WHEN CASE "
                + "WHEN ? = 1 THEN parcial1 "
                + "WHEN ? = 2 THEN parcial2 "
                + "WHEN ? = 3 THEN parcial3 "
                + "END < 7 THEN 1 ELSE 0 END) AS reprobadas "
                + "FROM "
                + "Calificacion "
                + "GROUP BY "
                + "idAlumno) c ON a.idAlumno = c.idAlumno "
                + "WHERE g.semestre = ? AND g.idEspecialidad = ? AND g.periodo = ? "
                + "GROUP BY "
                + "e.Especialidad, g.turno, g.nombreGrupo "
                + "ORDER BY "
                + "Reprobados_5_o_mas DESC;";
        try {
            ConexionSQL connMysql = new ConexionSQL();
            Connection conn = connMysql.open();
            PreparedStatement pstm = conn.prepareStatement(query);
            pstm.setInt(1, parcial);
            pstm.setInt(2, parcial);
            pstm.setInt(3, parcial);
            pstm.setInt(4, semestre);
            pstm.setInt(5, idEspecialidad);
            pstm.setString(6, periodo);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                String especialidad = rs.getString("Especialidad");
                String turno = rs.getString("turno");
                String nombreGrupo = rs.getString("nombreGrupo");
                int cantidadAlumnos = rs.getInt("Numero_Alumnos");
                int Reprobados_0 = rs.getInt("No_Reprobados");
                int Reprobados_1 = rs.getInt("Reprobados_1");
                int Reprobados_2 = rs.getInt("Reprobados_2");
                int Reprobados_3 = rs.getInt("Reprobados_3");
                int Reprobados_4 = rs.getInt("Reprobados_4");
                int Reprobados_5 = rs.getInt("Reprobados_5_o_mas");
                double aprobados = rs.getDouble("Porcentaje_Aprobados");
                double reprobados = rs.getDouble("Porcentaje_Reprobados");

                ModeloReportes reporte = new ModeloReportes(especialidad, turno, nombreGrupo, cantidadAlumnos,
                        Reprobados_0, Reprobados_1, Reprobados_2, Reprobados_3, Reprobados_4, Reprobados_5, aprobados,
                        reprobados);
                reportes.add(reporte);
            }
            rs.close();
            pstm.close();
            connMysql.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reportes;
    }

}