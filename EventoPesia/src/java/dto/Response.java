/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import model.Estudiante;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Woland
 */
public class Response {

    private boolean error;
    private String messaje;
    private JSONArray estudiantes;
    private JSONObject estudiante;

    public Response() {
    }
    public Response(boolean error, String messaje) {
        this.error = error;
        this.messaje = messaje;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessaje() {
        return messaje;
    }

    public void setMessaje(String messaje) {
        this.messaje = messaje;
    }

    public JSONArray getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(JSONArray estudiantes) {
        this.estudiantes = estudiantes;
    }

    public JSONObject getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(JSONObject estudiante) {
        this.estudiante = estudiante;
    }

}
