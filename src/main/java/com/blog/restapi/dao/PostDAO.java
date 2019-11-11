package com.blog.restapi.dao;

import com.blog.restapi.models.Post;
import com.blog.restapi.models.Comment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class PostDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Post.findAll", Post.class).getResultList();
    }

    public Post findById(Long id) {
        return em.find(Post.class, id);
    }

    public List<Post> findByAutor(Long id) {
        //Query para retornar todas as postagens de um autor
        TypedQuery<Post> query = em.createQuery("SELECT t FROM Post t WHERE t.id_autor_post = :id", Post.class);
        List<Post> resultsPost = query.setParameter("id", id).getResultList();

        for(Post result : resultsPost){
            Long id_Postagem = result.getId();
            //Query para retornar todos comentários de uma postagem
            TypedQuery<Comment> queryComment = em.createQuery("SELECT t FROM Comment t WHERE t.id_post_comment = :id_Postagem", Comment.class);
            List<Comment> resultsComment = queryComment.setParameter("id_Postagem", id_Postagem).getResultList();
   
            
           // System.out.println(resultsComment);
        }

        return resultsPost;
    }

    public void update(Post post) {
        em.merge(post);
    }

    public void create(Post post) {
        em.persist(post);
    }

    public void delete(Post post) {
        if (!em.contains(post)) {
            post = em.merge(post);
        }

        em.remove(post);
    }
}