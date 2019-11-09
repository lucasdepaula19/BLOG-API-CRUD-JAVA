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
@Table(name = "comments")
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT t FROM Comment t")
})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String desc_comment;
    private Long id_post_comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc_comment() {
        return desc_comment;
    }

    public void setDesc_comment(String desc_comment) {
        this.desc_comment = desc_comment;
    }

    public Long getId_post_comment() {
        return id_post_comment;
    }

    public void setId_post_comment(Long id_post_comment) {
        this.id_post_comment = id_post_comment;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", desc_comment=" + desc_comment + ", id_post_comment=" + id_post_comment + '}';
    }

}