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

    private String Nocontrol;
    private String ApellidoP;
    private String ApellidoM;
    private String nombre;
    private String email;
    private String telefono;
    private String nombre_grupo;
    private String nombre_materia;
    private double calificacion;
    private int id_calificacion;
    private int id_alumno;
    private int id_materia;

    public ModeloGestion() {
    }

    public ModeloGestion(String Nocontrol, String ApellidoP, String ApellidoM, String nombre, String email, String telefono, String nombre_grupo, String nombre_materia, double calificacion, int id_calificacion, int id_alumno, int id_materia) {
        this.Nocontrol = Nocontrol;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.nombre_grupo = nombre_grupo;
        this.nombre_materia = nombre_materia;
        this.calificacion = calificacion;
        this.id_calificacion = id_calificacion;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public ModeloGestion(int id_alumno, String Nocontrol, String ApellidoP, String ApellidoM, String Nombre, String Email, String Telefono, String Nombre_grupo, String Nombre_materia) {
        this.Nocontrol = Nocontrol;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.nombre_grupo = nombre_grupo;
        this.nombre_materia = nombre_materia;
        this.id_alumno = id_alumno;
        this.id_materia = id_materia;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNocontrol() {
        return Nocontrol;
    }

    public void setNocontrol(String Nocontrol) {
        this.Nocontrol = Nocontrol;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }

    public String getNombre_materia() {
        return nombre_materia;
    }

    public void setNombre_materia(String nombre_materia) {
        this.nombre_materia = nombre_materia;
    }

}
