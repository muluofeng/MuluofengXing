package com.example.xing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 *
 * @author xiexingxing
 * @Created by 2018-09-04 下午11:19.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auth_user")
//@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="id")

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String  username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String  password;
    private Boolean locked;
    private String  salt;
    @Column(name = "lastpasswordresetdate")
    private Date    lastPasswordResetDate;


    //多对多的关系，说明一个用户可以有多个角色，使用集合
    //多对多的三个条件： 中间表，本实体类对应的表在中间表的外键字段，关联表在中间表的外键字段
    /*
     * @JoinTable注解说明，用于配置多对多的中间表的关联关系
     * name: 表示指定中间表的表名
     * joinColumns:本实体类对应的表在中间表的外键字段
     *
     */

    //FetchType.EAGER 和 FetchType.LAZY  懒加载，实际用到才会去查询
    @ManyToMany(cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JoinTable(name = "auth_user_role",  //代表 关联表
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName="id"),// 字段"user_id"为外键关联到user表中的id字段
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName="id") //  字段"role_id"为外键关联到role表中的id字段
    )
    private List<Role> roles;
}
