package com.example.xing.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 用户角色关联表
 * @author xiexingxing
 * @Created by 2018-09-04 下午11:25.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auth_user_role")
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "role_id")
    private Integer roleId;
}
