package com.blog.restapi.resources;

import com.blog.restapi.dao.AutorDAO;
import com.blog.restapi.models.Autor;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("autors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AutorResource {

    @Inject
    AutorDAO autorDAO;

    @GET
    public Response getAll() {
        return Response.ok(autorDAO.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getAutor(@PathParam("id") Long id) {
        Autor autor = autorDAO.findById(id);

        return Response.ok(autor).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Autor autor) {
        Autor updateAutor = autorDAO.findById(id);

        updateAutor.setName(autor.getName());
        autorDAO.update(updateAutor);

        return Response.ok().build();
    }

    @POST
    public Response create(Autor autor) {
        autorDAO.create(autor);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Autor getAutor = autorDAO.findById(id);
        
        autorDAO.delete(getAutor);

        return Response.ok().build();
    }

}