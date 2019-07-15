package com.example.xing.service;

import com.example.xing.model.Role;
import com.example.xing.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author xiexingxing
 * @Created by 2018-12-05 12:13 PM.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private  UserService userService;
    @Autowired
    private RoleService roleService;

    @Test
    public void addUser(){
        List<Role> roles =  roleService.findAll();


        User user = new User();
        user.setUsername("test2");
        user.setPassword("xxxx");
        user.setLocked(false);
        user.setSalt("salt");
        user.setRoles(roles);
        User save = userService.save(user);
        System.out.println(save);
    }


    public void updateUser(){
        User user = userService.findByName("test2");
        List<Role> roles = roleService.findAll();
        roles.remove(0);
        user.setRoles(roles);
        User save = userService.save(user);
    }

    @Test
    public void findOne(){
        User user = userService.findByName("test2");
        System.out.println(user.getRoles());
        System.out.println(user.toString());
    }

    @Test
    public void delete(){
        Integer id = 33;
        userService.deleteById(id);
    }
}
