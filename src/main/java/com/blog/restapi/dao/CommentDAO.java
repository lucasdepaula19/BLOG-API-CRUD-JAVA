package com.blog.restapi.dao;

import com.blog.restapi.models.Comment;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CommentDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Comment.findAll", Comment.class).getResultList();
    }

    public Comment findById(Long id) {
        return em.find(Comment.class, id);
    }

    public void update(Comment comment) {
        em.merge(comment);
    }

    public void create(Comment comment) {
        em.persist(comment);
    }

    public void delete(Comment comment) {
        if (!em.contains(comment)) {
            comment = em.merge(comment);
        }

        em.remove(comment);
    }
}