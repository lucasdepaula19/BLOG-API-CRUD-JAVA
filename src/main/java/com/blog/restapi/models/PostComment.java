package com.blog.restapi.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.util.List;

public class PostComment implements Serializable {

    private Post postagem;
    private List<Comment> comentarios;

    public Post getPostagem() {
        return postagem;
    }

    public void setPostagem(Post postagem) {
        this.postagem = postagem;
    }

    public List<Comment> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comment> comentarios) {
        this.comentarios = comentarios;
    }

}