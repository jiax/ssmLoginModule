package com.example.webcourse;

import com.example.webcourse.dao.IUserMapper;
import com.example.webcourse.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jiaxin on 2017/8/1.
 */
public class test {
    private static ApplicationContext ac;
    static{
        ac = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args) {
        IUserMapper dao = (IUserMapper) ac.getBean("IUserMapper");

        User user = dao.selectByName("bob");
        System.out.println(user.getId()+":"+"username:"+user.getUsername());
        System.out.println("password:"+user.getPassword());
    }
}
