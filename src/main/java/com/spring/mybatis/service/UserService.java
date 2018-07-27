package com.spring.mybatis.service;

import com.spring.mybatis.bean.User;


/**
 * @Author: yhy
 * @Date: 2018/7/25 16:34
 * @Version 1.0
 */
public interface UserService {
    public User selectUserId(Integer id);

    public User updateUserId(User user);
}
