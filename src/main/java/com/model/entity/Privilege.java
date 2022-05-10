package com.model.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_privilege")
public class Privilege {
    @Id
    @Column(name = "id_privilege", nullable = false)
    private Integer id;
    @Column(name = "privilege", nullable = false)
    private String priv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriv() {
        return priv;
    }

    public void setPriv(String priv) {
        this.priv = priv;
    }
}
