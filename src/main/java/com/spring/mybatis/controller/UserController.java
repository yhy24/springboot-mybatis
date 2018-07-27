package com.spring.mybatis.controller;

import com.spring.mybatis.bean.User;
import com.spring.mybatis.dao.UserDao;
import com.spring.mybatis.mapper.ConfigMapper;
import com.spring.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yhy
 * @Date: 2018/7/25 16:09
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    ConfigMapper configMapper;

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @RequestMapping("/select/{id}")
    public User selectUser(@PathVariable("id") Integer id) {
        User user = configMapper.selectUserById(id);
        return user;
    }

    @RequestMapping("/cha/{id}")
    public User selectUserId(@PathVariable("id") Integer id) {
        User user = userService.selectUserId(id);
        return user;
    }
    @RequestMapping("/update")
    public User updateUserId() {
        User user = new User();
        user.setId(15);
        user.setMark("画画");
        user.setPhone("10086758");
        User user1 = userService.updateUserId(user);
        return user1;
    }

    public static void main(String[] args) {
        ConcurrentMapCache mapCache = new ConcurrentMapCache("redis");
        mapCache.put("yang","hao");
        System.out.println(mapCache.getName());
    }

}
