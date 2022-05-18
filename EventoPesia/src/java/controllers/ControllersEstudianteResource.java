/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dto.Response;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Estudiante;
import org.json.JSONArray;
import org.json.JSONObject;
import repository.RepositoryEstudiante;
import repository.Utilidad;

/**
 * REST Web Service
 *
 * @author Woland
 */
@Path("ControllersEstudiante")
public class ControllersEstudianteResource extends RepositoryEstudiante {

    @Context
    private UriInfo context;

    public ControllersEstudianteResource() {

    }

    /**
     * Creates a new instance of ControllersEstudianteResource
     */
    /**
     * Retrieves representation of an instance of
     * controllers.ControllersEstudianteResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() throws SQLException {
        try {
            return this.list().toString();
        } catch (SQLException e) {
        } finally {
            this.cerrarConeccion();
        }
        return null;
    }

    /**
     * PUT method for updating or creating an instance of
     * ControllersEstudianteResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String putJson(String content) {

        return null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("created")
    public String create(Estudiante e) {
        Utilidad u = new Utilidad();
        Response r = new Response();
        if (!u.validarCarnet(e.getCarnet())) {
            r.setError(true);
            r.setMessaje("Carnet Ivalido");
            return new JSONObject(r).toString();
        } else if (!u.validarGenero(e.getGenero())) {
            r.setError(true);
            r.setMessaje("Genero Ivalido");
            return new JSONObject(r).toString();
        } else {
            try {
                r.setEstudiante(new JSONObject(this.insertar(e)));
                return new JSONObject(r).toString();
            } catch (SQLException ex) {
                r.setError(true);
                r.setMessaje("El registro ya existe");
                return new JSONObject(r).toString();
            } finally {
                this.cerrarConeccion();
            }
        }
    }

}
