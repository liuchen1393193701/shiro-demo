package com.lc.service.impl;

import com.lc.Utils.MybatisUtils;
import com.lc.dao.UserDAO;
import com.lc.service.UserService;
import org.apache.ibatis.session.SqlSession;

import java.util.Set;

public class UserServiceImpl  implements UserService {
    private UserDAO userDAO;
    public UserServiceImpl(){
        SqlSession session= MybatisUtils.getSession();
        System.out.println("wodei");
        userDAO=session.getMapper(UserDAO.class);
    }
    @Override
    public String getPasswordByUserName(String userName) {

        return userDAO.getPasswordByUserName(userName);
    }

    @Override
    public Set<String> getRoleNameByUserName(String userName) {
        return userDAO.getRoleNameByUserName(userName);
    }

    @Override
    public Set<String> getPermissionNamesByUserName(String userName) {
        return this.userDAO.getPermissionNamesByUserName(userName);
    }
}
