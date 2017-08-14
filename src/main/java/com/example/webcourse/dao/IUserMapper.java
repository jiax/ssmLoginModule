package com.example.webcourse.dao;

import com.example.webcourse.model.User;

/**
 * Created by jiaxin on 2017/8/1.
 */
public interface IUserMapper {
    public User selectById(int id);

    public User selectByName(String name);
}
