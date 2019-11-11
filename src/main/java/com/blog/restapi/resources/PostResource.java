package com.blog.restapi.resources;

import com.blog.restapi.dao.PostDAO;
import com.blog.restapi.models.Post;
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
import java.util.List;

@RequestScoped
@Path("posts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject
    PostDAO postDAO;

    @GET
    public Response getAll() {
        return Response.ok(postDAO.getAll()).build();
    }

    @GET
    @Path("{id}")
    public Response getPost(@PathParam("id") Long id) {
        Post post = postDAO.findById(id);

        return Response.ok(post).build();
    }

    @GET
    @Path("/author/{id}")
    public Response getPostAutor(@PathParam("id") Long id) {
        List<Post> post = postDAO.findByAutor(id);

        return Response.ok(post).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, Post post) {
        Post updatePost = postDAO.findById(id);

        updatePost.setTitle_post(post.getTitle_post());
        updatePost.setDesc_post(post.getDesc_post());
        updatePost.setId_autor_post(post.getId_autor_post());
        postDAO.update(updatePost);

        return Response.ok().build();
    }

    @POST
    public Response create(Post post) {
        postDAO.create(post);
        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Post getPost = postDAO.findById(id);
        
        postDAO.delete(getPost);

        return Response.ok().build();
    }

}