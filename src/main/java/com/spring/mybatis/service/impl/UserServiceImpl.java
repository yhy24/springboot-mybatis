package com.spring.mybatis.service.impl;

import com.spring.mybatis.bean.User;
import com.spring.mybatis.dao.UserDao;
import com.spring.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


/**
 * @Author: yhy
 * @Date: 2018/7/25 16:35
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Cacheable(value = "user")//使用缓存的的使用
    @Override
    public User selectUserId(Integer id) {
        System.out.println("------查询---"+id+"--");
        User user =userDao.selectUserId(id);
        return user;
    }
    @CachePut(value = "user")
    @Override
    public User updateUserId(User user) {
        System.out.println("------查询---"+user.toString()+"--");
        userDao.updateUserById(user);
        return user;
    }

}
