package com.spring.mybatis.dao;

import com.spring.mybatis.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: yhy
 * @Date: 2018/7/25 16:34
 * @Version 1.0
 */
@Mapper
public interface UserDao {
    public User selectUserId(Integer id);

    public void updateUserById(User user);
}
