package com.lc.service;

import com.lc.bean.RoleBean;
import com.lc.pojo.User;

import java.util.List;

public interface UserService {
    public User getUserByUserName(String userName);
    public User getLogin(String name,String password);
    //分页列表
    public List<User> getUserByPages( Integer currentPage,Integer lineSize);
    //获取记录数
    public int getCount();
    //总页数
    public int getTotalPage(Integer count,Integer lineSize);
    //展现指定用户所拥有的角色集合
    public List<RoleBean> getRoleBeansByUserId(Integer userId);
    public boolean assignRoleByUserId(Integer userId,String roleArray);

}
