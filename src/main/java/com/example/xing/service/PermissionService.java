package com.example.xing.service;

import com.example.xing.dao.PermissionDAO;
import com.example.xing.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author xiexingxing
 * @Created by 2018-09-08 下午11:02.
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionDAO permissionDAO;


    public Permission addPermission(Permission permission) {
        permissionDAO.save(permission);
        return permission;
    }

    public Permission findById(Integer id) {
        Optional<Permission> optionalPermission = permissionDAO.findById(id);
        if (optionalPermission.isPresent()) {
            return optionalPermission.get();
        }
        return null;
    }

    public Page<Permission> findAll(Pageable page) {
        return permissionDAO.findAll(page);
    }

    public void delete(Integer id) {
        permissionDAO.deleteById(id);
    }


}
