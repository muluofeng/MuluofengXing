package com.example.xing.service;

import com.example.xing.dao.UserDAO;
import com.example.xing.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * @author xiexingxing
 * @Created by 2018-09-06 上午12:16.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public User findByName(String name) {
        return userDAO.findByUsername(name);
    }


    public User findByid(Integer id) throws Exception {
        Optional<User> user = userDAO.findById(id);
        if (!user.isPresent()) {
            throw new Exception("user not found: " + id);
        } else {
            return user.get();
        }
    }


    public User save(User user) {
        Assert.notNull(user.getUsername(),"用户名不能为空");
        User save = userDAO.save(user);
        return save;
    }

    public void deleteById(Integer id){
        userDAO.deleteById(id);
    }
}
