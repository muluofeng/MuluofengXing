package com.example.xing.service;

import com.example.xing.dao.UserDAO;
import com.example.xing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiexingxing
 * @Created by 2018-09-06 上午12:16.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;
     public User findByName(String name){
         return userDAO.findByUsername(name);
     }
}
