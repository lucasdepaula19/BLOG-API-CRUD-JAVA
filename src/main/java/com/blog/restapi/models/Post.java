package com.blog.restapi.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "posts")
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT t FROM Post t")
})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String task;
    private String description;
    /* private String teste; */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

/*     public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    } */

    @Override
    public String toString() {
        return "Post{" + "id=" + id + ", task=" + task + ", description=" + description + /* ", teste=" + teste + */ '}';
    }

}