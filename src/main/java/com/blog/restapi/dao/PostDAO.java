package com.blog.restapi.dao;

import com.blog.restapi.models.Post;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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