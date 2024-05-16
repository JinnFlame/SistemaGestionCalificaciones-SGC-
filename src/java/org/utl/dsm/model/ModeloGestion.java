/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.model;



/**
 *
 * @author Caval
 */
public class ModeloGestion {

    private int idAlumno;
    private String Nombre;
    private String ApellidoP;
    private String ApellidoM;
    private String Nocontrol;
    private String email;
    private String telefono;
    private String nombreGrupo;
    private double calificacion;
    private double promedio;
    private String nombreMateria;
    private int idCalificacion;
    private int idMateria;

    public ModeloGestion() {
    }

    public ModeloGestion(int idAlumno, String Nombre, String ApellidoP, String ApellidoM, String Nocontrol, String email, String telefono, String nombreGrupo, double calificacion, double promedio, String nombreMateria) {
        this.idAlumno = idAlumno;
        this.Nombre = Nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.Nocontrol = Nocontrol;
        this.email = email;
        this.telefono = telefono;
        this.nombreGrupo = nombreGrupo;
        this.calificacion = calificacion;
        this.promedio = promedio;
        this.nombreMateria = nombreMateria;

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

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
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

}
