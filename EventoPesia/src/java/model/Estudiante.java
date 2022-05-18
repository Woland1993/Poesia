/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Woland
 */
public class Estudiante {
private int id_estudiante;
private String carnet;
private String nombren;
private String segundo_nombre;
private String apellido ;
private String segundo_apellido;
private String genero;
private int telefono;
private String fecha_nacimiento;
private String carrera;
private String genero_poesia;
private String fecha_inscripcion;
private String fecha_final;

    public Estudiante() {
    }

    public Estudiante(int id_estudiante, String carnet, String nombren, String segundo_nombre, String apellido, String segundo_apellido, String genero, int telefono, String fecha_nacimiento, String carrera, String genero_poesia, String fecha_inscripcion, String fecha_final) {
        this.id_estudiante = id_estudiante;
        this.carnet = carnet;
        this.nombren = nombren;
        this.segundo_nombre = segundo_nombre;
        this.apellido = apellido;
        this.segundo_apellido = segundo_apellido;
        this.genero = genero;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.carrera = carrera;
        this.genero_poesia = genero_poesia;
        this.fecha_inscripcion = fecha_inscripcion;
        this.fecha_final = fecha_final;
    }

    public Estudiante
 ( String carnet, String nombren, String segundo_nombre, String apellido, String segundo_apellido,
         String genero, int telefono, String fecha_nacimiento, String carrera, String genero_poesia) {
        this.carnet = carnet;
        this.nombren = nombren;
        this.segundo_nombre = segundo_nombre;
        this.apellido = apellido;
        this.segundo_apellido = segundo_apellido;
        this.genero = genero;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.carrera = carrera;
        this.genero_poesia = genero_poesia;
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombren() {
        return nombren;
    }

    public void setNombren(String nombren) {
        this.nombren = nombren;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getGenero_poesia() {
        return genero_poesia;
    }

    public void setGenero_poesia(String genero_poesia) {
        this.genero_poesia = genero_poesia;
    }

    public String getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(String fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }


}
