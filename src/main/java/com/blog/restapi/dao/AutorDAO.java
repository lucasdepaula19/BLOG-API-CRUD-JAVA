package com.blog.restapi.dao;

import com.blog.restapi.models.Autor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AutorDAO {

    @PersistenceContext(unitName = "restapi_PU")
    EntityManager em;

    public List getAll() {
        return em.createNamedQuery("Autor.findAll", Autor.class).getResultList();
    }

    public Autor findById(Long id) {
        return em.find(Autor.class, id);
    }

    public void update(Autor autor) {
        em.merge(autor);
    }

    public void create(Autor autor) {
        em.persist(autor);
    }

    public void delete(Autor autor) {
        if (!em.contains(autor)) {
            autor = em.merge(autor);
        }

        em.remove(autor);
    }
}