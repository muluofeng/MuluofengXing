package com.example.xing.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限表
 *
 * @author xiexingxing
 * @Created by 2018-09-04 下午11:23.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "auth_permission")
public class Permission implements Serializable {
    private static final long    serialVersionUID = 1421374377807514073L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private              Integer id;
    @Column(name = "permission_name")
    private              String  permissionName;
    @Column(name = "permission_code")
    private              String  permissionCode;
}
