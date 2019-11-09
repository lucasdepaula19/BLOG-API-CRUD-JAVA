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
@Table(name = "x_posts")
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT t FROM Post t")
})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title_post;
    private String desc_post;
    private Long id_autor_post;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle_post() {
        return title_post;
    }

    public void setTitle_post(String title_post) {
        this.title_post = title_post;
    }

    public String getDesc_post() {
        return desc_post;
    }

    public void setDesc_post(String desc_post) {
        this.desc_post = desc_post;
    }

    public Long getId_autor_post() {
        return id_autor_post;
    }

    public void setId_autor_post(Long id_autor_post) {
        this.id_autor_post = id_autor_post;
    }

    @Override
    public String toString() {
       return "Post{" + "id=" + id + ", title_post=" + title_post + ", desc_post=" + desc_post + ", id_autor_post=" + id_autor_post + '}';
    }
}