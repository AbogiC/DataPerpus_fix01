package com.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_role")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    private Integer id;
    @Column(name = "role", nullable = false)
    private String role;
}
