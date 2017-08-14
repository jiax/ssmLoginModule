package com.example.webcourse.service;

import com.example.webcourse.dao.IUserMapper;
import com.example.webcourse.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jiaxin on 2017/8/1.
 */
@Service("LoginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    IUserMapper userMapper;

    @Override()
    public boolean login(String name,String password) {
        User user = userMapper.selectByName(name);
        if(user == null){
            //用户不存在
            return false;
        }
        if(!password.equals(user.getPassword())){
            //密码不对
            return false;
        }
        if(name.equals(user.getUsername())){
            //登陆成功

            return true;
        }
        return false;
    }
}
