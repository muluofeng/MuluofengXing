package com.example.xing.controller;

import com.example.xing.model.Role;
import com.example.xing.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiexingxing
 * @Created by 2018-12-03 9:12 PM.
 */
@Controller
@RequestMapping("/role")
public class RoleController {


    @Autowired
    RoleService roleService;

    @ResponseBody
    @PostMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    @PreAuthorize("hasRole('ADMIN')")
    public Role post(@RequestBody Role Role) {
        return roleService.addRole(Role);
    }


    @ResponseBody
    @GetMapping(
            value = "/{Id}",
            produces = "application/json"
    )
    @PreAuthorize("hasRole('ADMIN')")
    public Role get(@PathVariable("Id") Integer id) {
        return roleService.findById(id);
    }


    @ResponseBody
    @GetMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    @PreAuthorize("hasRole('ADMIN')")
    public Page<Role> getAll(
            @RequestParam(value = "paseSize",required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(value = "currentPage",required = false,defaultValue = "0") Integer currentPage) {
        Pageable page = PageRequest.of(currentPage, pageSize);
        return roleService.findAll(page);
    }

    @ResponseBody
    @DeleteMapping(
            value = "/{Id}",
            produces = "application/json",
            consumes = "application/json"
    )
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable("Id") Integer id) {
        roleService.delete(id);
    }


}
