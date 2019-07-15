package com.example.xing.service;

import com.example.xing.dao.RoleDAO;
import com.example.xing.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author xiexingxing
 * @Created by 2018-12-03 9:14 PM.
 */
@Service
public class RoleService {
    @Autowired
    private RoleDAO dao;


    public Role addRole(Role role) {
        dao.save(role);
        return role;
    }

    public Role findById(Integer id) {
        Optional<Role> role = dao.findById(id);
        if (role.isPresent()) {
            return role.get();
        }
        return null;
    }

    public Page<Role> findAll(Pageable page) {
        return dao.findAll(page);
    }

    public List<Role> findAll() {
        return dao.findAll();
    }

    public void delete(Integer id) {
        dao.deleteById(id);
    }


}
