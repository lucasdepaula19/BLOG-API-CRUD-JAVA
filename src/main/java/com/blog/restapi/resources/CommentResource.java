package com.blog.restapi.resources;

import com.blog.restapi.dao.CommentDAO;
import com.blog.restapi.models.Comment;
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
@Path("comments")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {

    @Inject
    CommentDAO commentDAO;

    @GET
    public Response getAll() {
        return Response.ok(commentDAO.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getComment(@PathParam("id") Long id) {
        Comment comment = commentDAO.findById(id);

        return Response.ok(comment).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Comment comment) {
        Comment updateComment = commentDAO.findById(id);

        updateComment.setDesc_comment(comment.getDesc_comment());
        commentDAO.update(updateComment);

        return Response.ok().build();
    }

    @POST
    public Response create(Comment comment) {
        commentDAO.create(comment);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Comment getComment = commentDAO.findById(id);
        
        commentDAO.delete(getComment);

        return Response.ok().build();
    }

}