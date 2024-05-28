/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.dsm.model;

/**
 *
 * @author Andres
 */
public class ModeloReportes {

    private String especialidad;
    private String turno;
    private String nombreGrupo;
    private int cantidadAlumnos;
    private int Reprobados_0;
    private int Reprobados_1;
    private int Reprobados_2;
    private int Reprobados_3;
    private int Reprobados_4;
    private int Reprobados_5;
    private double aprobados;
    private double reprobados;

    public ModeloReportes(String especialidad, String turno, String nombreGrupo, int cantidadAlumnos, int Reprobados_0,
            int Reprobados_1, int Reprobados_2, int Reprobados_3, int Reprobados_4, int Reprobados_5, double aprobados,
            double reprobados) {
        this.especialidad = especialidad;
        this.turno = turno;
        this.nombreGrupo = nombreGrupo;
        this.cantidadAlumnos = cantidadAlumnos;
        this.Reprobados_0 = Reprobados_0;
        this.Reprobados_1 = Reprobados_1;
        this.Reprobados_2 = Reprobados_2;
        this.Reprobados_3 = Reprobados_3;
        this.Reprobados_4 = Reprobados_4;
        this.Reprobados_5 = Reprobados_5;
        this.aprobados = aprobados;
        this.reprobados = reprobados;
    }

    public ModeloReportes() {
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public int getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(int cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public int getReprobados_0() {
        return Reprobados_0;
    }

    public void setReprobados_0(int Reprobados_0) {
        this.Reprobados_0 = Reprobados_0;
    }

    public int getReprobados_1() {
        return Reprobados_1;
    }

    public void setReprobados_1(int Reprobados_1) {
        this.Reprobados_1 = Reprobados_1;
    }

    public int getReprobados_2() {
        return Reprobados_2;
    }

    public void setReprobados_2(int Reprobados_2) {
        this.Reprobados_2 = Reprobados_2;
    }

    public int getReprobados_3() {
        return Reprobados_3;
    }

    public void setReprobados_3(int Reprobados_3) {
        this.Reprobados_3 = Reprobados_3;
    }

    public int getReprobados_4() {
        return Reprobados_4;
    }

    public void setReprobados_4(int Reprobados_4) {
        this.Reprobados_4 = Reprobados_4;
    }

    public int getReprobados_5() {
        return Reprobados_5;
    }

    public void setReprobados_5(int Reprobados_5) {
        this.Reprobados_5 = Reprobados_5;
    }

    public double getAprobados() {
        return aprobados;
    }

    public void setAprobados(double aprobados) {
        this.aprobados = aprobados;
    }

    public double getReprobados() {
        return reprobados;
    }

    public void setReprobados(double reprobados) {
        this.reprobados = reprobados;
    }

}
