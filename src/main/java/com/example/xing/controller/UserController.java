package com.example.xing.controller;

import com.example.xing.model.User;
import com.example.xing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xiexingxing
 * @Created by 2018-09-12 下午11:44.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping(
            value = "/{Id}",
            produces = "application/json"
    )
    public User get(@PathVariable("Id") Integer id) {
        User user = null;
        try {
            user = userService.findByid(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
