package com.web.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.web.model.user.User;
import com.web.web.model.user.UserDao;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    public User findUser(@PathVariable("userId") String id){
        User user = userDao.findUserWithId(id);
        return user;
    }

    @RequestMapping("/user/sign-up")
    public User userSignUp(@RequestBody User user){
        User finder = userDao.findUserWithId(user.getId());
        if(finder == null){
            userDao.addUser(user);
            return user;
        }
        else
            return null;
    }

    @PostMapping("/signIn")
    public String signIn(String inputId, String inputPw) {
        User user = userDao.findUserWithId(inputId);
        if(user != null && user.getPw().compareTo(inputPw) == 0) {
            return "loginOK";
        }
        return "loginFail";
    }

    @RequestMapping("/signUp")
    public String signUp() {
        return "signup";
    }
    
}
