package com.example.appregistrocovid.DTO;

import java.util.Date;

public class Paciente {

    private int id, presion, sintomas, tos,estado;
    private String nombre, apellido, rut, area, fechaExamen;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPresion() {
        return presion;
    }

    public void setPresion(int presion) {
        this.presion = presion;
    }

    public int getSintomas() {
        return sintomas;
    }

    public void setSintomas(int sintomas) {
        this.sintomas = sintomas;
    }

    public int getTos() {
        return tos;
    }

    public void setTos(int tos) {
        this.tos = tos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(String fechaExamen) {
        this.fechaExamen = fechaExamen;
    }
}