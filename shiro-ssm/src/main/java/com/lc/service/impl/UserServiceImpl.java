package com.lc.service.impl;

import com.lc.bean.RoleBean;
import com.lc.dao.RoleDao;
import com.lc.dao.UserDao;
import com.lc.pojo.Role;
import com.lc.pojo.User;
import com.lc.service.UserService;
import com.lc.util.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.lc.service.impl
 * @ClassName: UserServiceImpl
 * @Author: liuchen
 * @Date: 2020/1/8 11:01
 * @Description: //TODO
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Override
    public User getUserByUserName(String userName) {

        return userDao.getUserByUserName(userName);
    }

    @Override
    public User getLogin(String name, String password) {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(userDao);
        UsernamePasswordToken token=new UsernamePasswordToken(name,password);
        try {
            subject.login(token);
            Session session = subject.getSession();
            User sessionUser = this.getUserByUserName(name);
            session.setAttribute(Constants.SESSION_USER,sessionUser);
            return sessionUser;
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getUserByPages(Integer currentPage, Integer lineSize) {
        Integer from =(currentPage-1)*lineSize;
        return this.userDao.getUserByPage(from,lineSize);
    }

    @Override
    public int getCount() {
        return this.userDao.getCount();
    }

    @Override
    public int getTotalPage(Integer count, Integer lineSize) {
        return count%lineSize==0?count/lineSize:count/lineSize+1;
    }

    @Override
    public List<RoleBean> getRoleBeansByUserId(Integer userId) {
        List<RoleBean> all=new ArrayList<>();
        //通过用户id,查询该用户所拥有的角色id的集合
        Integer[] roleIds=this.roleDao.getRoleIdsByUserId(userId);
        //查询系统中的所有角色
        List<Role> roleAll=this.roleDao.getAllRoles();
        if (roleAll!=null&&!roleAll.isEmpty()){
            for (Role role : roleAll) {
                RoleBean roleBean = new RoleBean();
                roleBean.setRole(role);
                for (int i = 0; i <roleIds.length; i++) {
                    if (roleIds[i] == role.getId()) {
                        roleBean.setChecked("checked='checked'");
                    }
                }
                all.add(roleBean);
            }
        }
        return all;
    }

    @Override
    public boolean assignRoleByUserId(Integer userId, String roleArray) {
        boolean flag=false;
        try {
            this.roleDao.delete(userId);
            String[] roleIds = roleArray.split(",");
            if (roleIds!=null&&roleIds.length>0){
                for (String roleId : roleIds) {
                    int roleInt = Integer.parseInt(roleId);
                    Map<String,Integer> params=new HashMap<>();
                    params.put("userId",userId);
                    params.put("roleId",roleInt);
                    this.roleDao.save(params);
                }
            }
            flag=true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
