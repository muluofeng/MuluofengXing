package com.example.xing.controller;

import com.example.xing.model.Permission;
import com.example.xing.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xiexingxing
 * @Created by 2018-09-08 下午10:57.
 */
@Controller
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @ResponseBody
    @PostMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    public Permission post(@RequestBody Permission permission) {
        return permissionService.addPermission(permission);
    }


    @ResponseBody
    @GetMapping(
            value = "/{Id}",
            produces = "application/json"
    )
    @PreAuthorize("hasRole('ADMIN')")
    public Permission get(@PathVariable("Id") Integer id) {
        return permissionService.findById(id);
    }


    @ResponseBody
    @GetMapping(
            produces = "application/json",
            consumes = "application/json"
    )
    @PreAuthorize("hasRole('ADMIN')")
    public Page<Permission> getAll(
            @RequestParam(value = "paseSize",required = false,defaultValue = "10") Integer pageSize,
            @RequestParam(value = "currentPage",required = false,defaultValue = "0") Integer currentPage) {
        Pageable page = PageRequest.of(currentPage, pageSize);
        return permissionService.findAll(page);
    }

    @ResponseBody
    @DeleteMapping(
            value = "/{Id}",
            produces = "application/json",
            consumes = "application/json"
    )
    public void delete(@PathVariable("Id") Integer id) {
        permissionService.delete(id);
    }


}
