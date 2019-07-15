package com.example.xing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 角色表
 * @author xiexingxing
 * @Created by 2018-09-04 下午11:22.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auth_role")
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Role implements Serializable {
    private static final long serialVersionUID = 3904243294762453389L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "role_code")
    private String roleCode;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnoreProperties(value = "roles")
    List<User> users = Lists.newArrayList();
}


