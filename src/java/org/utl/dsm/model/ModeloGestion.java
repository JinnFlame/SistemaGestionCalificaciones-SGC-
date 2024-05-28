/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.model;

/**
 *
 * @author Andres
 */
public class ModeloGestion {

    private int idAlumno;
    private int idCalificacion;
    private int idMateria;
    private String Nombre;
    private String ApellidoP;
    private String ApellidoM;
    private String Nocontrol;
    private String email;
    private String emailIns;
    private String telefono;
    private String telefono2;
    private String nombreGrupo;
    private String nombreMateria;
    private double parcial1;
    private double parcial2;
    private double parcial3;
    private double promedioParciales;
    private double promedio;
    private int materiasReprobadas;

    public ModeloGestion() {
    }

    public ModeloGestion(int idAlumno, String Nombre, String ApellidoP, String ApellidoM, String Nocontrol,
            String email, String emailIns, String telefono, String telefono2, String nombreGrupo, double promedio,
            int materiasReprobadas) {
        this.idAlumno = idAlumno;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Nocontrol = Nocontrol;
        this.email = email;
        this.emailIns = emailIns;
        this.telefono = telefono;
        this.telefono2 = telefono2;
        this.nombreGrupo = nombreGrupo;
        this.promedio = promedio;
        this.materiasReprobadas = materiasReprobadas;

    }

    public ModeloGestion(int idAlumno, double parcial1, double parcial2, double parcial3, String nombreMateria,
            double promedioParciales) {
        this.idAlumno = idAlumno;
        this.parcial1 = parcial1;
        this.parcial2 = parcial2;
        this.parcial3 = parcial3;
        this.nombreMateria = nombreMateria;
        this.promedioParciales = promedioParciales;

    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public String getNocontrol() {
        return Nocontrol;
    }

    public void setNocontrol(String Nocontrol) {
        this.Nocontrol = Nocontrol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public int getIdCalificacion() {
        return idCalificacion;
    }

    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public double getParcial1() {
        return parcial1;
    }

    public void setParcial1(double parcial1) {
        this.parcial1 = parcial1;
    }

    public double getParcial2() {
        return parcial2;
    }

    public void setParcial2(double parcial2) {
        this.parcial2 = parcial2;
    }

    public double getParcial3() {
        return parcial3;
    }

    public void setParcial3(double parcial3) {
        this.parcial3 = parcial3;
    }

    public double getPromedioParciales() {
        return promedioParciales;
    }

    public void setPromedioParciales(double promedioParciales) {
        this.promedioParciales = promedioParciales;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public int getMateriasReprobadas() {
        return materiasReprobadas;
    }

    public void setMateriasReprobadas(int materiasReprobadas) {
        this.materiasReprobadas = materiasReprobadas;
    }

    public String getEmailIns() {
        return emailIns;
    }

    public void setEmailIns(String emailIns) {
        this.emailIns = emailIns;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

}
