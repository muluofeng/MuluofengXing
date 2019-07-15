package com.example.xing.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 角色权限关联表
 * @author xiexingxing
 * @Created by 2018-09-04 下午11:26.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "auth_role_permission")
public class RolePermission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "role_id")
    private Integer roleId;
    @Column(name = "permission_id")
    private Integer permissionId;
}
